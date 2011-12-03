// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.jejee.web;

import ee.itcollege.jejee.entities.Piirivalvur_intsidendis;
import ee.itcollege.jejee.entities.Piirivalvuri_seadus_intsidendi;
import ee.itcollege.jejee.entities.Seaduse_punkt;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect Piirivalvuri_seadus_intsidendiController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String Piirivalvuri_seadus_intsidendiController.create(@Valid Piirivalvuri_seadus_intsidendi piirivalvuri_seadus_intsidendi, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piirivalvuri_seadus_intsidendi", piirivalvuri_seadus_intsidendi);
            addDateTimeFormatPatterns(uiModel);
            return "piirivalvuri_seadus_intsidendis/create";
        }
        uiModel.asMap().clear();
        piirivalvuri_seadus_intsidendi.persist();
        return "redirect:/piirivalvuri_seadus_intsidendis/" + encodeUrlPathSegment(piirivalvuri_seadus_intsidendi.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String Piirivalvuri_seadus_intsidendiController.createForm(Model uiModel) {
        uiModel.addAttribute("piirivalvuri_seadus_intsidendi", new Piirivalvuri_seadus_intsidendi());
        addDateTimeFormatPatterns(uiModel);
        return "piirivalvuri_seadus_intsidendis/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String Piirivalvuri_seadus_intsidendiController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("piirivalvuri_seadus_intsidendi", Piirivalvuri_seadus_intsidendi.findPiirivalvuri_seadus_intsidendi(id));
        uiModel.addAttribute("itemId", id);
        return "piirivalvuri_seadus_intsidendis/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String Piirivalvuri_seadus_intsidendiController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("piirivalvuri_seadus_intsidendis", Piirivalvuri_seadus_intsidendi.findPiirivalvuri_seadus_intsidendiEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Piirivalvuri_seadus_intsidendi.countPiirivalvuri_seadus_intsidendis() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("piirivalvuri_seadus_intsidendis", Piirivalvuri_seadus_intsidendi.findAllPiirivalvuri_seadus_intsidendis());
        }
        addDateTimeFormatPatterns(uiModel);
        return "piirivalvuri_seadus_intsidendis/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String Piirivalvuri_seadus_intsidendiController.update(@Valid Piirivalvuri_seadus_intsidendi piirivalvuri_seadus_intsidendi, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piirivalvuri_seadus_intsidendi", piirivalvuri_seadus_intsidendi);
            addDateTimeFormatPatterns(uiModel);
            return "piirivalvuri_seadus_intsidendis/update";
        }
        uiModel.asMap().clear();
        piirivalvuri_seadus_intsidendi.merge();
        return "redirect:/piirivalvuri_seadus_intsidendis/" + encodeUrlPathSegment(piirivalvuri_seadus_intsidendi.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String Piirivalvuri_seadus_intsidendiController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("piirivalvuri_seadus_intsidendi", Piirivalvuri_seadus_intsidendi.findPiirivalvuri_seadus_intsidendi(id));
        addDateTimeFormatPatterns(uiModel);
        return "piirivalvuri_seadus_intsidendis/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String Piirivalvuri_seadus_intsidendiController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Piirivalvuri_seadus_intsidendi.findPiirivalvuri_seadus_intsidendi(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/piirivalvuri_seadus_intsidendis";
    }
    
    @ModelAttribute("piirivalvur_intsidendises")
    public Collection<Piirivalvur_intsidendis> Piirivalvuri_seadus_intsidendiController.populatePiirivalvur_intsidendises() {
        return Piirivalvur_intsidendis.findAllPiirivalvur_intsidendises();
    }
    
    @ModelAttribute("piirivalvuri_seadus_intsidendis")
    public Collection<Piirivalvuri_seadus_intsidendi> Piirivalvuri_seadus_intsidendiController.populatePiirivalvuri_seadus_intsidendis() {
        return Piirivalvuri_seadus_intsidendi.findAllPiirivalvuri_seadus_intsidendis();
    }
    
    @ModelAttribute("seaduse_punkts")
    public Collection<Seaduse_punkt> Piirivalvuri_seadus_intsidendiController.populateSeaduse_punkts() {
        return Seaduse_punkt.findAllSeaduse_punkts();
    }
    
    void Piirivalvuri_seadus_intsidendiController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("piirivalvuri_seadus_intsidendi_avatud_date_format", "yyyy-MM-dd");
        uiModel.addAttribute("piirivalvuri_seadus_intsidendi_muudetud_date_format", "yyyy-MM-dd");
        uiModel.addAttribute("piirivalvuri_seadus_intsidendi_suletud_date_format", "yyyy-MM-dd");
        uiModel.addAttribute("piirivalvuri_seadus_intsidendi_alates_date_format", "yyyy-MM-dd");
        uiModel.addAttribute("piirivalvuri_seadus_intsidendi_kuni_date_format", "yyyy-MM-dd");
    }
    
    String Piirivalvuri_seadus_intsidendiController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
