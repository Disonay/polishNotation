package handlers.parser;

import operators.Operator;
import utils.exceptions.WrongPolishNotation;

import java.util.ArrayDeque;

public class ParserHandlerOperand extends AbstractParserHandler {

    public ParserHandlerOperand(ArrayDeque<Operator> stack, StringBuilder parsed) {
        super(stack, parsed);
    }

    @Override
    public void process(String token, String prevToken) throws WrongPolishNotation {
        if (token.matches("[0-9]{1,13}(\\.[0-9]*)?")) {
            parsed.append(Double.parseDouble(token)).append(" ");
        } else {
            toNext(token, prevToken);
        }
    }
}
