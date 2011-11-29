package ee.itcollege.jejee.web;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.jejee.entities.Intsidendi_liik;
import ee.itcollege.jejee.entities.Intsident;
import ee.itcollege.jejee.entities.Piiriloik;


@RequestMapping("/reg")
@Controller
public class IntsidendiRegistreerimineController {
	
	 @Autowired
     private RegistrationValidation registrationValidation;

     public void setRegistrationValidation(
                     RegistrationValidation registrationValidation) {
             this.registrationValidation = registrationValidation;
     }

	@PersistenceContext
	EntityManager entityManager;
	
	@RequestMapping(method = RequestMethod.GET)
    public String show(Model uiModel) {
		Intsident i = new Intsident();
		uiModel.addAttribute("intsident", i);
		uiModel.addAttribute("intsidendi_liiks", Intsidendi_liik.findAllIntsidendi_liiks());
		uiModel.addAttribute("piiriloiks", Piiriloik.findAllPiiriloiks());
		uiModel.addAttribute("intsident_toimumise_algus_date_format", "yyyy-MM-dd");
        return "intsidendi_registreerimine/view";
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String post(HttpServletRequest httpServletRequest, Model uiModel, @Valid Intsident intsident, BindingResult result) {
		
		uiModel.addAttribute("intsidendi_liiks", Intsidendi_liik.findAllIntsidendi_liiks());
		uiModel.addAttribute("piiriloiks", Piiriloik.findAllPiiriloiks());
		
		//lisab andmebaasi uue kirje
		intsident.persist(); 
		
		registrationValidation.validate(intsident, result);
        if (result.hasErrors()) {
        	return "intsidendi_registreerimine/view";
        	
        }
        else{
        	return "redirect:/create";	//nÃ¤itab kÃµiki intsidente
        }
	}

}

