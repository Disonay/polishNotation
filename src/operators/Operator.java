package operators;

public interface Operator {
    default boolean moreOrEqualByPriority(Operator anotherOperator) {
        return this.getPriority() >= anotherOperator.getPriority();
    }

    Double compute(Double operand1, Double operand2);

    Double compute(Double operand);

    int getPriority();

    String getName();
}
