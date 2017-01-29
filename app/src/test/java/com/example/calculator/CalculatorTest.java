package com.example.calculator;

import com.example.calculator.translators.InfixToPostfixTranslator;
import com.example.calculator.translators.StringParser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Владимир on 28.01.2017.
 */
public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator(new StringParser(),
                new InfixToPostfixTranslator(),
                new PostfixCalculator());
    }

    @Test
    public void returnResultWhenExpressionIsCorrect() throws Exception {
        assertEquals(calculator.calculate("1+1"), 2, 0.01);
        assertEquals(calculator.calculate("1+2*3/4"), 2.5, 0.01);
        assertEquals(calculator.calculate("(1+2)*3/4"), 2.25, 0.01);
        assertEquals(calculator.calculate("(1+2.7)*3.45/4.55"), 2.81, 0.01);
        assertEquals(calculator.calculate("(3.45)+4.55"), 8, 0.01);
        assertEquals(calculator.calculate("(3.)+4.55"), 7.55, 0.01);
    }

    @Test
    public void throwsWhenExpressionIsIncorrect() throws Exception {
        try {
            calculator.calculate("1 2");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
        try {
            calculator.calculate("+ .");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
        try {
            calculator.calculate(".");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
        try {
            calculator.calculate(".+1");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}