package com.youngindia.jobportal.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.youngindia.jobportal.R;
import com.youngindia.jobportal.fonts.Roboto_Regular_Button;

public class Details_Page extends AppCompatActivity {

    Roboto_Regular_Button apply_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        apply_btn= (Roboto_Regular_Button) findViewById(R.id.btn_apply);
        setSupportActionBar(toolbar);

        apply_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(
                        Details_Page.this).create();
                alertDialog.setTitle("Job Post");

                alertDialog.setMessage("Your job is sucessfully applied");
                alertDialog.show();


            }
        });


        }
    }

