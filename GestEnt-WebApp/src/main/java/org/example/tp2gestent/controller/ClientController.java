package org.example.tp2gestent.controller;

import org.example.tp2gestent.model.Achat;
import org.example.tp2gestent.model.Client;
import org.example.tp2gestent.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/client")
    public String home(Model model) {
        Iterable<Client> listeClient = clientService.getClients();
        model.addAttribute("achats", listeClient);
        return "homeClient";
    }

    @GetMapping("/createClient")
    public String createClient(Model model) {
        Achat a = new Achat();
        model.addAttribute("achat", a);
        return "formNewClient";
    }

    @GetMapping("/updateClient/{id}")
    public String updateClient(@PathVariable("id") final Integer id, Model model) {
        Client e = clientService.getClientById(id);
        model.addAttribute("Client", e);
        return "formUpdateClient";
    }

    @GetMapping("/deleteClient/{id}")
    public ModelAndView deleteClient(@PathVariable("id") final Integer id) {
        clientService.deleteClient(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveClient")
    public ModelAndView saveClient(@ModelAttribute Client client) {
        if(client.getClientId() != null) {
            // Achat from update form has the password field not filled,
            // so we fill it with the current password.
            Client current = clientService.getClientById(client.getClientId());
            client.setClientId(current.getClientId());
        }
        clientService.save(client);
        return new ModelAndView("redirect:/");
    }
}
