package ee.itcollege.jejee.web;

import ee.itcollege.jejee.entities.Vahtkond_piiriloigul;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "vahtkond_piiriloiguls", formBackingObject = Vahtkond_piiriloigul.class)
@RequestMapping("/vahtkond_piiriloiguls")
@Controller
public class Vahtkond_piiriloigulController {
}
