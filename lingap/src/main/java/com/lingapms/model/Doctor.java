package com.lingapms.model;

public class Doctor {
    private int id;
    private String name;
    private String field;
    private Schedule availableSchedule;

    public Doctor(int id, String name, String field, Schedule availableSchedule) {
        this.id = id;
        this.name = name;
        this.field = field;
        this.availableSchedule = availableSchedule;
    }

    public Doctor(String name, String field, Schedule availableSchedule) {
        this.name = name;
        this.field = field;
        this.availableSchedule = availableSchedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Schedule getSchedule(){
        return availableSchedule;
    }

    public void setSchedule(Schedule schedule){
        this.availableSchedule = schedule;
    }

    @Override
    public String toString() {
        return "Doctor{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", field='" + field + '\'' +
               '}';
    }
}
