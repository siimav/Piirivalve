package ee.itcollege.jejee.web;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.jejee.entities.Piirivalvur;
import ee.itcollege.jejee.entities.Piirivalvur_intsidendis;

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
    public String redirect(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, Model uiModel) throws CloneNotSupportedException {	
		Piirivalvur_intsidendis p_ints = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(id);
		Piirivalvur_intsidendis tmp = (Piirivalvur_intsidendis) p_ints.clone();
		Piirivalvur pvalvur = Piirivalvur.findPiirivalvur(p_id);
		uiModel.addAttribute("pvalvur", pvalvur);
		uiModel.addAttribute("pints", p_ints);
		uiModel.addAttribute("uusInts", tmp);
		
		return "intsidendid_piiriloigul_detail/detail";
	}
	
	@RequestMapping(value = "/{id}/p/{p_id}/muuda", method = RequestMethod.POST)
    public String muuda(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, HttpServletRequest httpServletRequest, Model uiModel, @Valid Piirivalvur_intsidendis uusInts, BindingResult result) {	
		Piirivalvur_intsidendis p_ints = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(id);
		Piirivalvur pvalvur = Piirivalvur.findPiirivalvur(p_id);
		uiModel.addAttribute("pvalvur", pvalvur);
		uiModel.addAttribute("pints", p_ints);
		
		//URROR
//		System.out.println("url_id: "+id);
//		System.out.println("url_p_id: "+p_id);
//		System.out.println("UUS_id: "+uusInts.getId());
//		System.out.println("UUS_p_id: "+uusInts.getPiirivalvur().getId());
		
		//return "intsidendid_piiriloigul_detail/detail";
		return "redirect:http://www.google.com";
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

