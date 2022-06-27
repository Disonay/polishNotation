package handlers;

import exceptions.WrongPolishNotation;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class HandlerOperand extends AbstractHandler {
    public HandlerOperand(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        if (token.matches("[0-9]{1,13}(\\.[0-9]*)?")) {
            stack.add(Double.parseDouble(token));
        } else {
            if (!Objects.isNull(nextHandler)) {
                nextHandler.process(token);
            } else {
                throw new WrongPolishNotation("Wrong notation");
            }
        }
    }
}
