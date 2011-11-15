package ee.itcollege.jejee.web;

import ee.itcollege.jejee.entities.Intsidendi_liik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "intsidendi_liiks", formBackingObject = Intsidendi_liik.class)
@RequestMapping("/intsidendi_liiks")
@Controller
public class Intsidendi_liikController {
}
