package ee.itcollege.jejee.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.jejee.entities.Intsident;
import ee.itcollege.jejee.entities.Isik_intsidendis;
import ee.itcollege.jejee.entities.Objekt;
import ee.itcollege.jejee.entities.Objekt_intsidendis;
import ee.itcollege.jejee.entities.Piiririkkuja;
import ee.itcollege.jejee.entities.Piirivalvur;
import ee.itcollege.jejee.entities.Piirivalvur_intsidendis;
import ee.itcollege.jejee.entities.Vahtkond;
import ee.itcollege.jejee.entities.Vahtkond_intsidendis;


@RequestMapping("/intsident")
@Controller
public class IntsidendiRedaktorController {

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
    private RedaktorValidation redaktorValidation;

    public void setRedaktorValidation(RedaktorValidation redaktorValidation) {
    	this.redaktorValidation = redaktorValidation;
    }
	
	@RequestMapping(value = "/{intsident_ID}", method = RequestMethod.GET)
    public String show(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
    	Intsident ints = Intsident.findIntsident(intsident_ID);
    	
    	Collection<Objekt_intsidendis> objektid_intsidendis = Objekt_intsidendis.findAllObjekt_intsidendisForIntsident(ints);
    	Collection<Isik_intsidendis> isikud_intsidendis = Isik_intsidendis.findAllIsik_intsidendisForIntsident(ints);
    	Collection<Vahtkond_intsidendis> vahtkonnad_intsidendis = Vahtkond_intsidendis.findAllVahtkonnadIntsidendisForIntsident(ints);
    	Collection<Piirivalvur_intsidendis> piirivalvurid_intsidendis = Piirivalvur_intsidendis.findAllPiirivalvurIntsidendisForIntsident(ints);
    	
        uiModel.addAttribute("intsident", ints);
        uiModel.addAttribute("objektid_intsidendis", objektid_intsidendis);
        uiModel.addAttribute("isikud_intsidendis", isikud_intsidendis);
        uiModel.addAttribute("vahtkonnad_intsidendis", vahtkonnad_intsidendis);
        uiModel.addAttribute("piirivalvurid_intsidendis", piirivalvurid_intsidendis);
        return "intsidendi_redaktor/view";
    }
	
	
	@RequestMapping(value = "/{intsident_ID}/lisa_piirivalvur", method = RequestMethod.GET)
    public String lisaPiirivalvur(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
		Intsident ints = Intsident.findIntsident(intsident_ID);
    	Collection<Piirivalvur> piirivalvurid = Piirivalvur.findAllPiirivalvuridNotInIntsident(ints);
    	Piirivalvur_intsidendis pi = new Piirivalvur_intsidendis();
    	
    	uiModel.addAttribute("piirivalvur_intsidendis", pi);
    	uiModel.addAttribute("id", intsident_ID);
        uiModel.addAttribute("piirivalvurid", piirivalvurid);
        uiModel.addAttribute("dateFormat", "yyyy-MM-dd");
        return "intsidendi_redaktor/add_piirivalvur";
    }
	
	
	@RequestMapping(value = "/{intsident_ID}/kustuta_piirivalvur/{pi_ID}", method = RequestMethod.GET)
    public String kustutaPiirivalvur(@PathVariable("intsident_ID") Long intsident_ID, @PathVariable("pi_ID") Long pi_ID,
    								 Model uiModel) {
		Piirivalvur_intsidendis pi = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(pi_ID);
		pi.remove();
		
        return "redirect:/intsident/" + intsident_ID;
    }
	
	
	@RequestMapping (value = "/{intsident_ID}/lisa_piirivalvur", method = RequestMethod.POST)
	public String submitPiirivalvur(Model uiModel, @PathVariable("intsident_ID") Long intsident_ID, Piirivalvur_intsidendis pi, BindingResult result, 
			@RequestParam(value="ids", required=false) String[] ids) throws CloneNotSupportedException {
		
		redaktorValidation.validate(pi, ids, result);
        if (result.hasErrors()) {
    		Intsident ints = Intsident.findIntsident(intsident_ID);
        	Collection<Piirivalvur> piirivalvurid = Piirivalvur.findAllPiirivalvuridNotInIntsident(ints);
        	
        	Collection<String> checked = new ArrayList<String>(piirivalvurid.size());
        	for (Piirivalvur piirivalvur : piirivalvurid) {
        		if(ids != null && Arrays.binarySearch(ids, Long.toString(piirivalvur.getId())) >= 0) {
        			checked.add("checked = \"checked\"");
                }
        		else {
        			checked.add("");
				}
			}

        	uiModel.addAttribute("id", intsident_ID);
            uiModel.addAttribute("piirivalvurid", piirivalvurid);
            uiModel.addAttribute("dateFormat", "yyyy-MM-dd");
            uiModel.addAttribute("checks", checked);
            
        	return "intsidendi_redaktor/add_piirivalvur";        	
        }
		
		if(ids != null) {
			Intsident ints = Intsident.findIntsident(intsident_ID);
			if(ints != null) {
				Piirivalvur_intsidendis tmp = (Piirivalvur_intsidendis) pi.clone();
				for (int i = 0; i < ids.length; i++) {
					Piirivalvur piirivalvur = Piirivalvur.findPiirivalvur(Long.parseLong(ids[i]));
					tmp.setIntsident(ints);
					tmp.setPiirivalvur(piirivalvur);
					tmp.setAvaja("Fedja");	//TODO
					tmp.setMuutja("Fedja");	//TODO
				}
				tmp.persist();
			}
		}
		
	    return "redirect:/intsident/" + intsident_ID;
	}
	
	
	@RequestMapping(value = "/{intsident_ID}/lisa_piiririkkuja", method = RequestMethod.GET)
    public String lisaPiiririkkuja(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
		Intsident ints = Intsident.findIntsident(intsident_ID);
    	Collection<Piiririkkuja> piiririkkujad = Piiririkkuja.findAllPiiririkkujadNotInIntsident(ints);
    	Isik_intsidendis ii = new Isik_intsidendis();
    	
    	uiModel.addAttribute("isik_intsidendis", ii);
    	uiModel.addAttribute("id", intsident_ID);
        uiModel.addAttribute("piiririkkujad", piiririkkujad);
        uiModel.addAttribute("dateFormat", "yyyy-MM-dd");
        return "intsidendi_redaktor/add_piiririkkuja";
    }
	
	
	@RequestMapping(value = "/{intsident_ID}/kustuta_piiririkkuja/{ii_ID}", method = RequestMethod.GET)
    public String kustutaPiiririkkuja(@PathVariable("intsident_ID") Long intsident_ID, @PathVariable("ii_ID") Long ii_ID,
    								 Model uiModel) {
		Isik_intsidendis ii = Isik_intsidendis.findIsik_intsidendis(ii_ID);
		ii.remove();
		
        return "redirect:/intsident/" + intsident_ID;
    }
	

