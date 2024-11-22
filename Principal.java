import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);

        System.out.println("\n\nQual moeda deseja converter:");
        System.out.println("\n1. Dólar (USD)\n2. Euro (EUR)\n3. Real Brasileiro (BRL)\n4. Franco Suíço (CHF)\n5. Peso Argentino (ARS)\n6. Iene (JPY)");
        System.out.print("\nDigite uma opção: ");
        int opcao1 = leitura.nextInt();

        String sigla1 = getSigla(opcao1);
        if (sigla1.isEmpty()) {
            System.out.println("\nOpção não disponível.");
            return;
        }

        System.out.println("\n\nPara qual moeda deseja converter:");
        System.out.println("\n1. Dólar (USD)\n2. Euro (EUR)\n3. Real Brasileiro (BRL)\n4. Franco Suíço (CHF)\n5. Peso Argentino (ARS)\n6. Iene (JPY)");
        System.out.print("\nDigite uma opção: ");
        int opcao2 = leitura.nextInt();

        String sigla2 = getSigla(opcao2);
        if (sigla2.isEmpty()) {
            System.out.println("\nOpção não disponível.");
            return;
        }

        System.out.println("Insira o valor em " + sigla1 + " ser convertido: ");
        double quantidade = leitura.nextDouble();

        leitura.close();

        // Montando a requisição
        HttpClient client = HttpClient.newHttpClient();
        String apiUrl = "https://v6.exchangerate-api.com/v6/39f4f9c5d98aafab8efe37f7/pair/" + sigla1 + "/" + sigla2;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        // Enviando a requisição
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // Processando a resposta com Gson
        Gson gson = new Gson();
        ConverteJson converteJson = gson.fromJson(response.body(), ConverteJson.class);

        if ("success".equals(converteJson.getResult())) {
            System.out.printf("\nA taxa de câmbio de %s para %s é: %.2f\nE o valor total convertido é: %.2f",
                    converteJson.getBase_code(),
                    converteJson.getTarget_code(),
                    converteJson.getConversion_rate(),
                    converteJson.getResultadoTotal(quantidade));
        } else {
            System.out.println("\nErro ao obter a taxa de câmbio. Verifique os dados e tente novamente.");
        }
    }

    private static String getSigla(int opcao) {
        return switch (opcao) {
            case 1 -> "USD";
            case 2 -> "EUR";
            case 3 -> "BRL";
            case 4 -> "CHF";
            case 5 -> "ARS";
            case 6 -> "JPY";
            default -> "";
        };
    }
}
