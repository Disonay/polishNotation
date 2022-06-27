package enums;

public enum Function {
    sin("sin") {
        @Override
        public Double compute(Double operand) {
            return Math.sin(operand);
        }
    },
    cos("cos") {
        @Override
        public Double compute(Double operand) {
            return Math.cos(operand);
        }
    },
    abs("abs") {
        @Override
        public Double compute(Double operand) {
            return Math.abs(operand);
        }
    };

    private final String functionName;
    Function(String functionName) {
        this.functionName = functionName;
    }

    public static Function getFunction(String stringFucntion) {
        switch (stringFucntion) {
            case "sin" -> {
                return Function.sin;
            }
            case "cos" -> {
                return Function.cos;
            }
            case "||", "abs" -> {
                return Function.abs;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getFunctionName() {
        return functionName;
    }

    public Double compute(Double operand) {
        return null;
    }
}
