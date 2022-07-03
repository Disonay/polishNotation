package utils;

import java.util.Arrays;

public enum Constant {
    pi(Math.PI), e(Math.E);

    private final Double doubleValue;

    Constant(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public static boolean haveConstant(String token) {
        return Arrays.stream(Constant.values()).map(Enum::name).toList().contains(token);
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

}
