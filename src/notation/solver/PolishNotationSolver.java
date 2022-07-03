package notation.solver;

import handlers.Handler;
import handlers.solver.SolverHandlerBinaryOperator;
import handlers.solver.SolverHandlerConstant;
import handlers.solver.SolverHandlerOperand;
import handlers.solver.SolverHandlerUnaryOperator;
import utils.exceptions.WrongPolishNotation;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

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

    public Double compute(String polishNotation) throws IOException, WrongPolishNotation {
        Scanner scanner = new Scanner(polishNotation);
        while (scanner.hasNext()) {
            handler.process(scanner.next());
        }
        return stack.pop();
    }

}
