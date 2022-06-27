package handlers;

import exceptions.WrongPolishNotation;

import java.util.Objects;
import java.util.Stack;

public class HandlerOperand extends AbstractHandler {
    public HandlerOperand(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        try {
            stack.add(Double.parseDouble(token));
        }
        catch (NumberFormatException e) {
            if (!Objects.isNull(nextHandler)) {
                nextHandler.process(token);
            }
            else {
                throw new WrongPolishNotation("Wrong notation", e);
            }
        }
    }
}
