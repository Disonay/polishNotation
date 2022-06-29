package operators;

import operators.BinaryOperator;
import operators.Operator;
import operators.UnaryOperator;

public class OperatorFabric {
    private OperatorFabric() {}
    public static boolean isBinaryOperator(String token) {
        return token.matches("[+\\-*/]");
    }
    public static boolean isUnaryOperator(String token) {
        return token.matches("(sin)|(cos)|(abs)|(sqrt)");
    }
    public static Operator getOperator(String stringOperator) {
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
}
