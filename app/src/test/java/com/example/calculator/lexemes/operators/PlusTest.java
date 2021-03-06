package com.example.calculator.lexemes.operators;

import com.example.calculator.lexemes.Number;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Владимир on 29.01.2017.
 */
public class PlusTest {
    @Test
    public void calculate() throws Exception {
        Plus plus = new Plus();
        List<Number> arguments = new ArrayList<>();

        Number arg1 = new Number();
        arg1.setValue(15);
        arguments.add(arg1);

        Number arg2 = new Number();
        arg2.setValue(3);
        arguments.add(arg2);

        assertEquals(18, plus.calculate(arguments), 0.01);
    }

}