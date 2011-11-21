package ee.itcollege.jejee.web;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.jejee.entities.Intsident;


@RequestMapping("/reg")
@Controller
public class IntsidendiRegistreerimineController {

	@PersistenceContext
	EntityManager entityManager;
	
	@RequestMapping(value = "/{intsident_ID}", method = RequestMethod.GET)
    public String show(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
    	Intsident i = Intsident.findIntsident(intsident_ID);
    	
    	uiModel.addAttribute("intsidents", Intsident.findAllIntsidents());
        //uiModel.addAttribute("intsident", i);
        return "intsidendi_registreerimine/view";
    }

}

