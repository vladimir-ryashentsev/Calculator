package com.example.calculator.lexemes.operators;

import com.example.calculator.lexemes.Lexeme;
import com.example.calculator.lexemes.Number;

import java.util.List;

/**
 * Created by Владимир on 29.01.2017.
 */

public abstract class Operator extends Lexeme {
    public abstract int getPriority();

    public abstract int getNumberOfArguments();

    public abstract double calculate(List<Number> arguments);
}
