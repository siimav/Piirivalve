package ee.itcollege.jejee.web;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.jejee.entities.Intsident;
import ee.itcollege.jejee.entities.Objekt;
import ee.itcollege.jejee.entities.Piiririkkuja;
import ee.itcollege.jejee.entities.Piirivalvur;
import ee.itcollege.jejee.entities.Vahtkond;


@RequestMapping("/intsident")
@Controller
public class IntsidendiRedaktorController {

	@PersistenceContext
	EntityManager entityManager;
	
	@RequestMapping(value = "/{intsident_ID}", method = RequestMethod.GET)
    public String show(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
    	Intsident ints = Intsident.findIntsident(intsident_ID);
    	
    	Collection<Objekt> objektid = Objekt.findAllObjektidForIntsident(ints);
    	Collection<Piiririkkuja> isikud = Piiririkkuja.findAllPiiririkkujadForIntsident(ints);
    	Collection<Vahtkond> vahtkonnad = Vahtkond.findAllVahtkonnadForIntsident(ints);
    	Collection<Piirivalvur> piirivalvurid = Piirivalvur.findAllPiirivalvuridForIntsident(ints);
    	
        uiModel.addAttribute("intsident", ints);
        uiModel.addAttribute("objektid", objektid);
        uiModel.addAttribute("isikud", isikud);
        uiModel.addAttribute("vahtkonnad", vahtkonnad);
        uiModel.addAttribute("piirivalvurid", piirivalvurid);
        return "intsidendi_redaktor/view";
    }

}