	@RequestMapping (value = "/{intsident_ID}/lisa_piiririkkuja", method = RequestMethod.POST)
	public String submitPiiririkkuja(Model uiModel, @PathVariable("intsident_ID") Long intsident_ID, Isik_intsidendis ii, BindingResult result, 
			@RequestParam(value="ids", required=false) String[] ids) throws CloneNotSupportedException {
		
		redaktorValidation.validate(ii, ids, result);
        if (result.hasErrors()) {
    		Intsident ints = Intsident.findIntsident(intsident_ID);
    		Collection<Piiririkkuja> piiririkkujad = Piiririkkuja.findAllPiiririkkujadNotInIntsident(ints);
        	
        	Collection<String> checked = new ArrayList<String>(piiririkkujad.size());
        	for (Piiririkkuja piiririkkuja : piiririkkujad) {
        		if(ids != null && Arrays.binarySearch(ids, Long.toString(piiririkkuja.getId())) >= 0) {
        			checked.add("checked = \"checked\"");
                }
        		else {
        			checked.add("");
				}
			}

        	uiModel.addAttribute("id", intsident_ID);
        	uiModel.addAttribute("piiririkkujad", piiririkkujad);
            uiModel.addAttribute("dateFormat", "yyyy-MM-dd");
            uiModel.addAttribute("checks", checked);
            
        	return "intsidendi_redaktor/add_piiririkkuja";        	
        }
		
		if(ids != null) {
			Intsident ints = Intsident.findIntsident(intsident_ID);
			if(ints != null) {
				Isik_intsidendis tmp = (Isik_intsidendis) ii.clone();
				for (int i = 0; i < ids.length; i++) {
					Piiririkkuja piiririkkuja = Piiririkkuja.findPiiririkkuja(Long.parseLong(ids[i]));
					tmp.setIntsident(ints);
					tmp.setPiiririkkuja(piiririkkuja);
					tmp.setAvaja("Fedja");	//TODO
					tmp.setMuutja("Fedja");	//TODO
				}
				tmp.persist();
			}
		}
		
	    return "redirect:/intsident/" + intsident_ID;
	}
	
	
	@RequestMapping(value = "/{intsident_ID}/lisa_objekt", method = RequestMethod.GET)
    public String lisaObjekt(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
		Intsident ints = Intsident.findIntsident(intsident_ID);
    	Collection<Objekt> objektid = Objekt.findAllObjektidNotInIntsident(ints);
    	Objekt_intsidendis oi = new Objekt_intsidendis();
    	
    	uiModel.addAttribute("objekt_intsidendis", oi);
    	uiModel.addAttribute("id", intsident_ID);
        uiModel.addAttribute("objektid", objektid);
        uiModel.addAttribute("dateFormat", "yyyy-MM-dd");
        return "intsidendi_redaktor/add_objekt";
    }
	
	
	@RequestMapping(value = "/{intsident_ID}/kustuta_objekt/{oi_ID}", method = RequestMethod.GET)
    public String kustutaObjekt(@PathVariable("intsident_ID") Long intsident_ID, @PathVariable("oi_ID") Long oi_ID,
    								 Model uiModel) {
		Objekt_intsidendis oi = Objekt_intsidendis.findObjekt_intsidendis(oi_ID);
		oi.remove();
		
        return "redirect:/intsident/" + intsident_ID;
    }


