package com.example.kenvin.countdowntimerbtndemo;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer(30);
            }
        });


        SpannableString spannableString = new SpannableString("设置文字的前景色为淡蓝色");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spannableString.setSpan(colorSpan, 9, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);

    }

    private  void startTimer(int time) {

        timer = new CountDownTimer(time*1000,1000){

            @Override
            public void onTick(long l) {
                button.setEnabled(false);
                String str = Integer.toString((int)l/1000);
                SpannableString spannableString = new SpannableString("倒计时"+(int)l/1000+"秒");
                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
                spannableString.setSpan(colorSpan, 2, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                button.setText(spannableString);
            }

            @Override
            public void onFinish() {
                button.setEnabled(true);
                button.setText("发送验证码");
            }
        };
        timer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (timer!=null){
            timer.cancel();
        }
    }
}
