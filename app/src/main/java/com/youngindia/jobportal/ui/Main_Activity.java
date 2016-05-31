package com.youngindia.jobportal.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.youngindia.jobportal.R;

public class Main_Activity extends AppCompatActivity {
Button btn_others,btn_franchiese;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        btn_others=(Button)findViewById(R.id.btn_others);
        btn_franchiese=(Button)findViewById(R.id.btn_franchiese);
        btn_franchiese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Franchise_Activity.class);
                startActivity(intent);
            }
        });
        btn_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),LoginUser_Activity.class);
                startActivity(intent);
            }
        });
    }
}
