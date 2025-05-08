package br.vinicius;

import br.vinicius.coin.ConversorDeMoeda;
import br.vinicius.coin.Moeda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoeda conversor = new ConversorDeMoeda();
        int opcao = 0;

        System.out.println("###################################");
        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("###################################");

        while (opcao != 7) {
            conversor.mostrarOpcoes();
            opcao = scanner.nextInt();

            if (opcao == 7) break;

            Moeda moeda = conversor.getMoeda(opcao);
            if (moeda != null) {
                System.out.print("Digite o valor em Reais (BRL): ");
                double real = scanner.nextDouble();
                double resultado = moeda.converter(real);
                System.out.printf("Valor em %s: %.2f\n\n", moeda.getNome(), resultado);
            } else {
                System.out.println("Opção inválida.\n");
            }
        }

        System.out.println("Obrigado por usar o conversor!");
    }
}