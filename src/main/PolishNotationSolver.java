package main;

import exceptions.WrongPolishNotation;
import handlers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class PolishNotationSolver {
    private final Stack<Double> stack;
    private final Handler handler;

    public PolishNotationSolver() {
        stack = new Stack<>();

        handler = new HandlerOperand(stack);
        Handler handler2 = new HandlerConstant(stack);
        Handler handler3 = new HandlerFunction(stack);
        Handler handler4 = new HandlerOperator(stack);

        handler3.setNext(handler4);
        handler2.setNext(handler3);
        handler.setNext(handler2);
    }

    public Double compute(String filePath) throws IOException, WrongPolishNotation {
        Scanner scanner = new Scanner(Files.readString(Path.of(filePath)));
        while (scanner.hasNext()) {
            handler.process(scanner.next());
        }
        return stack.pop();
    }

}
