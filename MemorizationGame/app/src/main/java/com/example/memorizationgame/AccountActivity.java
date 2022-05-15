package com.example.memorizationgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        //接收数据
        UerAccount user = (UerAccount) getIntent().getSerializableExtra("user");
        //textview 显示内容
        ((TextView) findViewById(R.id.name)).setText(user.getUserName());
        TextView round = (TextView) findViewById(R.id.round);
        round.setText("" + user.getCompleteRounds());
        TextView rank = (TextView) findViewById(R.id.rank);
        rank.setText(user.getRankHistory());
        Button startGame = (Button)findViewById(R.id.startgame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this, GameActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
    }
}

/*double wD = BMIModel.toDouble(wS);
    double hD = BMIModel.toDouble(hS);
    double bmiD = BMIModel.getBMI(wD,hD);
    String bmiS = BMIModel.formatBMI(bmiD);
        ((TextView) findViewById(R.id.answer)).setText(bmiS);*/