package com.youngindia.jobportal.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.youngindia.jobportal.R;
import com.youngindia.jobportal.adapter.ListAdapter;

public class Franchise_Activity extends AppCompatActivity {
ListView listView;
    public String[]job_name={"Fundraiser", "Game Industry", "Genealogist", "Government Jobs", "Hair Stylist", "Human Resources"};
    public String[]job_specification={"Android List View", "Adapter implementation", "Simple List View In Android", "Create List View Android","Android Example", "List View Source Code"};
    public String[]job_skills={"Job views","Job Recommended","New Jobs","Latest Jobs","New Jobs","Latest Jobs"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_franchise_);
        listView=(ListView)findViewById(R.id.listview_idslist);
        ListAdapter listAdapter=new ListAdapter(getApplicationContext(),job_name,job_specification,job_skills);
        listView.setAdapter(listAdapter);
    }
}
