package com.veryworks.android.basiclayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity implements View.OnClickListener{

    private TextView textPreview;
    private TextView textResult;
    private LinearLayout layout1;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnPlus;
    private LinearLayout layout2;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btnMinus;
    private LinearLayout layout3;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btnMultiply;
    private LinearLayout layout4;
    private Button btnC;
    private Button btn0;
    private Button btnResult;
    private Button btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initView();
        initListener();
    }

    private void initView() {
        textPreview = (TextView) findViewById(R.id.textPreview);
        textResult = (TextView) findViewById(R.id.textResult);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btnPlus = (Button) findViewById(R.id.btn_plus);
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btnMinus = (Button) findViewById(R.id.btn_minus);
        layout3 = (LinearLayout) findViewById(R.id.layout3);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btnMultiply = (Button) findViewById(R.id.btn_multiply);
        layout4 = (LinearLayout) findViewById(R.id.layout4);
        btnC = (Button) findViewById(R.id.btn_c);
        btn0 = (Button) findViewById(R.id.btn_0);
        btnResult = (Button) findViewById(R.id.btn_result);
        btnDivide = (Button) findViewById(R.id.btn_divide);
    }

    private void initListener(){
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_0: append("0"); break;
            case R.id.btn_1: append("1"); break;
            case R.id.btn_2: append("2"); break;
            case R.id.btn_3: append("3"); break;
            case R.id.btn_4: append("4"); break;
            case R.id.btn_5: append("5"); break;
            case R.id.btn_6: append("6"); break;
            case R.id.btn_7: append("7"); break;
            case R.id.btn_8: append("8"); break;
            case R.id.btn_9: append("9"); break;
            case R.id.btn_plus: append("+"); break;
            case R.id.btn_minus: append("-"); break;
            case R.id.btn_multiply: append("*"); break;
            case R.id.btn_divide: append("/"); break;
            case R.id.btn_c:
                textPreview.setText("0");
                textResult.setText("0");
                break;
            case R.id.btn_result:
                // double result = calc();
                // textResult.setText(""+result);
                break;
        }
    }

    private double calc1(){

        // 34 + 15 * 3 - 5 / 13

        // 1. 우선순위 없을경우

        // 2. 연산자 우선순위 있을경우

        // 가. 입력받을 때 단위별로 공백을 추가해서 받는다
        String target = "34 + 15 * - 5 / 3";
        ArrayList<String> subTarget = new ArrayList<>();
        // 나. 공백을 기준으로 split하면 연산자와 숫자가 구분된다.
        String calculTarget[] = target.split(" ");

        double front, back, subResult, result;
        // 다. 반복문에서 연산자를 기준로 * 와 /를 먼저 연산해서 결과값을 담아둔다.
        // 34 + 15 * 3 - 5 / 10
        // 34 + 45 - 0.5
        for(int i=0 ; i<calculTarget.length ; i++){
            if(calculTarget[i].equals("*") || calculTarget.equals("/")) {
                front = Double.parseDouble(subTarget.get(subTarget.size() - 1));
                back = Double.parseDouble(calculTarget[i + 1]);
                if(calculTarget[i].equals("*")){
                    subResult = front * back;
                }else{
                    subResult = front / back;
                }
                subTarget.remove(subTarget.size()-1);
                subTarget.add(subResult+"");
            }else{
                subTarget.add(calculTarget[i]);
            }
        }

        // 라. 다시 반복을 돌면서 + 와 - 연산을 해준다.
        // 34 + 45 - 0.5
        result = Double.parseDouble(subTarget.get(0));
        for(int k=0 ; k<subTarget.size()-1; k++){
            switch(subTarget.get(k)){
                case "+":
                    result += Double.parseDouble(subTarget.get(k+1));
                    break;
                case "-":
                    result -= Double.parseDouble(subTarget.get(k+1));
            }
        }
        return result;
    }

    private void calc2(){
        // 1. 저장소를 두개로 분리해서 선언
        ArrayList<Integer> numberArray = new ArrayList<>();
        ArrayList<Integer> otherArray = new ArrayList<>();

        // 2. 숫자가 입력되면 텍스트뷰에 숫자를 입력
        textPreview.append("숫자값");

        // 3. 연산기호가 입력되면 이전에 입력됬던 숫자값을 numberArray에 입력
        //    연산기호 버튼의 실제아이디를 otherArray에 입력

        // 4. 연산기호를 입력했을 때만 배열에 숫자가 입력되므로
        //    마지막 숫자에 대한 처리가 필요

        // 5. 그리고 반복문으로 연산 우선순위에 따라 처리한다.
    }

    private void calc3(){
        String inputText      = "34+15*3-5/10";
        String splittedText[] = inputText.split("(?<=[*/+-])|(?=[*/+-])");

        String temp[] = { "34", "+", "15", "*", "3", "-", "5", "-", "10"};
        ArrayList<String> result =  new ArrayList<>();
        for(String item : temp){
            if(item.equals("*") | item.equals("/")){
                // 결과값을 result에 add 한다...
            }
        }

        for(String item : result){
            if(item.equals("+") | item.equals("-")){
                // 결과값을 result에 add 한다...
            }
        }
    }

    private void append(String str){
        if(textPreview.getText().toString().equals("0")){
            // 1. 처음에 연산자가 오면 예외처리
            if(str.equals("+") || str.equals("-")
                    || str.equals("*") || str.equals("/")){
                Toast.makeText(this
                        , "연산자를 먼저 입력할 수 없습니다!"
                        , Toast.LENGTH_SHORT).show();
                return;
            // 2. 연산자를 연속해서 입력하면 예외처리
            }else {
                textPreview.setText("");
            }
        }
        textPreview.append(str);
    }
}
