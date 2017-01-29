package com.example.calculator.lexemes;

/**
 * Created by Владимир on 28.01.2017.
 */

public class Number extends Lexeme {
    private double value;

    public double getValue(){
        return value;
    }

    public void setValue(double value){
        this.value = value;
    }
}
