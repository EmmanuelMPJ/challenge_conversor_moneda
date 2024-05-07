package divisas;

import com.google.gson.*;
import requests.Cliente;

import java.io.IOException;
import java.net.http.HttpResponse;

public class JsonHandler {
    private String jsonStr;
    private UsdDivisa dictDivisas;

    public JsonHandler(HttpResponse<String> response) throws IOException, InterruptedException {
        this.jsonStr = response.body();
        JsonObject json = JsonParser.parseString(jsonStr).getAsJsonObject();
        JsonObject dict = json.get("conversion_rates").getAsJsonObject();
        Gson gson = new Gson();
        this.dictDivisas = gson.fromJson(dict, UsdDivisa.class);
    }

    public UsdDivisa getDictDivisas() {
        return dictDivisas;
    }

    public String getJsonStr() {
        return jsonStr;
    }
}
