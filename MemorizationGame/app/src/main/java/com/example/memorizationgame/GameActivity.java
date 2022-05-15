package com.example.memorizationgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    Chronometer ch;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //接收user并展示分数
        UerAccount user = (UerAccount) getIntent().getSerializableExtra("user");
        TextView scoreTextview = (TextView) findViewById(R.id.score);
        scoreTextview.setText("Your Current Points: \n" + user.gettotalPoints());

        //展示图形
        Game bronze = new Game();
        int[] answer = bronze.getAnswer();
        ImageView shape1 =  findViewById(R.id.shape1View);
        shape1.setImageResource(bronze.shapes[answer[0]]);
        ImageView shape2 =  findViewById(R.id.shape2View);
        shape2.setImageResource(bronze.shapes[answer[1]]);
        ImageView shape3 =  findViewById(R.id.shape3View);
        shape3.setImageResource(bronze.shapes[answer[2]]);


        //倒计时
        ch = (Chronometer) findViewById(R.id.cutdown);
        ch.setBase(SystemClock.elapsedRealtime() + 5000);
        ch.setCountDown(true);
        ch.setFormat("%s");
        ch.start();
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                ch.setText(ch.getText().toString().substring(1));

                if (SystemClock.elapsedRealtime() - ch.getBase() >= 0){
                    ch.stop();
                    Intent intent = new Intent(GameActivity.this, AnswerActivity.class);
                    //传递数据
                    //intent.putExtra("answer",answer);
                    intent.putExtra("game",bronze);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }
            }
        });
        Button exitButton = (Button)findViewById(R.id.exitbutton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });


    }
}