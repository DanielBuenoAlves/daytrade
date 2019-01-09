package br.com.daytrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.daytrade.domain.Pregao;
import br.com.daytrade.service.CorretoraService;
import br.com.daytrade.service.vo.SaldoCorretoraVO;

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

        model.addAttribute("saldoCorretoraVO", new SaldoCorretoraVO());   
        model.addAttribute("corretoras", this.corretoraService.buscaTodos());    
                
        return "corretora-saldo";        
    }

    
    @RequestMapping(value = { "/saldo-busca" }, method = RequestMethod.POST)
    public ModelAndView buscaSaldo(@ModelAttribute SaldoCorretoraVO saldoCorretoraVO, BindingResult result) {
                               
        //model.addAttribute("corretoras", this.corretoraService.buscaTodosMem());
        //Redireciona. TODO: Criar msg de sucesso
        
        System.out.println(saldoCorretoraVO);
        
        ModelAndView mv = new ModelAndView("redirect:/corretora/saldo");
        //mv.addObject("sucesso", "Pregão cadastrado com sucesso!");
                
        return mv;
    }
    
}
