package com.example.calculator.translators;

import com.example.calculator.lexemes.Number;
import com.example.calculator.translators.LexemeFinder;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by Владимир on 28.01.2017.
 */
public class LexemeFinderTest {

    private LexemeFinder numberExtractor;

    @Before
    public void setUp(){
        numberExtractor = new NumberFinder(
                Pattern.compile("\\G\\d+\\.\\d*"),
                Number.class
        );
    }

    @Test
    public void extractNumber() throws Exception {
        Matcher m = Pattern.compile("").matcher("123.456+123.333");
        Number number = (Number) numberExtractor.find(m);
        assertEquals(123.456, number.getValue(), 0.01);
        assertEquals(7, m.end());
    }

    @Test
    public void extractNoOne() throws Exception {
        Matcher m = Pattern.compile("").matcher("&123.456+123.333");
        Number number = (Number) numberExtractor.find(m);
        assertNull(number);
    }


}