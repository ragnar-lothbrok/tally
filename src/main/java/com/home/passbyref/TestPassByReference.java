package com.home.passbyref;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestPassByReference {

    public static void main(String[] args) {

        List<String> tempList = new ArrayList<String>();
        tempList.add("Maths");
        tempList.add("Biology");

        Model model = new Model();
        model.setSchNo(1234);
        model.setSubjects(tempList);
        model.setDate(new Date());
        model.setName("Raja");

        System.out.println(model);

        firstChangeDate(model.getDate());

        System.out.println(model);

        secondChangeDate(model.getDate());

        System.out.println(model);

        firstChangeList(model.getSubjects());

        System.out.println(model);

        secondChangeList(model.getSubjects());

        System.out.println(model);

        tempList.add("test again");

        System.out.println(model);

    }

    public static void firstChangeDate(Date date) {
        date = new Date();
    }

    @SuppressWarnings("static-access")
    public static void secondChangeDate(Date date) {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        date.setTime(Calendar.getInstance().getTimeInMillis());
    }

    public static void firstChangeList(List<String> list) {
        list = new ArrayList<String>();
        list.add("First test");
    }

    public static void secondChangeList(List<String> list) {
        list.add("Second Added.");
    }

}
