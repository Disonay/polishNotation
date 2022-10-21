package operators;

public class UncommonOperator implements Operator {
    private final int priority;
    private final String name;

    public UncommonOperator(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    @Override
    public boolean moreOrEqualByPriority(Operator anotherOperator) {
        return Operator.super.moreOrEqualByPriority(anotherOperator);
    }

    @Override
    public Double compute(Double operand1, Double operand2) {
        return null;
    }

    @Override
    public Double compute(Double operand) {
        return null;
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
