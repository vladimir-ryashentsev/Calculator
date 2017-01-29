package com.example.calculator.translators;

import com.example.calculator.lexemes.Lexeme;
import com.example.calculator.lexemes.Number;
import com.example.calculator.lexemes.operators.ClosingBracket;
import com.example.calculator.lexemes.operators.Divide;
import com.example.calculator.lexemes.operators.Minus;
import com.example.calculator.lexemes.operators.Multiply;
import com.example.calculator.lexemes.operators.OpeningBracket;
import com.example.calculator.lexemes.operators.Plus;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Владимир on 29.01.2017.
 */

public class StringParser {

    private List<LexemeFinder> lexemeFinders;

    public StringParser() {
        lexemeFinders = new ArrayList<>();
        lexemeFinders.add(new LexemeFinder(Pattern.compile("^\\+"), Plus.class));
        lexemeFinders.add(new LexemeFinder(Pattern.compile("^-"), Minus.class));
        lexemeFinders.add(new NumberFinder(Pattern.compile("^\\d+\\.?\\d*"), Number.class));
        lexemeFinders.add(new LexemeFinder(Pattern.compile("^/"), Divide.class));
        lexemeFinders.add(new LexemeFinder(Pattern.compile("^\\*"), Multiply.class));
        lexemeFinders.add(new LexemeFinder(Pattern.compile("^\\("), OpeningBracket.class));
        lexemeFinders.add(new LexemeFinder(Pattern.compile("^\\)"), ClosingBracket.class));
    }

    public List<Lexeme> translate(String input) throws Exception {
        List<Lexeme> result = new ArrayList<>();
        Matcher matcher = Pattern.compile("").matcher(input);
        Lexeme lexeme;
        do {
            lexeme = nextLexeme(matcher);
            if (lexeme != null) {
                result.add(lexeme);
                input = input.substring(matcher.end());
                matcher = Pattern.compile("").matcher(input);
            } else if (input.length() > 0)
                throw new Exception("Не удалось распознать лексему в этой строке: " + input);
        } while (lexeme != null && input.length() != 0);
        return result;
    }

    private Lexeme nextLexeme(Matcher matcher) throws Exception {
        Lexeme lexeme = null;
        for (int i = 0; i < lexemeFinders.size(); i++) {
            lexeme = lexemeFinders.get(i).find(matcher);
            if (lexeme != null) break;
        }
        return lexeme;
    }
}
