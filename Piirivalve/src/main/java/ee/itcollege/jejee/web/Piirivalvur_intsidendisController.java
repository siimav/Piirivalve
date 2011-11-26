package ee.itcollege.jejee.web;

import ee.itcollege.jejee.entities.Piirivalvur_intsidendis;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "piirivalvur_intsidendises", formBackingObject = Piirivalvur_intsidendis.class)
@RequestMapping("/piirivalvur_intsidendises")
@Controller
public class Piirivalvur_intsidendisController {
}
