package br.com.daytrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.daytrade.domain.Frequencia;
import br.com.daytrade.service.FrequenciaService;

@Controller
@RequestMapping("/frequencia")
public class FrequenciaController {
    
    @Autowired
    private FrequenciaService frequenciaService;
    
    @RequestMapping(value = { "/principal" }, method = RequestMethod.GET)
    public String index(Model model) {
        //model.addAttribute("message", message);
        
        
        
        
        return "frequencia-principal";
    }
    
    /**
     * Exibe a página para cadastro de frequência
     * @return
     */
    @RequestMapping(value= {"/cadastro"}, method = RequestMethod.GET)
    public ModelAndView cadastro(Model model) {
        
        model.addAttribute("frequencia", new Frequencia());
        
        return new ModelAndView("frequencia-cadastro");
    }
    
    /**
     * 
     * @param frequencia
     * @param result
     * @return
     */
    @RequestMapping(value= {"/salvar"}, method = RequestMethod.POST)
    public ModelAndView cadastro(@ModelAttribute Frequencia frequencia, BindingResult result) {    
        
        System.out.println(frequencia);
         
        this.frequenciaService.cadastrar(frequencia);
        
        //Redireciona. TODO: Criar msg de sucesso
        ModelAndView mv = new ModelAndView("redirect:/frequencia/cadastro");
        mv.addObject("sucesso", "Frequência cadastrada com sucesso!");
                
        return mv;
    }        
    
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = { "/historico" }, method = RequestMethod.GET)
    public String historico(Model model) {
        
        //Os dois últimos meses + ou -
        model.addAttribute("historico", this.frequenciaService.buscaPorDias(56));
        
        return "frequencia-historico";
    }
    
}
