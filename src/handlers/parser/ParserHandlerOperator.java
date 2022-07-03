package handlers.parser;

import operators.Operator;
import operators.OperatorFabric;
import utils.exceptions.WrongPolishNotation;

import java.util.ArrayDeque;

public class ParserHandlerOperator extends AbstractParserHandler {
    public ParserHandlerOperator(ArrayDeque<Operator> stack, StringBuilder parsed) {
        super(stack, parsed);
    }

    @Override
    public void process(String token, String prevToken) throws WrongPolishNotation {
        if (OperatorFabric.isOperator(token)) {
            if (prevToken.isBlank() || prevToken.matches("\\(") || OperatorFabric.isOperator(prevToken)) {
                Operator newOperator = OperatorFabric.getUnaryOperator(token);
                while (!stack.isEmpty() && stack.peek().moreOrEqualByPriority(newOperator)) {
                    parsed.append(stack.pop().getName()).append(" ");
                }
                stack.addFirst(newOperator);
            } else if (prevToken.matches("\\)") || prevToken.matches("[0-9]{1,13}(\\.[0-9]*)?")) {
                Operator newOperator = OperatorFabric.getBinaryOperator(token);
                while (!stack.isEmpty() && stack.peek().moreOrEqualByPriority(newOperator)) {
                    parsed.append(stack.pop().getName()).append(" ");
                }
                stack.addFirst(newOperator);
            } else {
                toNext(token, prevToken);
            }
        } else {
            toNext(token, prevToken);
        }
    }
}
