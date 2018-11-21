package com.thirdmadman.EducStaff;

import java.util.Date;

public class Main {
    public static void main (String args[]) {
        Project gg = new Project();
        gg.setCreatedDate(new Date());
        AbstractEntity ggwp = gg;
        ggwp.setId("fff");
    }
}
