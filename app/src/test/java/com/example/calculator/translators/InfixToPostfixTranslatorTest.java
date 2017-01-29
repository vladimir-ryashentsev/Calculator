package com.example.calculator.translators;

import com.example.calculator.lexemes.Lexeme;
import com.example.calculator.lexemes.Number;
import com.example.calculator.translators.InfixToPostfixTranslator;
import com.example.calculator.lexemes.operators.ClosingBracket;
import com.example.calculator.lexemes.operators.Divide;
import com.example.calculator.lexemes.operators.Multiply;
import com.example.calculator.lexemes.operators.OpeningBracket;
import com.example.calculator.lexemes.operators.Plus;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Владимир on 28.01.2017.
 */
public class InfixToPostfixTranslatorTest {

    private InfixToPostfixTranslator infixToPostfixTranslator;

    @Before
    public void setUp() throws Exception {
        infixToPostfixTranslator = new InfixToPostfixTranslator();
    }

    @Test
    public void extractNumberPlusNumber() throws Exception {
        List<Lexeme> infix = new ArrayList<>();

        infix.add(new OpeningBracket());

        Number number = new Number();
        number.setValue(123.123);
        infix.add(number);

        infix.add(new Plus());

        number = new Number();
        number.setValue(356.456);
        infix.add(number);

        infix.add(new ClosingBracket());

        infix.add(new Divide());

        number = new Number();
        number.setValue(7);
        infix.add(number);

        infix.add(new Multiply());

        infix.add(new OpeningBracket());

        number = new Number();
        number.setValue(5);
        infix.add(number);

        infix.add(new ClosingBracket());

        List<Lexeme> lexemes = infixToPostfixTranslator.translate(infix);

        assertTrue(lexemes.size()==7);
        assertEquals(123.123, ((Number)lexemes.get(0)).getValue(), 0.01);
        assertEquals(356.456, ((Number)lexemes.get(1)).getValue(), 0.01);
        assertTrue(lexemes.get(2) instanceof Plus);
        assertEquals(7, ((Number)lexemes.get(3)).getValue(), 0.01);
        assertTrue(lexemes.get(4) instanceof Divide);
        assertEquals(5, ((Number)lexemes.get(5)).getValue(), 0.01);
        assertTrue(lexemes.get(6) instanceof Multiply);
    }

}