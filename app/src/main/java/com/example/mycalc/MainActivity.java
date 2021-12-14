package com.example.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private TextView toShowTv, resultTv;
    private Button clearbtn, equalBtn, addBtn, subBtn, divBtn, multiBtn,
            num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, decimalBtn;

    private double result, operand1, operand2;
    private int operator;
    private String term = "", expression = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toShowTv = findViewById(R.id.toShowTv);
        resultTv = findViewById(R.id.result);
        clearbtn = findViewById(R.id.clear);
        equalBtn = findViewById(R.id.equal);
        divBtn = findViewById(R.id.division);
        addBtn = findViewById(R.id.addtion);
        subBtn = findViewById(R.id.subtraction);
        multiBtn = findViewById(R.id.multiBtn);
        num0 = findViewById(R.id.num0);
        num2 = findViewById(R.id.num2);
        num1 = findViewById(R.id.num1);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        decimalBtn = findViewById(R.id.decimalBtn);
        num5 = findViewById(R.id.num5);

        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: clear text
                result=0;
                operand1=0;
                operand2=0;
                expression="";
                operator=0;

                resultTv.setText("");
                toShowTv.setText("");
            }

        });
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: compute
                hey(0);
                resultTv.setText("" + result);
                result=0;
                toShowTv.setText(expression);
                expression="";
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {hey(1);
                                          expression = expression + "/";
                                          toShowTv.setText(expression);

                                      }
                                  }
        );
        addBtn.setOnClickListener(new
                                          View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {    hey(4);
                                                  expression = expression + "+";
                                                  toShowTv.setText(expression);
                                              }
                                          });
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { hey(3);
                expression = expression + "-";
                toShowTv.setText(expression);
            }
        });
        multiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    hey(2);
                expression = expression + "*";
                toShowTv.setText(expression);
            }
        });


        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                term = term + "0";
                expression = expression + "0";

                toShowTv.setText(expression);

            }
        });

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                term = term + "1";
                expression = expression + "1";

                toShowTv.setText(expression);


            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                term = term + "3";
                expression = expression + "3";

                toShowTv.setText(expression);


            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                term = term + "2";
                expression = expression + "2";

                toShowTv.setText(expression);


            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                term = term + "4";
                expression = expression + "4";

                toShowTv.setText(expression);

            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                term = term + "5";
                expression = expression + "5";

                toShowTv.setText(expression);

            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                term = term + "6";
                expression = expression + "6";

                toShowTv.setText(expression);

            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                term = term + "7";
                expression = expression + "7";

                toShowTv.setText(expression);

            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                term = term + "8";
                expression = expression + "8";

                toShowTv.setText(expression);

            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                term = term + "9";
                expression = expression + "9";

                toShowTv.setText(expression);

            }
        });
        decimalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                term = term + ".";
                expression = expression + ".";

                toShowTv.setText(expression);
            }
        });


    }


    private void calculate(int operator) {


        if (operator == 1) {
            result = operand1 / operand2;
        }
        else if (operator == 2) {
            result = operand1 * operand2;


        } else if (operator == 4) {
            result = operand1 + operand2;


        } else if (operator == 3) {
            result = operand1 - operand2;


        }
        operand1 = 0;

    }

    private double convertToDouble(String num)
    {
        if(num.endsWith("."))
        { num = num + "0";}
        double value = Double.parseDouble(num);

        return value;
    }

    private void hey(int operationType){

        if (!term.equals("")) {
            if (operand1 == 0) {
                if (result == 0) {
                    operand1 = convertToDouble(term);
                    operator = operationType;
                } else {
                    operand1 = result;
                    operand2 = convertToDouble(term);
                    calculate(operator);
                    operator = operationType;
                }
            } else {
                operand2 = convertToDouble(term);
                calculate(operator);
                operator = operationType;
            }
            term = "";
        }
               else {
                operator = operationType;
        }
        }


    }


