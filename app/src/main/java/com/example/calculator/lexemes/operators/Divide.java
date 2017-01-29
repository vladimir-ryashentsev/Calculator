package com.example.calculator.lexemes.operators;

import com.example.calculator.lexemes.Number;

import java.util.List;

/**
 * Created by Владимир on 28.01.2017.
 */

public class Divide extends Operator {
    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public int getNumberOfArguments() {
        return 2;
    }

    @Override
    public double calculate(List<Number> arguments) {
        return arguments.get(0).getValue()/arguments.get(1).getValue();
    }
}
