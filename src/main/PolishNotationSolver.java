package main;

import utils.exceptions.WrongPolishNotation;
import handlers.*;
import handlers.solver.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class PolishNotationSolver {
    private final ArrayDeque<Double> stack;
    private final Handler handler;

    public PolishNotationSolver() {
        stack = new ArrayDeque<>();

        handler = new SolverHandlerOperand(stack);
        Handler handler2 = new SolverHandlerConstant(stack);
        Handler handler3 = new SolverHandlerUnaryOperator(stack);
        Handler handler4 = new SolverHandlerBinaryOperator(stack);

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
