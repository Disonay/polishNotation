package handlers;

import utils.exceptions.WrongPolishNotation;

public interface Handler {
    void process(String token) throws WrongPolishNotation;

    void process(String token, String prevToken) throws WrongPolishNotation;

    void setNext(Handler nextHandler);
}
