package zadDomAdamDolinski;

public class Kursik {

    String table;
    String currency;
    String code;
    Stopki[] rates;

    public Kursik(String table, String currency, String code, Stopki[] rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Stopki[] getRates() {
        return rates;
    }

    public void setRates(Stopki[] rates) {
        this.rates = rates;
    }
}
