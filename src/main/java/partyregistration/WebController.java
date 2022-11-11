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

    @GetMapping("/")
    public String getIndex() {
        return "redirect:login";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String phonenumber, @RequestParam String password, HttpServletRequest request, RedirectAttributes ra) {
        Participant p = this.service.getParticipant(phonenumber.trim());
        if (!Utils.login(request, p, password)) {
            ra.addFlashAttribute("error_message", "Could not login");
            return "redirect:login";
        }

        return "redirect:participants";
    }

    @PostMapping("/logout")
    public String postLogout(HttpServletRequest request) {
        Utils.logout(request.getSession());
        return "redirect:login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
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
        boolean success = service.createParticipant(
            phonenumber.trim(),
            firstname.trim(),
            lastname.trim(),
            password.trim(),
            gender.trim()
        );

        if (!success) {
            ra.addFlashAttribute("error_message", "Could not register participation, phonenumber already in use");
            return "redirect:register";
        }

        Participant p = service.getParticipant(phonenumber);
        if (!Utils.login(request, p, password)) {
            ra.addFlashAttribute("error_message", "Could not login to your new registration");
            return "redirect:login";
        }

        ra.addFlashAttribute("firstname", firstname);
        ra.addFlashAttribute("lastname", lastname);
        ra.addFlashAttribute("phonenumber", phonenumber);
        ra.addFlashAttribute("gender", gender);

        return "redirect:confirmation";
    }

    @GetMapping("/confirmation")
    public String getConfirmation(HttpServletRequest request, RedirectAttributes ra) {
        if (!Utils.isLoggedIn(request.getSession())) {
            ra.addFlashAttribute("error_message", "Login to view page");
            return "redirect:login";
        }

        return "confirmation";
    }

    @GetMapping("/participants")
    public String getParticipants(HttpServletRequest request, ModelMap model, RedirectAttributes ra) {
        if (!Utils.isLoggedIn(request.getSession())) {
            ra.addFlashAttribute("error_message", "Login to view page");
            return "redirect:login";
        }

        model.addAttribute("participants", service.getAllParticipants());
        model.addAttribute("current", service.getParticipant((String) request.getSession().getAttribute("phonenumber")));
        return "participants";
    }

}
