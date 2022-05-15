package com.example.memorizationgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Button newAccount = (Button)findViewById(R.id.signup);
        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText) findViewById(R.id.username)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                String re_password = ((EditText) findViewById(R.id.reenterPassword)).getText().toString();
                if("".equals(name)){
                    Toast.makeText(CreateAccountActivity.this, "The username could not be empty", Toast.LENGTH_SHORT).show();
                }else if("".equals(password)){
                    Toast.makeText(CreateAccountActivity.this, "The password could not be empty", Toast.LENGTH_SHORT).show();

                }else if("".equals(re_password)){
                    Toast.makeText(CreateAccountActivity.this, "The re-enter password could not be empty", Toast.LENGTH_SHORT).show();
                }else{
                    if(!password.equals(re_password)){
                        Toast.makeText(CreateAccountActivity.this, "The re-enter password is not correct,please re-enter again", Toast.LENGTH_SHORT).show();
                    }else {
                        //go to a new activity
                        Intent intent = new Intent(CreateAccountActivity.this,AccountActivity.class);
                        UerAccount user = new UerAccount(name,password);
                        intent.putExtra("user",user);
                        /*Bundle bundle = new Bundle();
                        bundle.putString("name",name);
                        bundle.putString("password",password);

                        intent.putExtra("bundle",bundle);*/
                        startActivity(intent);
                    }
                }


            }
        });
        Button cancel = (Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}