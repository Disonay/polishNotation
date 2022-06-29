package operators;

public enum BinaryOperator implements Operator {
    SUM(1){
        @Override
        public Double compute(Double operand1, Double operand2) {
            return operand2 + operand1;
        }
    },
    SUBTRACT(1){
        @Override
        public Double compute(Double operand1, Double operand2) {
            return operand2 - operand1;
        }
    },
    MULTIPLY(2){
        @Override
        public Double compute(Double operand1, Double operand2) {
            return operand2 * operand1;
        }
    },
    DIVIDE(2){
        @Override
        public Double compute(Double operand1, Double operand2) {
            return operand2 / operand1;
        }
    };

    private final int priority;
    BinaryOperator(int priority) {
        this.priority = priority;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public Double compute(Double operand) {
        return null;
    }
}