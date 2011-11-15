package ee.itcollege.jejee.web;

import ee.itcollege.jejee.entities.Isik_intsidendis;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "isik_intsidendises", formBackingObject = Isik_intsidendis.class)
@RequestMapping("/isik_intsidendises")
@Controller
public class Isik_intsidendisController {
}
