package com.example.edouble.planapplication.db;

import org.litepal.crud.LitePalSupport;

public class Event extends LitePalSupport {
    private long id;
    private String eventname;//事件名字
    private int eventyear;//事件年月日
    private int eventmonth;
    private int eventday;
    private String eventnote;//事件备注
    private int eventcolor;//事件颜色（及重要程度）


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public int getEventyear() {
        return eventyear;
    }

    public void setEventyear(int eventyear) {
        this.eventyear = eventyear;
    }

    public int getEventmonth() {
        return eventmonth;
    }

    public void setEventmonth(int eventmonth) {
        this.eventmonth = eventmonth;
    }

    public int getEventday() {
        return eventday;
    }

    public void setEventday(int eventday) {
        this.eventday = eventday;
    }

    public String getEventnote() {
        return eventnote;
    }

    public void setEventnote(String eventnote) {
        this.eventnote = eventnote;
    }

    public int getEventcolor() {
        return eventcolor;
    }

    public void setEventcolor(int eventcolor) {
        this.eventcolor = eventcolor;
    }
}
