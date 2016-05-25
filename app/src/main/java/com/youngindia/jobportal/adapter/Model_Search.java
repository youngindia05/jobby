package com.youngindia.jobportal.adapter;

import java.util.ArrayList;

/**
 * Created by anupam on 20-05-2016.
 */
public class Model_Search {
    private String Jobname, Qualification,Location;

    public Model_Search(String jobname, String qualification, String location) {
        this.Jobname = jobname;
        this.Qualification = qualification;
        this.Location = location;
    }

    public String getJobname() {
        return Jobname;
    }

    public void setJobname(String jobname) {
        Jobname = jobname;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
