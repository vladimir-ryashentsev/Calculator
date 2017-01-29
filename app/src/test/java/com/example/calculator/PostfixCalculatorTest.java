package com.example.calculator;

import com.example.calculator.lexemes.Lexeme;
import com.example.calculator.lexemes.Number;
import com.example.calculator.lexemes.operators.Divide;
import com.example.calculator.lexemes.operators.Multiply;
import com.example.calculator.lexemes.operators.Plus;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Владимир on 29.01.2017.
 */
public class PostfixCalculatorTest {

    private PostfixCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new PostfixCalculator();
    }

    @Test
    public void calculate() throws Exception {
        List<Lexeme> postfix = new ArrayList<>();

        Number number = new Number();
        number.setValue(123.123);
        postfix.add(number);

        number = new Number();
        number.setValue(356.456);
        postfix.add(number);

        postfix.add(new Plus());

        number = new Number();
        number.setValue(7);
        postfix.add(number);

        postfix.add(new Divide());

        number = new Number();
        number.setValue(5);
        postfix.add(number);

        postfix.add(new Multiply());

        double result = calculator.calculate(postfix);
        assertEquals(342.56, result, 0.01);
    }

}