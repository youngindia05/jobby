package com.youngindia.jobportal.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.youngindia.jobportal.R;

import info.hoang8f.android.segmented.SegmentedGroup;

public class DailyWagesRegstr extends AppCompatActivity implements frgment_dailywages_register.OnFragmentInteractionListener{

    frgment_dailywages_register dailywages_register;
    frgmentd_dailywages_search dailywages_search;

    SegmentedGroup segmented2;
    RadioButton radiobtn_register,radiobtn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_wages_regstr);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle("Daily Wager");
        toolbar.setNavigationIcon(R.drawable.toolbar_backbtn);
        setSupportActionBar(toolbar);

        radiobtn_register= (RadioButton) findViewById(R.id.radiobutn_register);
        radiobtn_search= (RadioButton) findViewById(R.id.radiobutn_search);

        segmented2 = (SegmentedGroup)findViewById(R.id.segmented2);

        dailywages_register = new frgment_dailywages_register();
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        //   sScreen = getResources().getString(R.string.title_wall);
        fragmenttransaction.replace(R.id.frame_container, dailywages_register);
        fragmenttransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmenttransaction.commit();

        segmented2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if (checkedId == R.id.radiobutn_register) {
                    dailywages_register = new frgment_dailywages_register();
                    FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    //   sScreen = getResources().getString(R.string.title_wall);
                    fragmenttransaction.replace(R.id.frame_container, dailywages_register);
                    fragmenttransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    fragmenttransaction.commit();

                }if (checkedId == R.id.radiobutn_search)  {
                    dailywages_search = new frgmentd_dailywages_search();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    //   sScreen = getResources().getString(R.string.title_wall);
                    fragmentTransaction.replace(R.id.frame_container, dailywages_search);
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    fragmentTransaction.commit();
                }

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
