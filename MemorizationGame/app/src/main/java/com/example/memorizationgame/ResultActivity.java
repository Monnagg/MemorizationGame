package com.example.memorizationgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //接收数据
        UerAccount user = (UerAccount) getIntent().getSerializableExtra("user");
        Game bronze = (Game) getIntent().getSerializableExtra("game");
        int[] selection_key = getIntent().getIntArrayExtra("selection");
        int[] answer = bronze.answer;

        //展示争取选项
        ImageView shape1 =  findViewById(R.id.answer1);
        shape1.setImageResource(bronze.shapes[answer[0]]);
        ImageView shape2 =  findViewById(R.id.answer2);
        shape2.setImageResource(bronze.shapes[answer[1]]);
        ImageView shape3 =  findViewById(R.id.answer3);
        shape3.setImageResource(bronze.shapes[answer[2]]);

        //展示结果
        TextView performance = (TextView) findViewById(R.id.pointsGain);
        int points_thisRound = 0;
        int num_right = 0;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < selection_key.length; j++) {
                if(answer[i] == selection_key[j]){
                    num_right++;
                }
            }
        }
        if(num_right == 1){
            points_thisRound = 20;
            performance.setText("NOT BAD\n GAIN 20 POINTS");
        }else if(num_right == 2){
            points_thisRound = 60;
            performance.setText("GOOD PERFORMANCE\n GAIN 60 POINTS");
        }else if(num_right == 3){
            points_thisRound = 100;
            performance.setText("EXCELLENT PERFORMANCE\n GAIN 100 POINTS");
        }else {
            performance.setText("BAD PERFORMANCE\nGAIN 0 POINT");
        }
        //更新分数
        user.updatePoints(points_thisRound);

        //结束设置button
        Button exitButton = (Button)findViewById(R.id.exitbutton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, AccountActivity.class);
                intent.putExtra("user",user);
                //intent.putExtra("game",bronze);
                startActivity(intent);
            }
        });
        Button nextRound = (Button)findViewById(R.id.nextRound);
        nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, GameActivity.class);
                intent.putExtra("user",user);
                //intent.putExtra("game",bronze);
                startActivity(intent);
            }
        });

    }
}