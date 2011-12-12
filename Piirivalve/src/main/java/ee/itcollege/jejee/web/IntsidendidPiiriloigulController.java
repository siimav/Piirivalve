package ee.itcollege.jejee.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.jejee.entities.Intsident;
import ee.itcollege.jejee.entities.Piiriloik;
import ee.itcollege.jejee.entities.Piirivalvur_intsidendis;
import ee.itcollege.jejee.entities.Piirivalvur_intsidendis_abi;

@RequestMapping("/ipiir")
@Controller
public class IntsidendidPiiriloigulController {

	@PersistenceContext
	EntityManager entityManager;
	

	@RequestMapping(method = RequestMethod.GET)
    public String show(HttpServletRequest httpServletRequest, Model uiModel) {
		Piirivalvur_intsidendis_abi pi = new Piirivalvur_intsidendis_abi();
		uiModel.addAttribute("piirivalvur_intsidendis_abi", pi);
		uiModel.addAttribute("piirivalvur_intsidendis", Piirivalvur_intsidendis.findAllPiirivalvur_intsidendises());
		uiModel.addAttribute("piiriloiks", Piiriloik.findAllPiiriloiks());
		uiModel.addAttribute("intsidents", Intsident.findAllIntsidents());
        return "intsidendid_piiriloigul/ipiir";
    }
	
	
	@RequestMapping(params = "piiriloik_ID", method = RequestMethod.GET)
    public String post(HttpServletRequest httpServletRequest, Model uiModel, Piirivalvur_intsidendis_abi pia, BindingResult result) {
		
		uiModel.addAttribute("piiriloiks", Piiriloik.findAllPiiriloiks());
		
		List<Piirivalvur_intsidendis_abi> tmp;
		
		if(pia.getPiiriloik_ID()==0){ //--- valik (kuva kÃƒÂµik)
			if(pia.getAlates()!=null && pia.getKuni()!=null){ //combovÃƒÂ¤ÃƒÂ¤rtus 0, kuupÃƒÂ¤evad olemas
				tmp = korrasta(Piirivalvur_intsidendis.findAllPiirivalvurIntsidentsWithInterval(pia.getAlates(), pia.getKuni()));
			}
			else{
				tmp = korrasta(Piirivalvur_intsidendis.findAllPiirivalvur_intsidendises());
			}
		}
		else{
			if(pia.getAlates()==null && pia.getKuni()==null){
				tmp = korrasta(Piirivalvur_intsidendis.findAllPiirivalvurIntsidentsForPiiriloik(Piiriloik.findPiiriloik(pia.getPiiriloik_ID())));
			}
			else {	
				tmp = korrasta(Piirivalvur_intsidendis.findAllPiirivalvurIntsidentsForPiiriloikWithInterval(Piiriloik.findPiiriloik(pia.getPiiriloik_ID()), pia.getAlates(), pia.getKuni()));
			}
		}
		uiModel.addAttribute("ints_piiriloigul_piirivalvur", tmp);
		
		return "intsidendid_piiriloigul/ipiir";
	}


	private List<Piirivalvur_intsidendis_abi> korrasta(List<Piirivalvur_intsidendis> ints_arr) {
		Piirivalvur_intsidendis_abi tmp;
		Boolean olemas = false;
		List<Piirivalvur_intsidendis_abi> tmp_arr = new ArrayList<Piirivalvur_intsidendis_abi>();
		if(!ints_arr.isEmpty()){
			for (Piirivalvur_intsidendis pi : ints_arr) {
				olemas=false;
				for (Piirivalvur_intsidendis_abi pia : tmp_arr) { 
					if(pi.getPiirivalvur()==pia.getPiirivalvur()){ //kas sama piirivalvur juba olemas
						pia.getPints_arr().add(pi);
						pia.setKogus(pia.getKogus()+1);
						olemas=true;
					}
					
				}
				
				if(!olemas){
					tmp = new Piirivalvur_intsidendis_abi();
					tmp.setPiirivalvur(pi.getPiirivalvur());
					tmp.getPints_arr().add(pi);
					tmp.setKogus(1);
					tmp_arr.add(tmp);
				}
			}
		}
		return tmp_arr;
	}
	
	
}

