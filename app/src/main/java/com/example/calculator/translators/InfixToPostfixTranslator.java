package com.example.calculator.translators;

import com.example.calculator.lexemes.Lexeme;
import com.example.calculator.lexemes.Number;
import com.example.calculator.lexemes.operators.ClosingBracket;
import com.example.calculator.lexemes.operators.OpeningBracket;
import com.example.calculator.lexemes.operators.Operator;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Владимир on 28.01.2017.
 */
public class InfixToPostfixTranslator {

    public List<Lexeme> translate(List<Lexeme> infix) throws Exception {
        List<Lexeme> result = new ArrayList<>();
        Deque<Operator> operators = new LinkedList<>();

        for (int i = 0; i < infix.size(); i++){
            processLexeme(infix.get(i), result, operators);
        }
        moveRemainingOperatorsToResult(result, operators);
        return result;
    }

    private void processLexeme(Lexeme lexeme, List<Lexeme> result, Deque<Operator> operators) {
        if (lexeme instanceof Number) {
            result.add(lexeme);
        } else if (lexeme instanceof Operator) {
            processOperator((Operator) lexeme, result, operators);
        }
    }

    private void moveRemainingOperatorsToResult(List<Lexeme> result, Deque<Operator> operators) {
        while (!operators.isEmpty()) {
            result.add(operators.pop());
        }
    }

    private void moveOperatorsToResultUntilOpeningBracket(List<Lexeme> result, Deque<Operator> operators) {
        while (!operators.isEmpty()) {
            Operator operator = operators.pop();
            if (operator instanceof OpeningBracket) {
                break;
            } else {
                result.add(operator);
            }
        }

    }

    private void processOperator(Operator operator, List<Lexeme> result, Deque<Operator> operators) {
        if (operator instanceof ClosingBracket) {
            moveOperatorsToResultUntilOpeningBracket(result, operators);
            return;
        }
        while (!operators.isEmpty()) {
            Operator top = operators.pop();
            if (top instanceof OpeningBracket) {
                operators.push(top);
                break;
            } else if (top.getPriority() < operator.getPriority()) {
                operators.push(top);
                break;
            } else {
                result.add(top);
            }
        }
        operators.push(operator);
    }

}
