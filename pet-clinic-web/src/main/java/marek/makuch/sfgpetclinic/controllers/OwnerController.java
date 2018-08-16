package marek.makuch.sfgpetclinic.controllers;

/*
 * @author Marecki
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"", "/", "/index.html", "/index"})
    public String listOwners() {
        return "owners/index.html";
    }
}
