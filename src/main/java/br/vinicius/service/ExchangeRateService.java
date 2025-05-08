package br.vinicius.service;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ExchangeRateService {
    private static final String API_KEY = "SUA CHAVE";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static double getTaxaConversao(String moedaDestino) {
        try {
            String urlStr = BASE_URL + API_KEY + "/pair/BRL/" + moedaDestino;
            URL url = new URL(urlStr);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String inputLine;
            StringBuilder conteudo = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                conteudo.append(inputLine);
            }
            in.close();
            conexao.disconnect();

            JSONObject json = new JSONObject(conteudo.toString());
            return json.getDouble("conversion_rate");

        } catch (Exception e) {
            System.out.println("Erro ao obter taxa de conversão: " + e.getMessage());
            return -1;
        }
    }
}
