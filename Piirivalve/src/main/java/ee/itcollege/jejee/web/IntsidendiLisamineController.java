package ee.itcollege.jejee.web;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.jejee.entities.Intsident;


@RequestMapping("/create")
@Controller
public class IntsidendiLisamineController {

	@PersistenceContext
	EntityManager entityManager;
	
	
//	@RequestMapping(value = "/{intsident_ID}", method = RequestMethod.GET)
//    public String show(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
//    	Intsident i = Intsident.findIntsident(intsident_ID);
//    	System.out.println(i.getNimetus());
//        uiModel.addAttribute("intsident", i);
//        return "intsidendi_lisamine/update";
//    }

	@SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.GET)
    public String uus(HttpServletRequest httpServletRequest, Model uiModel) {
		
		uiModel.addAttribute("intsidents", Intsident.findAllIntsidents());
        return "intsidendi_lisamine/create";
    }
	
//	http://levelup.lishman.com/spring/form-processing/validation.php
	
	
}

