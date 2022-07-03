package handlers.parser;

import handlers.Handler;
import operators.Operator;
import utils.exceptions.WrongPolishNotation;

import java.util.ArrayDeque;
import java.util.Objects;

public abstract class AbstractParserHandler implements Handler {
    protected ArrayDeque<Operator> stack;
    protected StringBuilder parsed;
    public Handler nextHandler;

    protected AbstractParserHandler(ArrayDeque<Operator> stack, StringBuilder parsed) {
        this.stack = stack;
        this.parsed = parsed;
    }

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void toNext(String token, String prevToken) throws WrongPolishNotation {
        if (!Objects.isNull(nextHandler)) {
            nextHandler.process(token, prevToken);
        }
        else {
            throw new WrongPolishNotation("Wrong notation");
        }
    }

    @Override
    public void process(String token) throws WrongPolishNotation {
        throw new UnsupportedOperationException();
    }
}
