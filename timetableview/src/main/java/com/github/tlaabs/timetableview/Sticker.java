package com.github.tlaabs.timetableview;

import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Sticker implements Serializable {
    private ArrayList<TextView> view;
    private ArrayList<Schedule> schedules;

    public Sticker() {
        this.view = new ArrayList<TextView>();
        this.schedules = new ArrayList<Schedule>();
    }

    public void addTextView(TextView v){
        view.add(v);
    }

    public void addSchedule(Schedule schedule){
        schedules.add(schedule);
    }

    public ArrayList<TextView> getView() {
        return view;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }
}
