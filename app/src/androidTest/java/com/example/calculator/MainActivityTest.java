package com.example.calculator;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Владимир on 28.01.2017.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void correctCalculation(){
        List<Example> examples = new ArrayList<>();
        examples.add(new Example("1+2*3/4", "2,5"));
        examples.add(new Example("(1+2)*3/4", "2,25"));
        examples.add(new Example("(1+2.7)*3.45/4.55", "2,81"));
        examples.add(new Example("(3.45)+4.55", "8"));
        examples.add(new Example("(3.)+4.55", "7,55"));

        Iterator<Example> iterator = examples.iterator();
        Example example;
        while(iterator.hasNext()){
            example = iterator.next();
            givenExpression(example.expression);
            whenICalculate();
            thenIGetResult(example.result);
        }
    }

    private void thenIGetResult(String result) {
        onView(withId(R.id.result)).check(matches(withText(result)));
    }

    private void whenICalculate() {
        onView(withId(R.id.calculate)).perform(click());
    }

    private void givenExpression(String expression) {
        onView(withId(R.id.expression)).perform(replaceText(expression));
    }

    private class Example{
        Example(String expression, String result){
            this.expression = expression;
            this.result = result;
        }
        String expression;
        String result;
    }

}