package handlers;

import java.util.ArrayDeque;
import java.util.Stack;

public abstract class AbstractHandler implements Handler {
    ArrayDeque<Double> stack;
    Handler nextHandler;

    AbstractHandler(ArrayDeque<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
