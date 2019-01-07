package br.com.daytrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.daytrade.service.CorretoraService;

@Controller
@RequestMapping("/corretora")
public class CorretoraController {
    
    @Autowired
    private CorretoraService corretoraService;
    
    @RequestMapping(value = { "/todas" }, method = RequestMethod.GET)
    public String index(Model model) {
                        
        model.addAttribute("corretoras", this.corretoraService.buscaTodos());    
                
        return "corretora-todas";
    }
    
}
