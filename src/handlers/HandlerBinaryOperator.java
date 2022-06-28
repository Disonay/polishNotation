package handlers;

import enums.BinaryOperator;
import exceptions.WrongPolishNotation;

import java.util.ArrayDeque;
import java.util.Objects;

public class HandlerBinaryOperator extends AbstractHandler{
    public HandlerBinaryOperator(ArrayDeque<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        if (BinaryOperator.isBinaryOperator(token)) {
            stack.addFirst(BinaryOperator.getOperator(token).compute(stack.pop(), stack.pop()));
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
