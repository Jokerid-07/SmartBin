package com.example.smartbin;

public class ListData {
    private String ID;
    private String Date;
    private String Time;
    private String Level;

    public  ListData(){
    }

    public ListData(String ID, String Date, String Time, String Level) {
        this.ID = ID;
        this.Date = Date;
        this.Time = Time;
        this.Level = Level;
    }

    public String getId() {
        return ID;
    }

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }

    public String getLevel() {
        return Level;
    }
}
