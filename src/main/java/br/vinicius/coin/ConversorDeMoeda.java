package br.vinicius.coin;

import java.util.HashMap;
import java.util.Map;

public class ConversorDeMoeda {
    private Map<Integer, Moeda> moedas = new HashMap<>();

    public ConversorDeMoeda() {
        moedas.put(1, new Moeda("Peso(ARG)", "ARS"));
        moedas.put(2, new Moeda("Euro", "EUR"));
        moedas.put(3, new Moeda("Dólar", "USD"));
        moedas.put(4, new Moeda("Yen", "JPY"));
        moedas.put(5, new Moeda("Libras", "GBP"));
        moedas.put(6, new Moeda("Yuan", "CNY"));
    }

    public Moeda getMoeda(int opcao) {
        return moedas.get(opcao);
    }

    public void mostrarOpcoes() {
        System.out.println("Escolha a moeda para conversão:");
        for (Map.Entry<Integer, Moeda> entry : moedas.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
        System.out.println("7 - Sair");
    }
}
