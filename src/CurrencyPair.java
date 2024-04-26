public class CurrencyPair {
    private String base_code;
    private String target_code;
    private double conversion_rate;

    public CurrencyPair(){}

    public CurrencyPair(String base_code, String target_code){
        this.base_code = base_code;
        this.target_code = target_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setConversionRate(double conversion_rate){
        this.conversion_rate = conversion_rate;
    }

    public double getConversionRate(){
        return conversion_rate;
    }
}