package handlers;


import exceptions.WrongPolishNotation;

public interface Handler {
    void process(String token) throws WrongPolishNotation;
    void setNext(Handler nextHandler);
}
