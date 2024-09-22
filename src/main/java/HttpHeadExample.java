import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class HttpHeadExample {

    public static void main(String[] args) {
        String url = "https://www.example.com";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("HEAD", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

            System.out.println("Código de Status: " + response.statusCode());

            System.out.println("Cabeçalhos:");
            for (Map.Entry<String, List<String>> header : response.headers().map().entrySet()) {
                System.out.println(header.getKey() + ": " + header.getValue());
            }

        } catch (Exception e) {
            System.out.println("Erro ao realizar a requisição HTTP: " + e.getMessage());
        }
    }
}
