package ee.itcollege.jejee.web;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.taglibs.standard.tag.common.core.ParamSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.jejee.entities.Intsidendi_liik;
import ee.itcollege.jejee.entities.Intsident;
import ee.itcollege.jejee.entities.Piiriloik;
import ee.itcollege.jejee.entities.Piirivalvur_intsidendis;
import ee.itcollege.jejee.entities.Piirivalvur_intsidendis_abi;

@RequestMapping("/ipiir")
@Controller
public class IntsidendidPiiriloigulController {

	@PersistenceContext
	EntityManager entityManager;
	
	
//	@RequestMapping(value = "/{intsident_ID}", method = RequestMethod.GET)
//    public String show(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
//    	Intsident i = Intsident.findIntsident(intsident_ID);
//    	System.out.println(i.getNimetus());
//        uiModel.addAttribute("intsident", i);
//        return "intsidendi_lisamine/update";
//    }

	@RequestMapping(params = "form", method = RequestMethod.GET)
    public String show(HttpServletRequest httpServletRequest, Model uiModel) {
		System.out.println("joudis form()");
		Piirivalvur_intsidendis_abi pi = new Piirivalvur_intsidendis_abi();
		uiModel.addAttribute("piirivalvur_intsidendis_abi", pi);
		uiModel.addAttribute("piirivalvur_intsidendis", Piirivalvur_intsidendis.findAllPiirivalvur_intsidendises());
		uiModel.addAttribute("piiriloiks", Piiriloik.findAllPiiriloiks());
		uiModel.addAttribute("intsidents", Intsident.findAllIntsidents());
        return "intsidendid_piiriloigul/ipiir";
    }
	
	
	@RequestMapping(method = RequestMethod.GET)
    public String post(HttpServletRequest httpServletRequest, Model uiModel, Piirivalvur_intsidendis_abi pia, BindingResult result) {
		System.out.println("joudis tulemus");
		uiModel.addAttribute("piiriloiks", Piiriloik.findAllPiiriloiks());
		if(pia.getPiiriloik_ID()==0){ //--- valik (kuva kõik)
			if(pia.getAlates()!=null && pia.getKuni()!=null){ //comboväärtus 0, kuupäevad olemas
				uiModel.addAttribute("ints_piiriloigul_piirivalvur", Piirivalvur_intsidendis.findAllPiirivalvurIntsidentsWithInterval(pia.getAlates(), pia.getKuni()));
			}
			else uiModel.addAttribute("ints_piiriloigul_piirivalvur", Piirivalvur_intsidendis.findAllPiirivalvur_intsidendises());
		}
		else{
			if(pia.getAlates()==null && pia.getKuni()==null){
				uiModel.addAttribute("ints_piiriloigul_piirivalvur", Piirivalvur_intsidendis.findAllPiirivalvurIntsidentsForPiiriloik(Piiriloik.findPiiriloik(pia.getPiiriloik_ID())));
			}
			else {				
				uiModel.addAttribute("ints_piiriloigul_piirivalvur", Piirivalvur_intsidendis.findAllPiirivalvurIntsidentsForPiiriloikWithInterval(Piiriloik.findPiiriloik(pia.getPiiriloik_ID()), pia.getAlates(), pia.getKuni()));
			}
		}
		
	    //System.out.println("ALATES "+httpServletRequest.getParameter("alates"));
		//System.out.println("ALATES2 "+pia.getAlates().toString());
//		System.out.println(pia.getPiiriloik_ID().toString());
		return "intsidendid_piiriloigul/ipiir";
	}
	
	
}

