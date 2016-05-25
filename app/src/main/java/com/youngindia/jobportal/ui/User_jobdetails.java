package com.youngindia.jobportal.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.youngindia.jobportal.R;
import com.youngindia.jobportal.adapter.PageAdapter;

public class User_jobdetails extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PageAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_jobdetails);////
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       toolbar.setTitle("Job Details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.btn_textColor));
        toolbar.setNavigationIcon(R.drawable.toolbar_backbtn);
        setSupportActionBar(toolbar);

//            setSupportActionBar(toolbar);
//            ActionBar actionBar = getSupportActionBar();
//           // actionBar.setTitle("Job Portal");
//            actionBar.setDisplayHomeAsUpEnabled(true);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            tabLayout.addTab(tabLayout.newTab().setText("New Jobs"));
            tabLayout.addTab(tabLayout.newTab().setText("Recommended Jobs"));
            tabLayout.addTab(tabLayout.newTab().setText("Latest Jobs"));

            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

            final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
            final PageAdapter adapter = new PageAdapter
                    (getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.action_settings)
            {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }

