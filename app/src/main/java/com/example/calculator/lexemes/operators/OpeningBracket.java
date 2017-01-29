package com.example.calculator.lexemes.operators;

import com.example.calculator.lexemes.Number;

import java.util.List;

/**
 * Created by Владимир on 28.01.2017.
 */

public class OpeningBracket extends Operator {
    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public int getNumberOfArguments() {
        return 0;
    }

    @Override
    public double calculate(List<Number> arguments) {
        return 0;
    }
}