	@RequestMapping (value = "/{intsident_ID}/lisa_objekt", method = RequestMethod.POST)
	public String submitObjekt(Model uiModel, @PathVariable("intsident_ID") Long intsident_ID, Objekt_intsidendis oi, BindingResult result, 
			@RequestParam(value="ids", required=false) String[] ids) throws CloneNotSupportedException {
		
		redaktorValidation.validate(oi, ids, result);
        if (result.hasErrors()) {
    		Intsident ints = Intsident.findIntsident(intsident_ID);
    		Collection<Objekt> objektid = Objekt.findAllObjektidNotInIntsident(ints);
        	
        	Collection<String> checked = new ArrayList<String>(objektid.size());
        	for (Objekt objekt : objektid) {
        		if(ids != null && Arrays.binarySearch(ids, Long.toString(objekt.getId())) >= 0) {
        			checked.add("checked = \"checked\"");
                }
        		else {
        			checked.add("");
				}
			}

        	uiModel.addAttribute("id", intsident_ID);
        	uiModel.addAttribute("objektid", objektid);
            uiModel.addAttribute("dateFormat", "yyyy-MM-dd");
            uiModel.addAttribute("checks", checked);
            
        	return "intsidendi_redaktor/add_objekt";        	
        }
		
		if(ids != null) {
			Intsident ints = Intsident.findIntsident(intsident_ID);
			if(ints != null) {
				Objekt_intsidendis tmp = (Objekt_intsidendis) oi.clone();
				for (int i = 0; i < ids.length; i++) {
					Objekt objekt = Objekt.findObjekt(Long.parseLong(ids[i]));
					tmp.setIntsident(ints);
					tmp.setObjekt(objekt);
					tmp.setAvaja("Fedja");	//TODO
					tmp.setMuutja("Fedja");	//TODO
				}
				tmp.persist();
			}
		}
		
	    return "redirect:/intsident/" + intsident_ID;
	}
	
	
	@RequestMapping(value = "/{intsident_ID}/lisa_vahtkond", method = RequestMethod.GET)
    public String lisaVahtkond(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
		Intsident ints = Intsident.findIntsident(intsident_ID);
    	Collection<Vahtkond> vahtkonnad = Vahtkond.findAllVahtkonnadNotInIntsident(ints);
    	Vahtkond_intsidendis vi = new Vahtkond_intsidendis();
    	
    	uiModel.addAttribute("vahtkond_intsidendis", vi);
    	uiModel.addAttribute("id", intsident_ID);
        uiModel.addAttribute("vahtkonnad", vahtkonnad);
        uiModel.addAttribute("dateFormat", "yyyy-MM-dd");
        return "intsidendi_redaktor/add_vahtkond";
    }
	
	
	@RequestMapping(value = "/{intsident_ID}/kustuta_vahtkond/{vi_ID}", method = RequestMethod.GET)
    public String kustutaVahtkond(@PathVariable("intsident_ID") Long intsident_ID, @PathVariable("vi_ID") Long vi_ID,
    								 Model uiModel) {
		Vahtkond_intsidendis vi = Vahtkond_intsidendis.findVahtkond_intsidendis(vi_ID);
		vi.remove();
		
        return "redirect:/intsident/" + intsident_ID;
    }


