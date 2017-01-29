package com.example.calculator.translators;

import com.example.calculator.lexemes.Lexeme;
import com.example.calculator.lexemes.Number;
import com.example.calculator.lexemes.operators.ClosingBracket;
import com.example.calculator.lexemes.operators.Divide;
import com.example.calculator.lexemes.operators.Minus;
import com.example.calculator.lexemes.operators.Multiply;
import com.example.calculator.lexemes.operators.OpeningBracket;
import com.example.calculator.lexemes.operators.Plus;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Владимир on 29.01.2017.
 */
public class StringParserTest {


    private StringParser translator;

    @Before
    public void setUp() throws Exception {
        translator = new StringParser();
    }

    @Test
    public void translate() throws Exception {
        List<Lexeme> lexemes = translator.translate("123.123+456/4*(1-2)");
        assertNotNull(lexemes);
        assertEquals(11, lexemes.size());
        assertEquals(123.123, ((Number)lexemes.get(0)).getValue(), 0.01);
        assertTrue(lexemes.get(1) instanceof Plus);
        assertEquals(456, ((Number)lexemes.get(2)).getValue(), 0.01);
        assertTrue(lexemes.get(3) instanceof Divide);
        assertEquals(4, ((Number)lexemes.get(4)).getValue(), 0.01);
        assertTrue(lexemes.get(5) instanceof Multiply);
        assertTrue(lexemes.get(6) instanceof OpeningBracket);
        assertEquals(1, ((Number)lexemes.get(7)).getValue(), 0.01);
        assertTrue(lexemes.get(8) instanceof Minus);
        assertEquals(2, ((Number)lexemes.get(9)).getValue(), 0.01);
        assertTrue(lexemes.get(10) instanceof ClosingBracket);
    }

}