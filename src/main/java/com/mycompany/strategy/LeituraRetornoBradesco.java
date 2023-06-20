package com.mycompany.strategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import com.mycompany.strategy.model.Boleto;

public class LeituraRetornoBradesco{

	public static List<Boleto> lerArquivo(String nomeArquivo) {
		System.out.println("Lendo arquivo Banco Bradesco: " + nomeArquivo);

		var listaBoletos = new LinkedList<Boleto>();

		try {
			var linhas = Files.readAllLines(
					Paths.get("bradesco-1.csv"));
			for (String linha : linhas) {
				var vetor = linha.split(";");

				var formatterDataTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

				var boleto = new Boleto();
				boleto.setId(Integer.parseInt(vetor[0]));
				boleto.setCodBanco(vetor[1]);
				boleto.setAgencia(vetor[2]);
				boleto.setContaBancaria(vetor[3]);

				boleto.setDataVencimento(LocalDate.parse(vetor[4], ProcessarBoleto.formatoData));
				boleto.setDataPagamento(LocalDateTime.parse(vetor[5], formatterDataTime));
				boleto.setCpfCliente(vetor[6]);
				boleto.setValor(Double.parseDouble(vetor[7]));
				boleto.setMulta(Double.parseDouble(vetor[8]));
				boleto.setJuros(Double.parseDouble(vetor[9]));

				listaBoletos.add(boleto);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return listaBoletos;
	}

}
