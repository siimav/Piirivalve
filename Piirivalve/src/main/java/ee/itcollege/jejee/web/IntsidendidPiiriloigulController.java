package ee.itcollege.jejee.web;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(method = RequestMethod.GET)
    public String show(HttpServletRequest httpServletRequest, Model uiModel) {
		Piirivalvur_intsidendis_abi pi = new Piirivalvur_intsidendis_abi();
		uiModel.addAttribute("piirivalvur_intsidendis_abi", pi);
		uiModel.addAttribute("piirivalvur_intsidendis", Piirivalvur_intsidendis.findAllPiirivalvur_intsidendises());
		uiModel.addAttribute("piiriloiks", Piiriloik.findAllPiiriloiks());
		uiModel.addAttribute("intsidents", Intsident.findAllIntsidents());
        return "intsidendid_piiriloigul/ipiir";
    }
	
	
	@RequestMapping(method = RequestMethod.POST)
    public String post(HttpServletRequest httpServletRequest, Model uiModel, Piirivalvur_intsidendis_abi pia, BindingResult result) {
		
		uiModel.addAttribute("piiriloiks", Piiriloik.findAllPiiriloiks());
		
		System.out.println(pia.getAlates().toString());
		System.out.println(pia.getPiiriloik().toString());
		return "intsidendid_piiriloigul/ipiir";
	}
	
	
}

