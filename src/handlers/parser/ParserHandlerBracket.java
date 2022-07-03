package handlers.parser;

import operators.Operator;
import operators.UncommonOperator;
import utils.exceptions.WrongPolishNotation;

import java.util.ArrayDeque;

public class ParserHandlerBracket extends AbstractParserHandler {
    public ParserHandlerBracket(ArrayDeque<Operator> stack, StringBuilder parsed) {
        super(stack, parsed);
    }

    @Override
    public void process(String token, String prevToken) throws WrongPolishNotation {
        if (token.matches("\\(")) {
            stack.addFirst(new UncommonOperator(-1, "("));
        } else if (token.matches("\\)")) {
            Operator newOperator = new UncommonOperator(0, ")");
            while (!stack.isEmpty() && stack.peek().moreOrEqualByPriority(newOperator)) {
                parsed.append(stack.pop().getName()).append(" ");
            }
            if (!stack.isEmpty() && stack.peek().getName().equals("(")) {
                stack.pop();
            }
        } else {
            toNext(token, prevToken);
        }
    }
}
