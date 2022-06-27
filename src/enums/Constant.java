package enums;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum Constant {
    pi(Math.PI),
    e(Math.E);

    private final Double doubleValue;

    public static boolean haveConstant(String token) {
        return Arrays.stream(Constant.values()).map(Enum::name).toList().contains(token);
    }

    Constant(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

}
