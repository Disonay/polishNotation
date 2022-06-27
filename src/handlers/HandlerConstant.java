package handlers;

import enums.Constant;
import exceptions.WrongPolishNotation;

import java.util.Objects;
import java.util.Stack;

public class HandlerConstant extends AbstractHandler {
    public HandlerConstant(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        try {
            stack.add(Constant.valueOf(token).getDoubleValue());
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