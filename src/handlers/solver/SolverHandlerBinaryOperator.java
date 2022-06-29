package handlers.solver;

import operators.OperatorFabric;
import utils.exceptions.WrongPolishNotation;

import java.util.ArrayDeque;
import java.util.Objects;

public class SolverHandlerBinaryOperator extends AbstractSolverHandler {
    public SolverHandlerBinaryOperator(ArrayDeque<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        if (OperatorFabric.isBinaryOperator(token) && stack.size() >= 2) {
            stack.addFirst(OperatorFabric.getOperator(token).compute(stack.pop(), stack.pop()));
        }
        else {
            if (!Objects.isNull(nextHandler)) {
                nextHandler.process(token);
            }
            else {
                throw new WrongPolishNotation("Wrong notation");
            }
        }
    }
}
