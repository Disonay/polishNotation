import notation.parser.InfixParser;
import notation.solver.PolishNotationSolver;
import utils.exceptions.WrongPolishNotation;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        InfixParser infixParser = new InfixParser();
        PolishNotationSolver polishNotationSolver = new PolishNotationSolver();
        try {
            String parsed = infixParser.compute(args[0]);
            System.out.println(parsed);
            System.out.println(polishNotationSolver.compute(parsed));
        } catch (IOException | WrongPolishNotation e) {
            System.out.println(e.getMessage());
        }
    }
}
