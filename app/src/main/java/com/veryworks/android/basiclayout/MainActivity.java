package com.veryworks.android.basiclayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

// 안드로이드 화면 구조         Fragment(화면조각)
// App(어플) > Activity(화면한개단위) >  Layout(뷰그룹:컨테이너) >  Widget(뷰)

public class MainActivity extends AppCompatActivity {

    // 1. 레이아웃에 정의된 위젯의 아이디로 변수를 선언
    Button btnFrame, btnLinear, btnGrid, btnRelative, btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 선언된 변수에 실제 위젯을 할당
        btnFrame = (Button) findViewById(R.id.btnFrame);
        btnLinear = (Button) findViewById(R.id.btnLinear);
        btnGrid = (Button) findViewById(R.id.btnGrid);
        btnRelative = (Button) findViewById(R.id.btnRelative);
        btnCalc = (Button) findViewById(R.id.btnCalc);

        // 3. 위에서 저장한 변수를 사용
        // 아래에 선언한 실행객체를 리스너에 던져준다.
        btnFrame.setOnClickListener(onClickListener);
        btnLinear.setOnClickListener(onClickListener);
        btnGrid.setOnClickListener(onClickListener);
        btnRelative.setOnClickListener(onClickListener);
        btnCalc.setOnClickListener(onClickListener);
    }
    // 리스너를 전역 변수로 선언할 수 있다
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // 액티비티(메이저 컴포넌트) 실행
            // 1. 인텐트 (시스템에 전달되는 메시지객체) 생성
            Intent intent = null;
            switch(v.getId()) {
                case R.id.btnFrame:
                    intent = new Intent(MainActivity.this, FrameActivity.class);
                    //                     컨텍스트       ,      타겟
                    break;
                case R.id.btnLinear:
                    intent = new Intent(MainActivity.this, LinearActivity.class);
                    break;
                case R.id.btnGrid:
                    intent = new Intent(MainActivity.this, GridActivity.class);
                    break;
                case R.id.btnRelative:
                    intent = new Intent(MainActivity.this, RelativeActivity.class);
                    break;
                case R.id.btnCalc:
                    intent = new Intent(MainActivity.this, Calculator.class);
            }
            // 2. 액티비티 실행요청
            startActivity(intent);
        }
    };
}
