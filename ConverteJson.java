public class ConverteJson {
    private String result;
    private String base_code;
    private String target_code;
    private double conversion_rate;

    // Getters e Setters padrão
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    // Método para calcular o resultado total diretamente
    public double getResultadoTotal(double quantidade) {
        return conversion_rate * quantidade;
    }
}
