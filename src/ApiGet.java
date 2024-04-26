import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiGet {
    private String apiKey = "e179236dd280c927cbffd0b3";
    private String base_code;
    private String target_code;
    private String json;

    public ApiGet(String base_code, String target_code) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/" + base_code + "/" + target_code))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        json = response.body();
    }

    public String getJson(){
        return json;
    }
}