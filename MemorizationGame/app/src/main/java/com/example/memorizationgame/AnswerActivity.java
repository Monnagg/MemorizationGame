package com.example.memorizationgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AnswerActivity extends AppCompatActivity {
    private Chronometer timingCh;
    int[] selection_key = new int[3];
    int num_selection = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        //设置计时器
        timingCh = (Chronometer) findViewById(R.id.timing);
        timingCh.setBase(SystemClock.elapsedRealtime());
        timingCh.setFormat("%s");
        timingCh.start();



        //接收user并展示分数
        UerAccount user = (UerAccount) getIntent().getSerializableExtra("user");
        TextView scoreTextview = (TextView) findViewById(R.id.score);
        scoreTextview.setText("Your Current Points: \n" + user.gettotalPoints());

        //接收game并接收相应答案
        Game bronze = (Game) getIntent().getSerializableExtra("game");
        int[] shapes = bronze.shapes;


        //选项展示
        Object[] options = bronze.getOptions();
        int num1 = (int) options[0];
        int num2 = (int) options[1];
        int num3 = (int) options[2];
        int num4 = (int) options[3];
        int num5 = (int) options[4];
        int num6 = (int) options[5];
        ImageButton option1 = (ImageButton) findViewById(R.id.img1);
        option1.setImageResource(shapes[num1]);
        ImageButton option2 = (ImageButton) findViewById(R.id.img2);
        option2.setImageResource(shapes[num2]);
        ImageButton option3 = (ImageButton) findViewById(R.id.img3);
        option3.setImageResource(shapes[num3]);
        ImageButton option4 = (ImageButton) findViewById(R.id.img4);
        option4.setImageResource(shapes[num4]);
        ImageButton option5 = (ImageButton) findViewById(R.id.img5);
        option5.setImageResource(shapes[num5]);
        ImageButton option6 = (ImageButton) findViewById(R.id.img6);
        option6.setImageResource(shapes[num6]);


        //选取答案
        ImageView userSelection1 = (ImageView) findViewById(R.id.user_image1);
        ImageView userSelection2 = (ImageView) findViewById(R.id.user_image2);
        ImageView userSelection3 = (ImageView) findViewById(R.id.user_image3);


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 3){
                    selection_key[num_selection] = num1;
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num1]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num1]);
                        num_selection++;
                    }else {
                        userSelection3.setImageResource(shapes[num1]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerActivity.this, "You have already Selected Three shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 3){
                    selection_key[num_selection] = num2;
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num2]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num2]);
                        num_selection++;
                    }else {
                        userSelection3.setImageResource(shapes[num2]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerActivity.this, "You have already Selected Three shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 3){
                    selection_key[num_selection] = num3;
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num3]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num3]);
                        num_selection++;
                    }else {
                        userSelection3.setImageResource(shapes[num3]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerActivity.this, "You have already Selected Three shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 3){
                    selection_key[num_selection] = num4;
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num4]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num4]);
                        num_selection++;
                    }else {
                        userSelection3.setImageResource(shapes[num4]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerActivity.this, "You have already Selected Three shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        option5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 3){
                    selection_key[num_selection] = num5;
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num5]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num5]);
                        num_selection++;
                    }else {
                        userSelection3.setImageResource(shapes[num5]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerActivity.this, "You have already Selected Three shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        option6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_selection < 3){
                    selection_key[num_selection] = num6;
                    if(num_selection == 0){
                        userSelection1.setImageResource(shapes[num6]);
                        num_selection++;
                    }else if(num_selection == 1){
                        userSelection2.setImageResource(shapes[num6]);
                        num_selection++;
                    }else {
                        userSelection3.setImageResource(shapes[num6]);
                        num_selection++;
                    }
                }else {
                    Toast.makeText(AnswerActivity.this, "You have already Selected Three shapes!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //清除所有选择
        Button clearButton = (Button)findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSelection1.setImageResource(R.drawable.empty);
                userSelection2.setImageResource(R.drawable.empty);
                userSelection3.setImageResource(R.drawable.empty);
                num_selection = 0;
            }
        });


        //选择完毕设置button
        Button doneButton = (Button)findViewById(R.id.done);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnswerActivity.this, ResultActivity.class);
                intent.putExtra("selection",selection_key);
                intent.putExtra("user",user);
                intent.putExtra("game",bronze);
                long time = SystemClock.elapsedRealtime();
                timingCh.stop();
                startActivity(intent);
            }
        });

    }


}