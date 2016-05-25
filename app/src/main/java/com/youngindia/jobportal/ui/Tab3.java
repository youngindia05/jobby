package com.youngindia.jobportal.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.youngindia.jobportal.R;
import com.youngindia.jobportal.adapter.ListAdapter;


public class Tab3 extends Fragment {
    public String[]job_name={"Fundraiser", "Game Industry", "Genealogist", "Government Jobs", "Hair Stylist", "Human Resources"};
    public String[]job_specification={"Android List View", "Adapter implementation", "Simple List View In Android", "Create List View Android","Android Example", "List View Source Code"};
    public String[]job_skills={"Job views","Job Recommended","New Jobs","Latest Jobs","New Jobs","Latest Jobs"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_tab1, container, false);
        ListView listview=(ListView)rootview.findViewById(R.id.listView);
        ListAdapter listAdapter=new ListAdapter(getActivity(),job_name,job_specification,job_skills);
        listview.setAdapter(listAdapter);
        return rootview;
    }

}

