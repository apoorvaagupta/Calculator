package com.example.apoorvaa.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clear = (Button) findViewById(R.id.clear);
        Button divide = (Button) findViewById(R.id.divide);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button bkspc = (Button) findViewById(R.id.bkspc);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button minus = (Button) findViewById(R.id.minus);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button plus = (Button) findViewById(R.id.plus);
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button decimal = (Button) findViewById(R.id.decimal);
        Button zero = (Button) findViewById(R.id.zero);
        Button ob = (Button) findViewById(R.id.ob);
        Button cb = (Button) findViewById(R.id.cb);
        Button equal = (Button) findViewById(R.id.equals);
        answer = (TextView) findViewById(R.id.answer);


        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                answer.setText("");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "/");
            }
        });


        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "*");
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "+");
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "-");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "1");
            }
        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "2");
            }
        });


        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "3");
            }
        });


        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "5");
            }
        });


        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "6");
            }
        });


        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "7");
            }
        });


        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "9");
            }
        });


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "0");
            }
        });


        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + ".");
            }
        });


        ob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + "(");
            }
        });

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                answer.setText(s + ")");
            }
        });

        bkspc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String s = answer.getText().toString();
                if(s.length()>0)
                answer.setText(s.substring(0,s.length()-1));
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = answer.getText().toString();
                String infixString = "";
                boolean flag = false, decimal;
                char count = 'a';
                HashMap<Character, Float> map  = new HashMap<>();
                float temp = 0;
                for(int i = 0;i<str.length();i++){
                    char ch = str.charAt(i);
                    Log.d(TAG,"hello " + ch) ;
                    if(ch>='0' && ch<='9'){
                        Log.d(TAG,"reached " + temp) ;

                        flag = true;
                        temp = temp*10 + (float) ch - '0';
                        Log.d(TAG,"after change " + temp) ;

                    } else{
                        if(flag == true){
                            map.put(count, temp);
                            infixString+=count;
                            count++;
                            temp = 0;
                            flag = false;
                            Log.d(TAG,"heyyya " + count + " " + temp) ;
                        }
                        infixString+=ch;
                    }
                }
                if(flag == true){
                    map.put(count, temp);
                    infixString+=count;
                    count++;
                    temp = 0;
                    flag = false;
                }

                String post = convertToPostfix(infixString);
                float ans = eval(post, map);
                answer.setText(String.valueOf(ans));

            }
        });


    }

    private boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^'
                || c == '(' || c == ')';
    }

    private boolean isLowerPrecedence(char op1, char op2)
    {
        switch (op1)
        {
            case '+':
            case '-':
                return !(op2 == '+' || op2 == '-');

            case '*':
            case '/':
                return op2 == '^' || op2 == '(';

            case '^':
                return op2 == '(';

            case '(':
                return true;

            default:
                return false;
        }
    }

    private String convertToPostfix(String infix)
    {
        Stack<Character> stack = new Stack<Character>();
        StringBuffer postfix = new StringBuffer(infix.length());
        char c;

        for (int i = 0; i < infix.length(); i++)
        {
            c = infix.charAt(i);

            if (!isOperator(c))
            {
                postfix.append(c);
            }

            else
            {
                if (c == ')')
                {

                    while (!stack.isEmpty() && stack.peek() != '(')
                    {
                        postfix.append(stack.pop());
                    }
                    if (!stack.isEmpty())
                    {
                        stack.pop();
                    }
                }

                else
                {
                    if (!stack.isEmpty() && !isLowerPrecedence(c, stack.peek()))
                    {
                        stack.push(c);
                    }
                    else
                    {
                        while (!stack.isEmpty() && isLowerPrecedence(c, stack.peek()))
                        {
                            Character pop = stack.pop();
                            if (c != '(')
                            {
                                postfix.append(pop);
                            } else {
                                c = pop;
                            }
                        }
                        stack.push(c);
                    }

                }
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }


    private float eval(String str, HashMap<Character, Float> map) {

        Stack<Float> stack = new Stack<>();
        for(int i = 0;i <str.length();i++){
            char ch = str.charAt(i);
            if(!isOperator(ch)){
                Log.d(TAG, ch + " " + map.get(ch));
                stack.push(map.get(ch));
            }else{
                float b = stack.pop();
                float a = stack.pop();
                if(ch == '+')
                    stack.push(a+b);
                else if(ch == '-')
                    stack.push(a-b);
                else if(ch == '*')
                    stack.push(a*b);
                else
                    stack.push(a/b);
            }
        }

        float a = stack.pop();
        Log.d(TAG, a + " ");
        return a;
    }

}



