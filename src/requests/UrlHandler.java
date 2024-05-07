package requests;

public class UrlHandler {
    private final String apiKey = "2dab256f41d3b672851fa2b6";
    private String url = "https://v6.exchangerate-api.com/v6/" +
            apiKey + "/latest/%s";

    public String getUrl() {
        return url;
    }

    public void setDivisaUrl(String div) {
        this.url = String.format(url, div);
    }

    public UrlHandler(String div) {
        this.url = String.format(url, div);
    }
}
