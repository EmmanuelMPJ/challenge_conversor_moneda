package divisas;

public class FiltroDivisa {
    private float factorConversion;
    private String opcion;
    private boolean inverso;
    String divisaFinal;
    String divisaInicial;

    public FiltroDivisa(UsdDivisa dictDivisas, String opcionSelec) {
        switch (opcionSelec) {
            case "1", "2" -> {
                this.factorConversion = Float.parseFloat(dictDivisas.ARS());
                this.divisaInicial = "ARS";
                this.divisaFinal = "ARS";
            }
            case "3", "4" -> {
                this.factorConversion = Float.parseFloat(dictDivisas.BRL());
                this.divisaInicial = "BLR";
                this.divisaFinal = "BLR";
            }
            case "5", "6" -> {
                this.factorConversion = Float.parseFloat(dictDivisas.COP());
                this.divisaInicial = "COP";
                this.divisaFinal = "COP";
            }
            default -> this.factorConversion = 0f;
        }
        this.opcion = opcionSelec;
        factorInverso();
    }
    public void factorInverso(){
        int opcionInt = Integer.parseInt(opcion);

        if (opcionInt % 2 == 0) {
            // Par
            this.inverso = true;
            this.divisaFinal = "USD";
        } else {
            // Impar
            this.inverso = false;
            this.divisaInicial = "USD";
        }
    }

    public boolean isInverso() {
        return inverso;
    }

    public float getFactorConversion() {
        return factorConversion;
    }

    public String getDivisaFinal() {
        return divisaFinal;
    }

    public String getDivisaInicial() {
        return divisaInicial;
    }
}
