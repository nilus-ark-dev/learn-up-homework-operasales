package operasales.controllers;

import operasales.services.interfaces.PremiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PremiereController {

    private PremiereService premiereService;

    @Autowired
    public PremiereController(PremiereService premiereService) {
        this.premiereService = premiereService;
    }

    @RequestMapping(value = "/premieres", method = RequestMethod.GET)
    public String getAllPremieres(Model model)  {
        model.addAttribute("title", "Доступные премьеры");
        model.addAttribute("premieres", premiereService.getAll());
        return "list";
    }
}
