package br.com.daytrade.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String index(Model model) {
        
        model.addAttribute("tempoHomeOffice", this.calculaTempoHomeOffice());
        model.addAttribute("terminoContrato", this.calculaTerminoContrato());
        
        return "index.html";
    }
    
    
    private String calculaTempoHomeOffice() {
        
        LocalDate inicioHomeOffice = LocalDate.parse("2018-06-01");
        LocalDate hoje = LocalDate.now();
                
        Period time = Period.between(inicioHomeOffice,hoje);
                
        return time.getYears() + " anos, " + time.getMonths() + " meses e " + time.getDays() + " dias.";
    }
    
    private Date calculaTerminoContrato() {
        
        LocalDate hoje = LocalDate.now().plusDays(30L);
        
        Date dataFinal = Date.from(hoje.atStartOfDay()
                             .atZone(ZoneId.systemDefault())
                             .toInstant());        
        return dataFinal;
    }
        
}
