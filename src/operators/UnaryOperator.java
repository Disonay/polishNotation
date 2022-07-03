package operators;

public enum UnaryOperator implements Operator {
    sin(3, "sin") {
        @Override
        public Double compute(Double operand) {
            return Math.sin(operand);
        }
    }, cos(3, "cos") {
        @Override
        public Double compute(Double operand) {
            return Math.cos(operand);
        }
    }, abs(3, "abs") {
        @Override
        public Double compute(Double operand) {
            return Math.abs(operand);
        }
    }, sqrt(3, "sqrt") {
        @Override
        public Double compute(Double operand) {
            return Math.sqrt(operand);
        }
    }, plus(4, "u-"), minus(4, "u-") {
        @Override
        public Double compute(Double operand) {
            return -operand;
        }
    };

    private final int priority;
    private final String name;

    UnaryOperator(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public Double compute(Double operand) {
        return operand;
    }

    @Override
    public Double compute(Double operand1, Double operand2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String getName() {
        return name;
    }
}
