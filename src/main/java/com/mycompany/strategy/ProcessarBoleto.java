package com.mycompany.strategy;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

import com.mycompany.strategy.model.Boleto;

public class ProcessarBoleto {
	static final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
    private Function<String, List<Boleto>> leituraRetorno;

    public ProcessarBoleto(Function<String, List<Boleto>> leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
    
    public void processar(String nomeArquivo){
      var listaBoletos =  leituraRetorno.apply(nomeArquivo);
      for(Boleto boleto : listaBoletos){
          System.out.println(boleto);
      }
      System.out.println("");
    }

    public void setLeituraRetorno(Function<String, List<Boleto>> leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
