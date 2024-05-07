package divisas;

public class Conversion {
    private float valorConvertido;

    public Conversion(float valorIngresado, float factorConversion, boolean esInverso) {

        if (esInverso){
            this.valorConvertido = valorIngresado / factorConversion;
        }else {
            this.valorConvertido = valorIngresado * factorConversion;
        }
    }

    public float getValorConvertido() {
        return valorConvertido;
    }
}
