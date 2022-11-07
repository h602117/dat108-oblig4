package no.hvl.lph.dat108;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String phonenumber, @RequestParam String password, HttpServletRequest request) {
        Participant p = this.service.getParticipant(phonenumber);
        if (p != null) {
            if (Utils.validatePassword(password, p.getPassHash(), p.getPassSalt())) {
                HttpSession s = request.getSession();
                s.setAttribute("loggedin", true);
                return "redirect:participants";
            }
        }

        return "redirect:login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "registration";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String firstname, @RequestParam String lastname,
            @RequestParam String phonenumber, @RequestParam String password, @RequestParam String repeatpassword,
            @RequestParam String gender, RedirectAttributes ra) {
        service.createParticipant(phonenumber, firstname, lastname, password, gender);
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
