package handlers;

import enums.BinaryOperator;
import exceptions.WrongPolishNotation;

import java.util.Objects;
import java.util.Stack;

public class HandlerOperator extends AbstractHandler{
    public HandlerOperator(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        if (BinaryOperator.isOperator(token)) {
            stack.add(BinaryOperator.getOperator(token).compute(stack.pop(), stack.pop()));
        }
        else {
            if (!Objects.isNull(nextHandler)) {
                nextHandler.process(token);
            }
            else {
                throw new WrongPolishNotation("Wrong notation");
            }
        }
    }
}
