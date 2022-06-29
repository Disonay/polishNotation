package operators;

public enum UnaryOperator implements Operator{
    sin(3) {
        @Override
        public Double compute(Double operand) {
            return Math.sin(operand);
        }
    },
    cos(3) {
        @Override
        public Double compute(Double operand) {
            return Math.cos(operand);
        }
    },
    abs(3) {
        @Override
        public Double compute(Double operand) {
            return Math.abs(operand);
        }
    },
    sqrt(3) {
        @Override
        public Double compute(Double operand) {
            return Math.sqrt(operand);
        }
    },
    plus(4),
    minus( 4) {
        @Override
        public Double compute(Double operand) {
            return -operand;
        }
    };

    private final int priority;

    UnaryOperator(int priority) {
        this.priority = priority;
    }

    public Double compute(Double operand) {
        return operand;
    }

    @Override
    public Double compute(Double operand1, Double operand2) {
        return null;
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
