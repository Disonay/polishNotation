package handlers.parser;

import operators.Operator;
import utils.Constant;
import utils.exceptions.WrongPolishNotation;

import java.util.ArrayDeque;

public class ParserHandlerConstant extends AbstractParserHandler {
    public ParserHandlerConstant(ArrayDeque<Operator> stack, StringBuilder parsed) {
        super(stack, parsed);
    }

    @Override
    public void process(String token, String prevToken) throws WrongPolishNotation {
        if (Constant.haveConstant(token)) {
            parsed.append(Constant.valueOf(token).getDoubleValue()).append(" ");
        } else {
            toNext(token, prevToken);
        }
    }
}
