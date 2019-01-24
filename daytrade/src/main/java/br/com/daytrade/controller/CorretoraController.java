package br.com.daytrade.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    
    @RequestMapping(value = { "/lista" }, method = RequestMethod.GET)
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
    @RequestMapping(value = { "/saldo-consulta" }, method = RequestMethod.POST)
    public String consultaSaldo(@ModelAttribute SaldoCorretoraVO scVO, BindingResult result, Model model) {
                               
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
    
    @GetMapping("/saldo-carregar")
    public String carregarSaldo() {
        
        return "corretora-saldo-carregar";
    
    }
    
    @PostMapping("/saldo-carregar")
    public String carregarSaldo(@RequestParam("dataPregao") String dataPregao
                                , @RequestParam("arquivo") MultipartFile arquivo
                                , Model model) {
                        
        try {            
            InputStream input = new ByteArrayInputStream(arquivo.getBytes());
            
            this.corretoraService.carregarSaldo(dataPregao, input);
            
            model.addAttribute("sucesso", "Arquivo carregado com sucesso!");            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            model.addAttribute("erro", "Erro ao carregar o arquivo!");            
        }
        
        return "corretora-saldo-carregar";
    }
    
}
