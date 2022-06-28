package handlers;

import enums.Function;
import exceptions.WrongPolishNotation;

import java.util.ArrayDeque;
import java.util.Objects;

public class HandlerFunction extends AbstractHandler {

    public HandlerFunction(ArrayDeque<Double> stack) {
        super(stack);
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        if (Function.haveFunction(token)) {
            stack.addFirst(Function.getFunction(token).compute(stack.pop()));
        }
        else  {
            if (!Objects.isNull(nextHandler)) {
                nextHandler.process(token);
            }
            else {
                throw new WrongPolishNotation("Wrong notation");
            }
        }
    }
}
