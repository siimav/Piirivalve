package ee.itcollege.jejee.web;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.jejee.entities.Piirivalvur_intsidendis;
import ee.itcollege.jejee.entities.Piirivalvur;

@RequestMapping("/detail")
@Controller
public class IntsidendidPiiriloigulDetailController {

	@PersistenceContext
	EntityManager entityManager;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
		Piirivalvur_intsidendis p_ints = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(id);
		uiModel.addAttribute("pints", p_ints);
		
		return "redirect:http://localhost:8080/Piirivalve/detail/1/p/1";
	}
	
	@RequestMapping(value = "/{id}/p/{p_id}", method = RequestMethod.GET)
    public String redirect(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, Model uiModel) {
		Piirivalvur_intsidendis p_ints = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(id);
		Piirivalvur pvalvur = Piirivalvur.findPiirivalvur(p_id);
		uiModel.addAttribute("pvalvur", pvalvur);
		uiModel.addAttribute("pints", p_ints);
		
		return "intsidendid_piiriloigul_detail/detail";
	}
	
	@RequestMapping(value = "/{id}/p/{p_id}/muuda_piirivalvur", method = RequestMethod.GET)
    public String vali_piirivalvur(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, Model uiModel) {
		Piirivalvur_intsidendis p_ints = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(id);
		Piirivalvur pvalvur = Piirivalvur.findPiirivalvur(p_id);
		uiModel.addAttribute("pvalvur", pvalvur);
		uiModel.addAttribute("pints", p_ints);
		uiModel.addAttribute("piirivalvurid", Piirivalvur.findAllPiirivalvuridExceptFor(pvalvur));
		
		return "intsidendid_piiriloigul_detail/vali_piirivalvur";
	}
	

	@RequestMapping(value = "/{id}/p/{p_id}/muuda_piirivalvur", params="valik", method = RequestMethod.GET)
    public String showPiirivalvurSelected(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, Model uiModel, @RequestParam Long valik) {
		
		System.out.println(valik);
		
		//Piirivalvur_intsidendis p_ints = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(id);
		//uiModel.addAttribute("pints", p_ints);
		//uiModel.addAttribute("piirivalvurid", Piirivalvur.findAllPiirivalvuridExceptFor(p_ints.getPiirivalvur()));
		
		return "redirect:http://localhost:8080/Piirivalve/detail/"+id+"/p/"+valik;
	}
	
}