	@RequestMapping (value = "/{intsident_ID}/lisa_vahtkond", method = RequestMethod.POST)
	public String submitVahtkond(Model uiModel, @PathVariable("intsident_ID") Long intsident_ID, Vahtkond_intsidendis vi, BindingResult result, 
			@RequestParam(value="ids", required=false) String[] ids) throws CloneNotSupportedException {
		
		redaktorValidation.validate(vi, ids, result);
        if (result.hasErrors()) {
    		Intsident ints = Intsident.findIntsident(intsident_ID);
    		Collection<Vahtkond> vahtkonnad = Vahtkond.findAllVahtkonnadNotInIntsident(ints);
        	
        	Collection<String> checked = new ArrayList<String>(vahtkonnad.size());
        	for (Vahtkond vahtkond : vahtkonnad) {
        		if(ids != null && Arrays.binarySearch(ids, Long.toString(vahtkond.getId())) >= 0) {
        			checked.add("checked = \"checked\"");
                }
        		else {
        			checked.add("");
				}
			}

        	uiModel.addAttribute("id", intsident_ID);
        	uiModel.addAttribute("vahtkonnad", vahtkonnad);
            uiModel.addAttribute("dateFormat", "yyyy-MM-dd");
            uiModel.addAttribute("checks", checked);
            
        	return "intsidendi_redaktor/add_vahtkond";        	
        }
		
		if(ids != null) {
			Intsident ints = Intsident.findIntsident(intsident_ID);
			if(ints != null) {
				Vahtkond_intsidendis tmp = (Vahtkond_intsidendis) vi.clone();
				for (int i = 0; i < ids.length; i++) {
					Vahtkond vahtkond = Vahtkond.findVahtkond(Long.parseLong(ids[i]));
					tmp.setIntsident(ints);
					tmp.setVahtkond(vahtkond);
					tmp.setAvaja("Fedja");	//TODO
					tmp.setMuutja("Fedja");	//TODO
				}
				tmp.persist();
			}
		}
		
	    return "redirect:/intsident/" + intsident_ID;
	}
	
}

