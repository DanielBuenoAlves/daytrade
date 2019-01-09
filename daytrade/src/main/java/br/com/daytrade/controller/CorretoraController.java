package br.com.daytrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.daytrade.domain.SaldoCorretora;
import br.com.daytrade.service.CorretoraService;
import br.com.daytrade.service.SaldoCorretoraService;
import br.com.daytrade.service.vo.SaldoCorretoraVO;

@Controller
@RequestMapping("/corretora")
public class CorretoraController {
    
    @Autowired
    private CorretoraService corretoraService;        
    
    @Autowired
    private SaldoCorretoraService saldoCorretoraService;
    
    @RequestMapping(value = { "/todas" }, method = RequestMethod.GET)
    public String index(Model model) {
        
        //Map<String, Integer> map = this.corretoraService.buscaTodosMem();        
        //map.forEach((k, v) -> System.out.println((k + ":" + v)));
                 
        model.addAttribute("corretoras", this.corretoraService.buscaTodos());
                
        return "corretora-todas";
    }
    
    /**
     * Apresenta a tela de busca saldo
     * @param model
     * @return
     */
    @RequestMapping(value = { "/saldo" }, method = RequestMethod.GET)
    public String saldo(Model model) {

        model.addAttribute("corretoras", this.corretoraService.buscaTodos());    
        model.addAttribute("saldoCorretoraVO", new SaldoCorretoraVO());
        
        return "corretora-saldo";        
    }

    /**
     * Efetua a busca do saldo da corretora
     * @param scVO
     * @param result
     * @return
     */
    @RequestMapping(value = { "/saldo-busca" }, method = RequestMethod.POST)
    public String buscaSaldo(@ModelAttribute SaldoCorretoraVO scVO, BindingResult result, Model model) {
                               
        //model.addAttribute("corretoras", this.corretoraService.buscaTodosMem());
        //Redireciona. TODO: Criar msg de sucesso
        
        System.out.println(scVO);
        
        List<SaldoCorretora> lista = 
                this.saldoCorretoraService.busca(scVO.getDataInicio(), scVO.getDataFim(), scVO.getIdCorretora());
        
        model.addAttribute("corretoras", this.corretoraService.buscaTodos());  
        model.addAttribute("saldoCorretoraVO", scVO);
        model.addAttribute("lista", lista);
                
        return "corretora-saldo";
    }
    
}
