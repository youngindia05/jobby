package com.youngindia.jobportal.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.youngindia.jobportal.R;

public class Company_Base extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    public static Company_Base instance;
    fragment_companybase fragment_companybase;
    fragment_companypostajob fragmentsetting;
    fragment_companysetting fragment_companysetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company__base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        toolbar.setNavigationIcon(R.drawable.toolbar_backbtn);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragment_companybase = new fragment_companybase();
        fragment_companysetting=new fragment_companysetting();
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        //   sScreen = getResources().getString(R.string.title_wall);
        fragmenttransaction.replace(R.id.frame_container, fragment_companybase);
        fragmenttransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmenttransaction.commit();
    }
    public static Company_Base getInstance() {
        return instance;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //   sScreen = getResources().getString(R.string.title_wall);
            ft.replace(R.id.frame_container, fragment_companybase);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.addToBackStack("tag").commitAllowingStateLoss();//commit();
            // Handle the camera action
        } else if (id == R.id.nav_setting) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //   sScreen = getResources().getString(R.string.title_wall);
            ft.replace(R.id.frame_container, fragment_companysetting);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.addToBackStack("tag").commitAllowingStateLoss();//commit();
        } else if (id == R.id.nav_postajob) {
            Intent intent =new Intent(Company_Base.this,CompanyDetail.class);
            startActivity(intent);
        } else if (id == R.id.nav_shortlisted) {
            Intent intent =new Intent(Company_Base.this,Company_candidatelist.class);
            startActivity(intent);
        }  else if (id == R.id.nav_received) {
            Intent intent =new Intent(Company_Base.this,Company_candidatelist.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_faq) {
            Intent intent =new Intent(Company_Base.this,App_Faq.class);
            startActivity(intent);
        } else if (id == R.id.nav_promote) {

        }else if (id == R.id.logout) {
            Intent intent =new Intent(Company_Base.this,LoginUser_Activity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
