package com.veryworks.android.basiclayout;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity implements View.OnClickListener {


    private ConstraintLayout stage;
    private TextView textView3;
    private TextView textPreview;
    private TextView textResult;
    private LinearLayout layout5;
    private Button btnC;
    private Button btnOpen;
    private Button btnClose;
    private Button btnPlus;
    private LinearLayout layout1;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnMinus;
    private LinearLayout layout2;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btnMultiply;
    private LinearLayout layout3;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btnDivide;
    private LinearLayout layout4;
    private Button btn0;
    private Button btnComma;
    private Button btnResult;
    private Space goalLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initView();
        initListener();

    }

    private void initView() {
        stage = (ConstraintLayout) findViewById(R.id.stage);
        textView3 = (TextView) findViewById(R.id.textView3);
        textPreview = (TextView) findViewById(R.id.textPreview);
        textResult = (TextView) findViewById(R.id.textResult);
        layout5 = (LinearLayout) findViewById(R.id.layout5);
        btnC = (Button) findViewById(R.id.btn_c);
        btnOpen = (Button) findViewById(R.id.btn_open);
        btnClose = (Button) findViewById(R.id.btn_close);
        btnPlus = (Button) findViewById(R.id.btn_plus);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btnMinus = (Button) findViewById(R.id.btn_minus);
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btnMultiply = (Button) findViewById(R.id.btn_multiply);
        layout3 = (LinearLayout) findViewById(R.id.layout3);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btnDivide = (Button) findViewById(R.id.btn_divide);
        layout4 = (LinearLayout) findViewById(R.id.layout4);
        btn0 = (Button) findViewById(R.id.btn_0);
        btnComma = (Button) findViewById(R.id.btn_comma);
        btnResult = (Button) findViewById(R.id.btn_result);
        goalLocation = (Space) findViewById(R.id.goalLocation);
    }


    private void initListener() {
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btn0.setOnClickListener(this);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

        btnComma.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnOpen.setOnClickListener(this);
        btnClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                btnProcess(v, "0");
                break;
            case R.id.btn_1:
                btnProcess(v, "1");
                break;
            case R.id.btn_2:
                btnProcess(v, "2");
                break;
            case R.id.btn_3:
                btnProcess(v, "3");
                break;
            case R.id.btn_4:
                btnProcess(v, "4");
                break;
            case R.id.btn_5:
                btnProcess(v, "5");
                break;
            case R.id.btn_6:
                btnProcess(v, "6");
                break;
            case R.id.btn_7:
                btnProcess(v, "7");
                break;
            case R.id.btn_8:
                btnProcess(v, "8");
                break;
            case R.id.btn_9:
                btnProcess(v, "9");
                break;
            case R.id.btn_comma:
                btnProcess(v, ".");
                break;
            case R.id.btn_plus:
                btnProcess(v, "+");
                break;
            case R.id.btn_minus:
                btnProcess(v, "-");
                break;
            case R.id.btn_multiply:
                btnProcess(v, "*");
                break;
            case R.id.btn_divide:
                btnProcess(v, "/");
                break;
            case R.id.btn_open:
                btnProcess(v, "(");
                break;
            case R.id.btn_close:
                btnProcess(v, ")");
                break;
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

    private double calc1() {

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
        for (int i = 0; i < calculTarget.length; i++) {
            if (calculTarget[i].equals("*") || calculTarget.equals("/")) {
                front = Double.parseDouble(subTarget.get(subTarget.size() - 1));
                back = Double.parseDouble(calculTarget[i + 1]);
                if (calculTarget[i].equals("*")) {
                    subResult = front * back;
                } else {
                    subResult = front / back;
                }
                subTarget.remove(subTarget.size() - 1);
                subTarget.add(subResult + "");
            } else {
                subTarget.add(calculTarget[i]);
            }
        }

        // 라. 다시 반복을 돌면서 + 와 - 연산을 해준다.
        // 34 + 45 - 0.5
        result = Double.parseDouble(subTarget.get(0));
        for (int k = 0; k < subTarget.size() - 1; k++) {
            switch (subTarget.get(k)) {
                case "+":
                    result += Double.parseDouble(subTarget.get(k + 1));
                    break;
                case "-":
                    result -= Double.parseDouble(subTarget.get(k + 1));
            }
        }
        return result;
    }

    private void calc2() {
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

    private void calc3() {
        String inputText = "34+15*3-5/10";
        String splittedText[] = inputText.split("(?<=[*/+-])|(?=[*/+-])");

        String temp[] = {"34", "+", "15", "*", "3", "-", "5", "-", "10"};
        ArrayList<String> result = new ArrayList<>();
        for (String item : temp) {
            if (item.equals("*") | item.equals("/")) {
                // 결과값을 result에 add 한다...
            }
        }

        for (String item : result) {
            if (item.equals("+") | item.equals("-")) {
                // 결과값을 result에 add 한다...
            }
        }
    }

    private void btnProcess(View view, String str) {
        if (textPreview.getText().toString().equals("0")) {
            // 1. 처음에 연산자가 오면 예외처리
            if (str.equals("+") || str.equals("-")
                    || str.equals("*") || str.equals("/")) {
                Toast.makeText(this
                        , "연산자를 먼저 입력할 수 없습니다!"
                        , Toast.LENGTH_SHORT).show();
                return;
                // 2. 연산자를 연속해서 입력하면 예외처리
            } else {
                textPreview.setText("");
            }
        }
        appendTextWithAni(view, str);
    }

    private void appendTextWithAni(View view, String str) {
        move(view);
        textPreview.append(str);
    }

    private void move(final View target) {
        Button org = (Button) target;
        // 날아갈 더미 만들기
        final Button dummy = new Button(this);
        dummy.setText(org.getText().toString());
        dummy.setBackground(org.getBackground());
        dummy.setWidth(org.getWidth());
        dummy.setHeight(org.getHeight());
        // 부모 레이아웃 위치 + 현재 나의 위치 계산
        LinearLayout parent = (LinearLayout) target.getParent();
        float orgX = parent.getX() + target.getX();
        float orgY = parent.getY() + target.getY();
        // 더미를 삽입하고 초기 위치를 설정해준다.
        stage.addView(dummy);
        dummy.setX(orgX);
        dummy.setY(orgY);

        layout1.addView(dummy);
        // 애니메이션 셋 만들기
        ObjectAnimator aniY = ObjectAnimator.ofFloat(
                dummy, "y", goalLocation.getY() // 미리 삽입해둔 타겟의 현재위치
        );
        ObjectAnimator anyRotate = ObjectAnimator.ofFloat(
                dummy, "rotation", 720
        );
        ObjectAnimator aniX = ObjectAnimator.ofFloat(
                dummy, "x", goalLocation.getX()
        );
        AnimatorSet aniSet = new AnimatorSet();
        aniSet.playTogether(aniY, aniX, anyRotate);
        aniSet.setDuration(500);
        aniSet.setInterpolator(new AccelerateDecelerateInterpolator());
        // 리스너를 등록해서 애니메이션 종료를 체크 한다
        aniSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }
            @Override
            public void onAnimationEnd(Animator animation) {
                // 더미를 제거한다
                stage.removeView(dummy);
            }
            @Override
            public void onAnimationCancel(Animator animation) {

            }
            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        aniSet.start();
    }


}
