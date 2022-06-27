package handlers;

import java.util.Stack;

public abstract class AbstractHandler implements Handler {
    Stack<Double> stack;
    Handler nextHandler;

    AbstractHandler(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
