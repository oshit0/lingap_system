package com.lingapms.model;

public class Schedule {
    private int id;
    private String day;
    private String time;
    private int slotsRemaining;

    public Schedule(int id){
        this.id = id;
    }

    public Schedule(int id, String day, String time, int slotsRemaining){
        this.id = id;
        this.day = day;
        this.time = time;
        this.slotsRemaining = slotsRemaining;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSlotsRemaining() {
        return slotsRemaining;
    }

    public void setSlotsRemaining(int slotsRemaining) {
        this.slotsRemaining = slotsRemaining;
    }

    @Override
    public String toString() {
        return "Schedule{" +
               "id=" + id +
               ", day='" + day + '\'' +
               ", time='" + time + '\'' +
               ", slotsRemaining=" + slotsRemaining +
               '}';
    }
}
