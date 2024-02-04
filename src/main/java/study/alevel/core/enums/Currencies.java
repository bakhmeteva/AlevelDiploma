package study.alevel.core.enums;

public enum Currencies {
    UAH("Гривня укр", "грн."),
    USD("Доллар США", "$"),
    EUR("Євро", "€");

    private final String description;
    private final String symbol;

    Currencies(String description, String symbol) {
        this.description = description;
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public String getSymbol() {
        return symbol;
    }
}