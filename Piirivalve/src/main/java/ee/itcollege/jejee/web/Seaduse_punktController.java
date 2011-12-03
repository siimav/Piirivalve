package ee.itcollege.jejee.web;

import ee.itcollege.jejee.entities.Seaduse_punkt;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "seaduse_punkts", formBackingObject = Seaduse_punkt.class)
@RequestMapping("/seaduse_punkts")
@Controller
public class Seaduse_punktController {
}
