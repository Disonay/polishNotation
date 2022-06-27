package handlers;

import enums.Function;
import exceptions.WrongPolishNotation;

import java.util.Objects;
import java.util.Stack;

public class HandlerFunction extends AbstractHandler {

    public HandlerFunction(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        try {
            stack.add(Function.getFunction(token).compute(stack.pop()));
        }
        catch (IllegalArgumentException e) {
            if (!Objects.isNull(nextHandler)) {
                nextHandler.process(token);
            }
            else {
                throw new WrongPolishNotation("Wrong notation", e);
            }
        }
    }
}
