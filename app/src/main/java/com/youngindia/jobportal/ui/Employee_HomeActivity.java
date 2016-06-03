package com.youngindia.jobportal.ui;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.youngindia.jobportal.R;

public class Employee_HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Integer[] mThumbIds = {
            R.drawable.job_status, R.drawable.job_recommended,
            R.drawable.job_update, R.drawable.job_find,
    };
    ProgressBar pb;
    TextView tv;
    int prg = 0;
    public String[]jobtype={"Job Search","Job Recommended","New Jobs","Latest Jobs"};
    fragment_base fragment_detail;
    fragment_profile fragment_profile;
    fragment_faq fragment_faq;
    fragment_newjob fragment_newjob;
    fragment_inbox fragment_inbox;
    fragment_recommendedjob fragment_recommendedjob;
    frgmnt_setting frgmnt_setting;
    public static Employee_HomeActivity instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee__home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        toolbar.setNavigationIcon(R.drawable.toolbar_backbtn);
        setSupportActionBar(toolbar);
        fragment_detail =new fragment_base();
        fragment_profile=new fragment_profile();
        fragment_faq=new fragment_faq();
        fragment_newjob=new fragment_newjob();
        fragment_inbox=new fragment_inbox();
        frgmnt_setting=new frgmnt_setting();
        fragment_recommendedjob=new fragment_recommendedjob();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragment_detail = new fragment_base();
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        //   sScreen = getResources().getString(R.string.title_wall);
        fragmenttransaction.replace(R.id.frame_container, fragment_detail);
        fragmenttransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmenttransaction.commit();


    }
    public static Employee_HomeActivity getInstance() {
        return instance;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.employee__home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                //   sScreen = getResources().getString(R.string.title_wall);
                ft.replace(R.id.frame_container, fragment_detail);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack("tag").commitAllowingStateLoss();//commit();
            // Handle the camera action
        } else if (id == R.id.nav_setting) {
            FragmentTransaction ft1= getSupportFragmentManager().beginTransaction();
            //   sScreen = getResources().getString(R.string.title_wall);
            ft1.replace(R.id.frame_container, frgmnt_setting);
            ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft1.addToBackStack("tag").commitAllowingStateLoss();//commit();

        } else if (id == R.id.nav_newjob) {
            Intent intent =new Intent(Employee_HomeActivity.this,User_jobdetails.class);
            startActivity(intent);
        } else if (id == R.id.nav_recommendedjob) {
            Intent intent =new Intent(Employee_HomeActivity.this,User_jobdetails.class);
            startActivity(intent);
        } else if (id == R.id.nav_faq) {
            Intent intent =new Intent(Employee_HomeActivity.this,App_Faq.class);
            startActivity(intent);
        } else if (id == R.id.nav_promote) {

        }else if (id == R.id.logout) {
            Intent intent =new Intent(Employee_HomeActivity.this,LoginUser_Activity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
