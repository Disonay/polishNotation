package main;

import utils.exceptions.WrongPolishNotation;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PolishNotationSolver polishNotationSolver = new PolishNotationSolver();
        try {
            System.out.println(polishNotationSolver.compute("input.txt"));
        }
        catch (IOException | WrongPolishNotation e) {
            System.out.println(e.getMessage());
        }
    }
}
