package br.vinicius.coin;

import br.vinicius.service.ExchangeRateService;

public class Moeda {
    private String nome;
    private String codigoMoeda;

    public Moeda(String nome, String codigoMoeda) {
        this.nome = nome;
        this.codigoMoeda = codigoMoeda;
    }

    public String getNome() {
        return nome;
    }

    public double converter(double valorReal) {
        double taxa = ExchangeRateService.getTaxaConversao(codigoMoeda);
        if (taxa < 0){
            System.out.println("Falha na conversão.");
            return 0;
        }
        return valorReal * taxa;
    }
}

