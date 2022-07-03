package handlers.solver;

import operators.OperatorFabric;
import utils.exceptions.WrongPolishNotation;

import java.util.ArrayDeque;

public class SolverHandlerBinaryOperator extends AbstractSolverHandler {
    public SolverHandlerBinaryOperator(ArrayDeque<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        if (OperatorFabric.isBinaryOperator(token)) {
            stack.addFirst(OperatorFabric.getBinaryOperator(token).compute(stack.pop(), stack.pop()));
        } else {
            toNext(token);
        }
    }
}
