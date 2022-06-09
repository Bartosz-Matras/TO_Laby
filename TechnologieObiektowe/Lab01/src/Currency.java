public class Currency {
    private final String name;
    private double conversionFactor;
    private final String currencyCode;
    private double currencyRate;

    public Currency(String name, double conversionFactor, String currencyCode, double currencyRate){
        this.name = name;
        this.conversionFactor = conversionFactor;
        this.currencyCode = currencyCode;
        this.currencyRate = currencyRate;
    }

    public String getName() {
        return name;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }
}
