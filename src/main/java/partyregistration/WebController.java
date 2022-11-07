package partyregistration;

import javax.servlet.http.HttpServletRequest;

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
        if (!Utils.login(request, p, password)) {
            // TODO: Set error message for login screen
            return "redirect:login";
        }

        return "redirect:participants";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "registration";
    }

    @PostMapping("/register")
    public String postRegister(
        @RequestParam String firstname,
        @RequestParam String lastname,
        @RequestParam String phonenumber,
        @RequestParam String password,
        @RequestParam String repeatpassword,
        @RequestParam String gender,
        HttpServletRequest request,
        RedirectAttributes ra
    ) {
        service.createParticipant(phonenumber, firstname, lastname, password, gender);

        Participant p = service.getParticipant(phonenumber);
        if (!Utils.login(request, p, password)) {
            return "redirect:login";
        }

        ra.addFlashAttribute("showConfirmation", true);
        ra.addFlashAttribute("firstname", firstname);
        ra.addFlashAttribute("lastname", lastname);
        ra.addFlashAttribute("phonenumber", phonenumber);
        ra.addFlashAttribute("gender", gender);

        return "redirect:confirmation";
    }

    @GetMapping("/confirmation")
    public String getConfirmation(HttpServletRequest request) {
        if (!Utils.isLoggedIn(request.getSession())) {
            return "redirect:login";
        }

        return "confirmation";
    }

    @GetMapping("/participants")
    public String getParticipants(HttpServletRequest request, ModelMap model) {
        if (!Utils.isLoggedIn(request.getSession())) {
            return "redirect:login";
        }

        model.addAttribute("participants", service.getAllParticipants());
        return "participantList";
    }

}
