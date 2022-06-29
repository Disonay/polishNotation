package handlers;

import java.util.ArrayDeque;
import java.util.Stack;

public abstract class AbstractHandler implements Handler {
    protected ArrayDeque<Double> stack;

    protected StringBuilder postfix;
    public Handler nextHandler;

    protected AbstractHandler(ArrayDeque<Double> stack) {
        this.stack = stack;
    }

    protected AbstractHandler() {
        stack = new ArrayDeque<>();
        postfix = new StringBuilder();
    }

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
