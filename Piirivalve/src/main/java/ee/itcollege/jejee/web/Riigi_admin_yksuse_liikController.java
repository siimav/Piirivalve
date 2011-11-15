package ee.itcollege.jejee.web;

import ee.itcollege.jejee.entities.Riigi_admin_yksuse_liik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "riigi_admin_yksuse_liiks", formBackingObject = Riigi_admin_yksuse_liik.class)
@RequestMapping("/riigi_admin_yksuse_liiks")
@Controller
public class Riigi_admin_yksuse_liikController {
}
