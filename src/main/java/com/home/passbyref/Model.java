package com.home.passbyref;

import java.util.Date;
import java.util.List;

public class Model {

    private Date date;

    private String name;

    private Integer schNo;

    private List<String> subjects;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSchNo() {
        return schNo;
    }

    public void setSchNo(Integer schNo) {
        this.schNo = schNo;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Model [date=" + date + ", name=" + name + ", schNo=" + schNo + ", subjects=" + subjects + "]";
    }

}
