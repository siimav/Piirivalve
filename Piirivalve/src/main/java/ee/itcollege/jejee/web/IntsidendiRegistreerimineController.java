package ee.itcollege.jejee.web;

import java.util.Date;

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
        return "intsidendi_registreerimine/view";
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String post(HttpServletRequest httpServletRequest, Model uiModel, @Valid Intsident intsident, BindingResult result) {
//		
		System.out.println("Avaja: "+intsident.getAvaja());
		System.out.println("Avatud: "+intsident.getAvatud());
		
		//need tehakse reg.jsp's ära
		intsident.setAvaja("avaja");
		intsident.setAvatud(new Date());
		intsident.setSulgeja("sulgeja");
		intsident.setSuletud(new Date());
		intsident.setMuutja("muutja");
		intsident.setMuudetud(new Date());
		
		//intsident.persist();
		
		registrationValidation.validate(intsident, result);
        if (result.hasErrors()) {
        	//System.out.println(result.getFieldErrors());
        	//System.out.println(result.getAllErrors());
        	return "intsidendi_registreerimine/view"; //TODO: comboboxid uuesti väärtustads!!
        }
        else{
//		return "intsidendi_registreerimine/view";
		return "redirect:/create";	//nÃ¤itab kÃµiki intsidente
        }
	}

}

