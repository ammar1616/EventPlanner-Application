package com.example.final_project;

public class Events {
    String Name;
    String Description;
    int day, month, year;

    public Events() {
    }

    public Events(String name, String description, int d, int m, int y) {
        this.Name = name;
        this.Description = description;
        this.day = d;
        this.month = m;
        this.year = y;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String fulldate() {
        String dt = Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
        return dt;
    }
}
