package br.com.daytrade.test.repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.daytrade.service.CorretoraService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoricoDeNegociosRepositoryTest {
    
    @Autowired
    private CorretoraService corretoraService;
    
    DateFormat formataHora = new SimpleDateFormat("HH:mm:ss");
    
    DateFormat formataDia = new SimpleDateFormat("yyyy-MM-dd");
    
    @Test
    public void init() {
         
        LocalDate localDate = LocalDate.parse("2019-02-07");
        Date data = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        String arq = "D:\\ambiente-de-trabalho\\@\\day-trade\\banco-de-dados\\inserts\\historico-de-negocios\\2019_02_07_HistoricoDeNegocios.csv";
        
        String arqEscrita = "D:\\ambiente-de-trabalho\\@\\day-trade\\banco-de-dados\\inserts\\historico-de-negocios\\_Load.txt";
        
        //String insert = "INSERT INTO ordem_original(pregao, hora, corretora, quantidade, valor, agressor) VALUES(";
        StringBuilder sql = new StringBuilder();                
        
        Map<String, Integer> map = this.corretoraService.buscaTodosMem();
        
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(arq), "ISO-8859-1"))){
            
            String linha = reader.readLine();
            
            while(linha != null) {
                /*val[0] = hora
                  val[1] = Compradora
                  val[2] = valor
                  val[3] = quantidade
                  val[4] = vendedor
                  val[5] = agressor
                */
                String[] val = linha.split(";");
                
                //Data e Hora
                sql.append("" + this.formataDia.format(data) + "").append(",")
                    .append("" + val[0].toString() + "").append(",");
                
                //Compradora
                sql.append(map.get(val[1].toString())).append(",")
                
                //Valor
                .append(val[2].replace(".", "").replace(",", ".")).append(",")
                
                //Quantidade
                .append(new Integer(val[3].replace(".", ""))).append(",")
                
                //Vendedor
                .append(map.get(val[4].toString())).append(",");
                
                //Agressor
                if("COMPRADOR".equalsIgnoreCase(val[5].toString())) {
                    sql.append("C");
                } else if("VENDEDOR".equalsIgnoreCase(val[5].toString())) {
                    sql.append("V");
                } else if("DIRETO".equalsIgnoreCase(val[5].toString())) {
                    sql.append("D");
                } else {
                    sql.append("L");
                }
                
                
                /*
                String agressor = null;
                if("COMPRADOR".equalsIgnoreCase(val[5].toString())) {
                   sql.append(map.get(val[1].toString())).append(", ");
                   agressor = "C";
                } else {
                    sql.append(map.get(val[4].toString())).append(", ");
                    agressor = "V";
                } 

                sql.append(new Integer(val[3].replace(".", ""))).append(", ")
                   .append(val[2].replace(".", "").replace(",", ".")).append(", ")
                   .append("'" + agressor + "'");
                                
                //System.out.println(ordemOriginal);
                //this.repo.save(ordemOriginal);
                 */
                sql.append("\r\n");
                linha = reader.readLine();
            }            
            //System.out.println(sql.toString());
            Files.write(Paths.get(arqEscrita), sql.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }   
        
    }
    
}
