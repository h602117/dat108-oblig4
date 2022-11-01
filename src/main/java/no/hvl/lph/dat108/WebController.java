package no.hvl.lph.dat108;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    @Autowired
    private ParticipantService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "registration";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String firstname, @RequestParam String lastname,
            @RequestParam String phonenumber, @RequestParam String password, @RequestParam String repeatpassword,
            @RequestParam String gender, RedirectAttributes ra) {
        service.createParticipant(firstname, lastname, phonenumber, password, gender);
        ra.addFlashAttribute("firstname", firstname);
        ra.addFlashAttribute("lastname", lastname);
        ra.addFlashAttribute("phonenumber", phonenumber);
        ra.addFlashAttribute("gender", gender);
        return "redirect:confirmation";
    }

    @GetMapping("/confirmation")
    public String getConfirmation(RedirectAttributes ra) {
        return "confirmation";
    }

    @GetMapping("/participants")
    public String getParticipants(ModelMap model) {
        model.addAttribute("participants", service.getAllParticipants());
        return "participantList";
    }

}
