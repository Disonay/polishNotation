package handlers.solver;

import handlers.Handler;

import java.util.ArrayDeque;

public abstract class AbstractSolverHandler implements Handler{
    protected ArrayDeque<Double> stack;
    public Handler nextHandler;

    protected AbstractSolverHandler(ArrayDeque<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
