package notation.parser;

import handlers.Handler;
import handlers.parser.ParserHandlerBracket;
import handlers.parser.ParserHandlerConstant;
import handlers.parser.ParserHandlerOperand;
import handlers.parser.ParserHandlerOperator;
import operators.Operator;
import utils.exceptions.WrongPolishNotation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixParser {
    private final ArrayDeque<Operator> stack;
    private final StringBuilder parsed;
    private final Handler handler;

    public InfixParser() {
        this.parsed = new StringBuilder();
        stack = new ArrayDeque<>();

        handler = new ParserHandlerOperand(stack, parsed);
        Handler handler2 = new ParserHandlerConstant(stack, parsed);
        Handler handler3 = new ParserHandlerOperator(stack, parsed);
        Handler handler4 = new ParserHandlerBracket(stack, parsed);

        handler3.setNext(handler4);
        handler2.setNext(handler3);
        handler.setNext(handler2);
    }

    public String compute(String filePath) throws IOException, WrongPolishNotation {
        Scanner scanner = new Scanner(Files.readString(Path.of(filePath)));
        String prevToken = "";
        while (scanner.hasNext()) {
            String token = scanner.next();
            handler.process(token, prevToken);
            prevToken = token;
        }
        while (!stack.isEmpty()) {
            parsed.append(stack.pop().getName()).append(" ");
        }
        return parsed.toString();
    }
}
