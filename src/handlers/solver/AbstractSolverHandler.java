package handlers.solver;

import handlers.Handler;
import utils.exceptions.WrongPolishNotation;

import java.util.ArrayDeque;
import java.util.Objects;

public abstract class AbstractSolverHandler implements Handler {
    public Handler nextHandler;
    protected ArrayDeque<Double> stack;

    protected AbstractSolverHandler(ArrayDeque<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void toNext(String token) throws WrongPolishNotation {
        if (!Objects.isNull(nextHandler)) {
            nextHandler.process(token);
        } else {
            throw new WrongPolishNotation("Wrong notation");
        }
    }

    @Override
    public void process(String token, String prevToken) throws WrongPolishNotation {
        throw new UnsupportedOperationException();
    }

}
