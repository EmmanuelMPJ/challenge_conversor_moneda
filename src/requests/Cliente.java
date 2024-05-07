package requests;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Cliente {
    private String div = "USD";
    private HttpClient client = HttpClient.newHttpClient();

    public Cliente(String div) {
        this.div = div;
    }

    public HttpRequest requestInit(){
        UrlHandler urlHandler = new UrlHandler(div);
        String url = urlHandler.getUrl();
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }

    public HttpResponse<String> Response() throws IOException, InterruptedException {
        HttpRequest request = requestInit();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }


}
