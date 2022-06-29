package handlers.solver;

import operators.OperatorFabric;
import utils.exceptions.WrongPolishNotation;

import java.util.ArrayDeque;
import java.util.Objects;

public class SolverHandlerUnaryOperator extends AbstractSolverHandler {
    public SolverHandlerUnaryOperator(ArrayDeque<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        if (OperatorFabric.isUnaryOperator(token) && stack.size() == 1) {
            stack.addFirst(OperatorFabric.getOperator(token).compute(stack.pop()));
        }
        else {
            if (!Objects.isNull(nextHandler)) {
                nextHandler.process(token);
            } else {
                throw new WrongPolishNotation("Wrong notation");
            }
        }
    }
}
