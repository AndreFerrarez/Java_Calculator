package com.company.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn_0, btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_ac,
            btn_del, btn_divide,btn_multi,btn_minus,btn_plus,btn_equals,btn_dot;

    private TextView textView_history, textview_result;

    private String number = null;

    double firstNumber = 0;
    double lastNumber = 0;

    String status = null;
    Boolean operator = false;

    DecimalFormat myFormatter = new DecimalFormat("######.######");

    String history, currentResult;

    Boolean dot = true;
    Boolean btnAcControl = true;
    Boolean btnEqualsControl = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_ac = findViewById(R.id.btn_ac);

        btn_del = findViewById(R.id.btn_del);
        btn_divide = findViewById(R.id.btn_divide);
        btn_multi = findViewById(R.id.btn_multi);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        btn_equals = findViewById(R.id.btn_equals);
        btn_dot = findViewById(R.id.btn_dot);

        textView_history = findViewById(R.id.text_view_history);
        textview_result = findViewById(R.id.text_view_result);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview_result.setText("0");
                textView_history.setText("");
                firstNumber = 0;
                lastNumber = 0;
                number = null;
                status = null;
                dot = true;
                btnAcControl = true;



            }
        });
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAcControl){
                    textview_result.setText("0");
                }
                else {
                    number = number.substring(0,number.length()-1);
                    if (number.length() == 0){
                        btn_del.setClickable(false);
                    }
                    else if (number.contains(".")){
                        dot = false;
                    }
                    else {
                        dot = true;
                    }
                    textview_result.setText(number);
                }


            }
        });

        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textView_history.getText().toString();
                currentResult = textview_result.getText().toString();
                textView_history.setText(history+currentResult+"*");

                if(operator){
                    if(status == "sum"){
                        plus();
                    }
                    else if(status == "division"){
                        divide();
                    }
                    else if (status == "subtraction") {
                        minus();
                    }
                    else {
                        multiply();
                    }
                }

                status = "multiplication";
                operator = false;
                number = null;
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textView_history.getText().toString();
                currentResult = textview_result.getText().toString();
                textView_history.setText(history+currentResult+"/");

                if(operator){
                    if(status =="multiplication"){
                        multiply();
                    }
                    else if (status == "sum"){
                        plus();
                    }
                    else if ( status == "subtraction"){
                        minus();
                    }
                    else{
                        divide();
                    }
                }
                status = "division";
                operator = false;
                number = null;

            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textView_history.getText().toString();
                currentResult = textview_result.getText().toString();
                textView_history.setText(history+currentResult+"-");

                if(operator){
                    if (status == "multiplication"){
                        multiply();
                    }
                    else if (status == "division"){
                        divide();
                    }
                    else if (status == "sum"){
                        plus();
                    }
                    else{
                        minus();
                    }
                }

                status = "subtraction";
                operator = false;
                number = null;

            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textView_history.getText().toString();
                currentResult = textview_result.getText().toString();
                textView_history.setText(history+currentResult+"+");

                if(operator){
                    if (status == "multiplication") {

                        multiply();
                    }
                    else if (status == "division"){
                        divide();
                    }
                    else if (status == "subtraction"){
                        minus();
                    }
                    else {
                        plus();
                    }
                }
                status = "sum";
                operator = false;
                number = null;
            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator){
                    if (status == "sum"){
                        plus();
                    }
                    else if (status == "subtraction"){
                        minus();
                    }
                    else if (status == "multiplication"){
                        multiply();
                    }
                    else if (status == "division") {
                        divide();
                    }
                    else {
                        firstNumber = Double.parseDouble(textview_result.getText().toString());
                    }
                }
                operator = false;
                btnEqualsControl = true;

            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dot)
                {
                    if(number == null){
                        number = "0.";
                    }
                    else {
                        number = number + ".";
                    }
                    textview_result.setText(number);
                }
                textview_result.setText(number);
                dot = false;

            }

        });
    }

    public void numberClick(String view){
        if(number == null )
        {
            number = view;
        }
        else if (btnEqualsControl){
            firstNumber = 0;
            lastNumber = 0;
            number = view;
        }
        else{
            number = number + view;
        }
        textview_result.setText(number);
        operator = true;
        btnAcControl = false;
        btn_del.setClickable(true);
        btnEqualsControl = false;
    }

    public void plus(){
        lastNumber = Double.parseDouble(textview_result.getText().toString());
        firstNumber = firstNumber + lastNumber;
        textview_result.setText(myFormatter.format(firstNumber));
        dot = true;
    };

    public void minus(){
        if(firstNumber == 0){
            firstNumber = Double.parseDouble(textview_result.getText().toString());
        }
        else{
            lastNumber = Double.parseDouble(textview_result.getText().toString());
            firstNumber = firstNumber - lastNumber;

        }
        textview_result.setText(myFormatter.format(firstNumber));
        dot = true;
    };

    public void multiply(){
        if(firstNumber == 0){
            firstNumber = 1;
            lastNumber = Double.parseDouble(textview_result.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        else {
            lastNumber = Double.parseDouble(textview_result.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        textview_result.setText(myFormatter.format(firstNumber));
        dot = true;
    };

    public void divide(){
        if(firstNumber == 0){
             lastNumber = Double.parseDouble(textview_result.getText().toString());
             firstNumber = lastNumber / 1;
        }
        else {
            lastNumber = Double.parseDouble(textview_result.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }
        textview_result.setText(myFormatter.format(firstNumber));
        dot = true;
    };



}






















