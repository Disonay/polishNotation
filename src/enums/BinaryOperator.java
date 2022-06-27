package enums;

public enum BinaryOperator {
    SUM{
        @Override
        public Double compute(Double operand1, Double operand2) {
            return operand2 + operand1;
        }
    },
    SUBTRACT{
        @Override
        public Double compute(Double operand1, Double operand2) {
            return operand2 - operand1;
        }
    },
    MULTIPLY{
        @Override
        public Double compute(Double operand1, Double operand2) {
            return operand2 * operand1;
        }
    },
    DIVIDE{
        @Override
        public Double compute(Double operand1, Double operand2) {
            return operand2 / operand1;
        }
    };

    public static boolean isOperator(String token) {
        return token.matches("[+\\-*/]");
    }

    public static BinaryOperator getOperator(String operatorString) throws IllegalArgumentException {
        switch (operatorString) {
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
        }

        throw new IllegalArgumentException();
    }


    public Double compute(Double operand1, Double operand2) {
        return null;
    }

}