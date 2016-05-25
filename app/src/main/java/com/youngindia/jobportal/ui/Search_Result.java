package com.youngindia.jobportal.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.youngindia.jobportal.R;
import com.youngindia.jobportal.adapter.ListAdapter;
import com.youngindia.jobportal.adapter.Model_Search;

import java.util.ArrayList;
import java.util.List;

public class Search_Result extends AppCompatActivity {
    Search_Activity search_activity;
    private List<Model_Search> searchlist = new ArrayList<Model_Search>();
    public String[]job_name={"Android Developer", "Senior Android Developer", "Mobile Android Developer"};
    public String[]job_specification={"Young India,Bangalore", "Talpro,Bangalore", "ABC,Bangalore"};
    public String[]job_skills={"android,core java","xml,android","json,android,xml"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView search_list=(ListView)findViewById(R.id.listView2);
        ListAdapter listadapter=new ListAdapter(this,job_name,job_specification,job_skills);
        search_list.setAdapter(listadapter);
    }

}
