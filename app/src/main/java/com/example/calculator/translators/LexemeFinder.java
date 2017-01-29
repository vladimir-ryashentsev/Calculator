package com.example.calculator.translators;

import com.example.calculator.lexemes.Lexeme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Владимир on 28.01.2017.
 */

public class LexemeFinder {

    private Pattern pattern;
    private Class<? extends Lexeme> cls;

    public LexemeFinder(Pattern pattern, Class<? extends Lexeme> cls){
        this.pattern = pattern;
        this.cls = cls;
    }

    public Lexeme find(Matcher matcher) throws Exception{
        matcher.usePattern(pattern);
        if(matcher.find()){
            Lexeme lexeme = cls.newInstance();
            return lexeme;
        }
        return null;
    }
}
