package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculator.translators.InfixToPostfixTranslator;
import com.example.calculator.translators.StringParser;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private EditText expression;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator(
                new StringParser(),
                new InfixToPostfixTranslator(),
                new PostfixCalculator());

        expression = (EditText) findViewById(R.id.expression);
        result = (TextView) findViewById(R.id.result);

        findViewById(R.id.calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exp = expression.getText().toString();
                try {
                    double res = calculator.calculate(exp);
                    DecimalFormat df = new DecimalFormat("0.##");
                    result.setText(df.format(res));
                } catch (Exception e) {
                    result.setText(e.getMessage());
                }
            }
        });
    }
}
