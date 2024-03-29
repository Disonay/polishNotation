package handlers.solver;

import utils.exceptions.WrongPolishNotation;

import java.util.ArrayDeque;

public class SolverHandlerOperand extends AbstractSolverHandler {
    public SolverHandlerOperand(ArrayDeque<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        if (token.matches("[0-9]{1,13}(\\.[0-9]*)?")) {
            stack.addFirst(Double.parseDouble(token));
        } else {
            toNext(token);
        }
    }
}
