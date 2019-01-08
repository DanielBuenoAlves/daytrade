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
        
        //Map<String, Integer> map = this.corretoraService.buscaTodosMem();        
        //map.forEach((k, v) -> System.out.println((k + ":" + v)));
                        
        model.addAttribute("corretoras", this.corretoraService.buscaTodos());    
                
        return "corretora-todas";
    }
    
    @RequestMapping(value = { "/saldo" }, method = RequestMethod.GET)
    public String saldo(Model model) {
                               
        model.addAttribute("corretoras", this.corretoraService.buscaTodosMem());    
                
        return "corretora-saldo";        
    }

    
    @RequestMapping(value = { "/saldo" }, method = RequestMethod.POST)
    public String saldo2(Model model) {
                               
        model.addAttribute("corretoras", this.corretoraService.buscaTodosMem());    
                
        return "corretora-saldo";        
    }
    
}
