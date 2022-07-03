package handlers.solver;

import operators.OperatorFabric;
import utils.exceptions.WrongPolishNotation;

import java.util.ArrayDeque;

public class SolverHandlerUnaryOperator extends AbstractSolverHandler {
    public SolverHandlerUnaryOperator(ArrayDeque<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        if (OperatorFabric.isUnaryOperator(token)) {
            stack.addFirst(OperatorFabric.getUnaryOperator(token).compute(stack.pop()));
        } else {
            toNext(token);
        }
    }
}
