package operators;

public class OperatorFabric {
    private OperatorFabric() {
    }

    public static boolean isBinaryOperator(String token) {
        return token.matches("^[+\\-*/]?");
    }

    public static boolean isUnaryOperator(String token) {
        return token.matches("(sin)|(cos)|(abs)|(sqrt)|(u-)|(u\\+)");
    }

    public static boolean isOperator(String token) {
        return isBinaryOperator(token) || isUnaryOperator(token);
    }

    public static Operator getBinaryOperator(String stringOperator) {
        switch (stringOperator) {
            case "+" -> {
                return BinaryOperator.SUM;
            }
            case "-" -> {
                return BinaryOperator.SUBTRACT;
            }
            case "*" -> {
                return BinaryOperator.MULTIPLY;
            }
            case "/" -> {
                return BinaryOperator.DIVIDE;
            }
            case "sin" -> {
                return UnaryOperator.sin;
            }
            case "cos" -> {
                return UnaryOperator.cos;
            }
            case "abs" -> {
                return UnaryOperator.abs;
            }
            case "sqrt" -> {
                return UnaryOperator.sqrt;
            }
        }
        throw new IllegalArgumentException();
    }

    public static Operator getUnaryOperator(String stringOperator) {
        switch (stringOperator) {
            case "u+", "-" -> {
                return UnaryOperator.plus;
            }
            case "u-", "+" -> {
                return UnaryOperator.minus;
            }
            case "sin" -> {
                return UnaryOperator.sin;
            }
            case "cos" -> {
                return UnaryOperator.cos;
            }
            case "abs" -> {
                return UnaryOperator.abs;
            }
            case "sqrt" -> {
                return UnaryOperator.sqrt;
            }
        }
        throw new IllegalArgumentException();
    }
}
