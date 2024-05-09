import divisas.Conversion;
import divisas.FiltroDivisa;
import divisas.JsonHandler;
import divisas.UsdDivisa;
import requests.Cliente;
import utils.AnalisisInput;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        loop: while (true){
            HttpResponse<String> respuesta;
            UsdDivisa valoresDivisas;
            FiltroDivisa filtro;
            float valorConvertido;

            String menu = """
                    
                    *******************************************
                    Sea bienvenido/a al Conversor de moneda :D
                    
                    1) Dólar ==> Peso argentino
                    2) Peso argentino ==> Dólar
                    3) Dólar ==> Real brasileño
                    4) Real brasileño ==> Dólar
                    5) Dólar ==> Peso colombiano
                    6) Peso colombiano ==> Dólar
                    7) Salir
                    Elija una opción válida:
                    *******************************************
                    """;
            System.out.println(menu);

            Scanner scanner = new Scanner(System.in);
            String opcion = scanner.nextLine();

            switch (opcion){
                case "1", "2", "3", "4", "5", "6" -> {
                    System.out.println("Ingrese el valor que deseas convertir:");
                    String valorConvertir = scanner.nextLine();
                    Matcher matcher = new AnalisisInput(valorConvertir).getMatcher();
                    if (!matcher.matches()){
                        System.out.println("Ingresó un valor no valido para la moneda");
                        continue;
                    }
                    float valorIngresadoFloat = Float.parseFloat(valorConvertir);

                    respuesta = new Cliente("USD").Response();
                    valoresDivisas = new JsonHandler(respuesta).getDictDivisas();
                    filtro = new FiltroDivisa(valoresDivisas, opcion);
                    boolean flag = filtro.isInverso();
                    float tasaCambio = filtro.getFactorConversion();
                    valorConvertido = new Conversion(valorIngresadoFloat, tasaCambio, flag)
                            .getValorConvertido();
                    String divisa1 = filtro.getDivisaInicial();
                    String divisa2 = filtro.getDivisaFinal();
                    String textoFinal = "El valor %.1f [%s] corresponde al valor final de ==>>> %.2f [%s]";
                    System.out.printf(Locale.US, textoFinal, valorIngresadoFloat, divisa1, valorConvertido, divisa2);

                }
                case "7" -> {
                    break loop;
                }
                default -> {
                    System.out.println("Opción no válida");
                }
            }
        }
    }
}