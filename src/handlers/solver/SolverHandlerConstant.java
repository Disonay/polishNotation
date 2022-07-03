package handlers.solver;

import utils.Constant;
import utils.exceptions.WrongPolishNotation;

import java.util.ArrayDeque;

public class SolverHandlerConstant extends AbstractSolverHandler {
    public SolverHandlerConstant(ArrayDeque<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        if (Constant.haveConstant(token)) {
            stack.addFirst(Constant.valueOf(token).getDoubleValue());
        } else {
            toNext(token);
        }
    }

}
