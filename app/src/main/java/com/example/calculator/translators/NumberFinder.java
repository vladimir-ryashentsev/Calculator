package com.example.calculator.translators;

import com.example.calculator.lexemes.Lexeme;
import com.example.calculator.lexemes.Number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Владимир on 29.01.2017.
 */
public class NumberFinder extends LexemeFinder {
    public NumberFinder(Pattern pattern, Class<? extends Lexeme> cls) {
        super(pattern, cls);
    }

    @Override
    public Lexeme find(Matcher matcher) throws Exception {
        Lexeme lexeme = super.find(matcher);
        if(lexeme!=null){
            Number number = (Number) lexeme;
            number.setValue(Double.parseDouble(matcher.group()));
        }
        return lexeme;
    }
}
