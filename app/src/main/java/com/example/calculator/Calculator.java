package com.example.calculator;

import com.example.calculator.lexemes.Lexeme;
import com.example.calculator.translators.InfixToPostfixTranslator;
import com.example.calculator.translators.StringParser;

import java.util.List;

/**
 * Created by Владимир on 28.01.2017.
 */

public class Calculator {

    private InfixToPostfixTranslator infixToPostfixTranslator;
    private PostfixCalculator postfixCalculator;
    private StringParser stringParser;

    public Calculator(StringParser stringParser,
                      InfixToPostfixTranslator infixToPostfixTranslator,
                      PostfixCalculator postfixCalculator) {
        this.stringParser = stringParser;
        this.infixToPostfixTranslator = infixToPostfixTranslator;
        this.postfixCalculator = postfixCalculator;
    }

    public double calculate(String expression) throws Exception {
        List<Lexeme> infix = stringParser.translate(expression);
        List<Lexeme> postfix = infixToPostfixTranslator.translate(infix);
        return postfixCalculator.calculate(postfix);
    }
}
