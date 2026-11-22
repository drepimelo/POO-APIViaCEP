package consumirCep;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class consumirCepAndre {

    public static void main(String[] args) {

        String cep = "72445010";
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );
            
            System.out.println(response.body());
            System.out.printf("%nAluno: Andre Pinheiro de Melo%nMatrícula: 0025261%n");

        } catch (Exception e) {
            System.out.println("CEP inválido!!! " + e.getMessage());
        }
    }
}