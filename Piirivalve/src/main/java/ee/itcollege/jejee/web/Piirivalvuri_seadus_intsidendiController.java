package ee.itcollege.jejee.web;

import ee.itcollege.jejee.entities.Piirivalvuri_seadus_intsidendi;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "piirivalvuri_seadus_intsidendis", formBackingObject = Piirivalvuri_seadus_intsidendi.class)
@RequestMapping("/piirivalvuri_seadus_intsidendis")
@Controller
public class Piirivalvuri_seadus_intsidendiController {
}
