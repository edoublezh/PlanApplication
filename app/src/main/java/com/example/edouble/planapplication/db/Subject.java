package com.example.edouble.planapplication.db;

import android.provider.ContactsContract;

import org.litepal.crud.LitePalSupport;

public class Subject extends LitePalSupport {
    private int[] subweek;//科目周集合
    private int[] subday;//科目一周周几
    private int[] subnum;//科目节
    private String subname;//科目名字
    private String subplace;//科目上课地点

    public int[] getSubweek() {
        return subweek;
    }

    public void setSubweek(int[] subweek) {
        this.subweek = subweek;
    }

    public int[] getSubday() {
        return subday;
    }

    public void setSubday(int[] subday) {
        this.subday = subday;
    }

    public int[] getSubnum() {
        return subnum;
    }

    public void setSubnum(int[] subnum) {
        this.subnum = subnum;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getSubplace() {
        return subplace;
    }

    public void setSubplace(String subplace) {
        this.subplace = subplace;
    }
}
