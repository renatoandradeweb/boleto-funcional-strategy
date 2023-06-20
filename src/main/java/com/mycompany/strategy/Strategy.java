
package com.mycompany.strategy;

public class Strategy {

    public static void main(String[] args) {     
    	
        var processador = new ProcessarBoleto(LeituraRetornoBancoBrasil::lerArquivo);    
        processador.processar("banco-brasil-1.csv");
         
       
        processador = new ProcessarBoleto(LeituraRetornoBradesco::lerArquivo);
        processador.processar("bradesco-1.csv");
    }
}
