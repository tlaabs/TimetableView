package com.github.tlaabs.timetableview;

import java.io.Serializable;

public class Time implements Serializable {
    private int hour = 0;
    private int minute = 0;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public Time() { }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
