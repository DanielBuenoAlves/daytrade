package br.com.daytrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.daytrade.service.CorretoraService;
import br.com.daytrade.service.vo.OrdemOriginalVO;

@Controller
@RequestMapping("ordem-original")
public class OrdemOriginalController {
    
    @Autowired
    private CorretoraService corretoraService;        
    
    @GetMapping("/consulta")
    public String consulta(Model model) {
        
        model.addAttribute("corretoras", this.corretoraService.buscaTodos());
        model.addAttribute("ordemOriginalVO", new OrdemOriginalVO());
        
        return "ordem-original";
    }
    
    @PostMapping("/consulta")
    public String consuta(@ModelAttribute OrdemOriginalVO orVO, Model model) {
        
        System.out.println(orVO);
                
        model.addAttribute("corretoras", this.corretoraService.buscaTodos());
        model.addAttribute("ordemOriginalVO", orVO);
        
        //TODO: Implementar a busca...
        
        return "ordem-original";
    }
    
}
