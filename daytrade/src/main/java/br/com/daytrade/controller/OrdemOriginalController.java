package br.com.daytrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.daytrade.service.CorretoraService;

@Controller
@RequestMapping("ordem-original")
public class OrdemOriginalController {
    
    @Autowired
    private CorretoraService corretoraService;        
    
    @GetMapping("/consulta")
    public String consulta(Model model) {
        
        model.addAttribute("corretoras", this.corretoraService.buscaTodos());
        
        return "ordem-original";
    }
    
}
