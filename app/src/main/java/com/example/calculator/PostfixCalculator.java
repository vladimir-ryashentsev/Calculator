package com.example.calculator;

import com.example.calculator.lexemes.Lexeme;
import com.example.calculator.lexemes.Number;
import com.example.calculator.lexemes.operators.Operator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владимир on 29.01.2017.
 */

public class PostfixCalculator {

    public double calculate(List<Lexeme> postfix) {
        Lexeme lexeme;
        Operator operator;
        while (postfix.size() > 1) {
            for (int i = 0; i < postfix.size(); i++) {
                lexeme = postfix.get(i);
                if (lexeme instanceof Operator) {
                    operator = (Operator) lexeme;
                    processOperator(operator, i, postfix);
                    break;
                }
            }
        }
        Number result = (Number) postfix.get(0);
        return result.getValue();
    }

    private void processOperator(Operator operator, int position, List<Lexeme> postfix) {
        List<Number> arguments = extractArguments(
                position - operator.getNumberOfArguments(),
                operator.getNumberOfArguments(),
                postfix);

        postfix.remove(position - operator.getNumberOfArguments());
        Number number = new Number();
        number.setValue(operator.calculate(arguments));

        postfix.add(position - operator.getNumberOfArguments(), number);
    }

    private List<Number> extractArguments(int fromPosition, int count, List<Lexeme> postfix) {
        List<Number> arguments = new ArrayList<>();
        while (arguments.size() < count)
            arguments.add((Number) postfix.remove(fromPosition));
        return arguments;
    }
}
