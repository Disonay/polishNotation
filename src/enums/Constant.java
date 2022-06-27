package enums;

public enum Constant {
    pi(Math.PI),
    e(Math.E);

    private final Double doubleValue;

    Constant(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

}
