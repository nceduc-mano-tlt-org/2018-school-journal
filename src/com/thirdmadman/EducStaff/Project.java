package com.thirdmadman.EducStaff;

import java.util.Date;
import java.util.List;

public class Project implements AbstractEntity {

    private Date createdDate = null;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    private interface BusinessEntity extends AbstractEntity{

        Project project = null;

    }

    private interface Person extends AbstractEntity {
        String firstname = null;
        String lastName = null;
    }

    private class Student implements Person {

    }

    private class Teacher implements Person {

    }

    private class Section implements AbstractEntity {
        public List<Group> groups;
    }

    private class Group implements AbstractEntity {
        public Section section;
    }

}


