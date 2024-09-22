import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.Test;

public class HttpHeadExampleTest {

    @Test
    public void testHttpHeadRequest() {
        String url = "https://www.example.com";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("HEAD", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

            assertEquals(200, response.statusCode(), "O código de status da resposta deve ser 200");

        } catch (Exception e) {
            fail("Erro ao realizar a requisição HTTP: " + e.getMessage());
        }
    }
}
