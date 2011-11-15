package ee.itcollege.jejee.web;

import ee.itcollege.jejee.entities.Vahtkonna_liige;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "vahtkonna_liiges", formBackingObject = Vahtkonna_liige.class)
@RequestMapping("/vahtkonna_liiges")
@Controller
public class Vahtkonna_liigeController {
}
