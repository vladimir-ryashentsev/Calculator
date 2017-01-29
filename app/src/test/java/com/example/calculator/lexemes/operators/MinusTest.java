package com.example.calculator.lexemes.operators;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import com.example.calculator.lexemes.Number;

import static org.junit.Assert.*;

/**
 * Created by Владимир on 29.01.2017.
 */
public class MinusTest {
    @Test
    public void calculate() throws Exception {
        Minus minus = new Minus();
        List<Number> arguments = new ArrayList<>();

        Number arg1 = new Number();
        arg1.setValue(45);
        arguments.add(arg1);

        Number arg2 = new Number();
        arg2.setValue(15);
        arguments.add(arg2);

        assertEquals(30, minus.calculate(arguments), 0.01);
    }

}