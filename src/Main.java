import requests.Cliente;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Cliente cliente = new Cliente("COP");
        System.out.println(cliente.Response().body());
    }
}