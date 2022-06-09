import java.util.ArrayList;
import java.util.List;

public class CurrencyRateTable {

    private List<Currency> currencyList = new ArrayList<>();

    public void add(Currency currency){
        setCurrencyList(currencyList);
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }
}
