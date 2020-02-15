package com.khaled.weeksschedule.data.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "week")
public class WeekDay {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "week_day")
    private int weekDay;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "start_time")
    private String startTime;

    @ColumnInfo(name = "end_time")
    private String endTime;

    @ColumnInfo(name = "teacher")
    private String teacher;

    @ColumnInfo(name = "place")
    private String place;

    @ColumnInfo(name = "description")
    private String description;


    public WeekDay(int weekDay, String name, String startTime, String endTime, String teacher, String place, String description) {
        this.weekDay = weekDay;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher = teacher;
        this.place = place;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public String getName() {
        return name;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }
}
