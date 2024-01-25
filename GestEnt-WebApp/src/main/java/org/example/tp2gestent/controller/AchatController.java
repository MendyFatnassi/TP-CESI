package org.example.tp2gestent.controller;

import org.example.tp2gestent.model.Achat;
import org.example.tp2gestent.service.AchatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AchatController {

    @Autowired
    private AchatServiceImpl achatService;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Achat> listAchat = achatService.getAchats();
        model.addAttribute("achats", listAchat);
        return "homeAchat";
    }

    @GetMapping("/createAchat")
    public String createAchat(Model model) {
        Achat a = new Achat();
        model.addAttribute("achat", a);
        return "formNewAchat";
    }

    @GetMapping("/updateAchat/{id}")
    public String updateAchat(@PathVariable("id") final Integer id, Model model) {
        Achat e = achatService.getAchatById(id);
        model.addAttribute("Achat", e);
        return "formUpdateAchat";
    }

    @GetMapping("/deleteAchat/{id}")
    public ModelAndView deleteAchat(@PathVariable("id") final Integer id) {
        achatService.deleteAchat(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/achat")
    public ModelAndView saveAchat(@ModelAttribute Achat achat) {
        if(achat.getAchatId() != null) {
            // Achat from update form has the password field not filled,
            // so we fill it with the current password.
            Achat current = achatService.getAchatById(achat.getAchatId());
            achat.setAchatId(current.getAchatId());
        }
        achatService.saveAchat(achat);
        return new ModelAndView("redirect:/");
    }
}
