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
import br.com.daytrade.service.PregaoService;

@Controller
@RequestMapping("/pregao")
public class PregaoController {
    
    @Autowired
    private PregaoService pregaoService;
    
    @RequestMapping(value = { "/frequencia" }, method = RequestMethod.GET)
    public String index(Model model) {
                        
        model.addAttribute("frequenciaVO", this.pregaoService.frequenciaAtual());    
                
        return "pregao-principal";
    }
    
    /**
     * Exibe a página para cadastro de frequência
     * @return
     */
    @RequestMapping(value= {"/cadastro"}, method = RequestMethod.GET)
    public ModelAndView cadastro(Model model) {
        
        model.addAttribute("pregao", new Pregao());
        
        return new ModelAndView("pregao-cadastro");
    }
    
    /**
     * 
     * @param pregao
     * @param result
     * @return
     */
    @RequestMapping(value= {"/salvar"}, method = RequestMethod.POST)
    public ModelAndView cadastro(@ModelAttribute Pregao pregao, BindingResult result) {    
        
        System.out.println(pregao);
         
        this.pregaoService.cadastrar(pregao);
        
        //Redireciona. TODO: Criar msg de sucesso
        ModelAndView mv = new ModelAndView("redirect:/pregao/cadastro");
        mv.addObject("sucesso", "Pregão cadastrado com sucesso!");
                
        return mv;
    }        
    
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = { "/frequencia-historico" }, method = RequestMethod.GET)
    public String historico(Model model) {
        
        //Os dois últimos meses + ou -
        model.addAttribute("historico", this.pregaoService.buscaPorDias(56));
        
        return "pregao-historico";
    }
    
}
