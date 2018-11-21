package com.thirdmadman.EducStaff;

import java.util.List;

public class Section extends BusinessEntity {
    private List<Group> groups = null;

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }


}
