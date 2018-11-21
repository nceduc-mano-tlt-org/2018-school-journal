package com.thirdmadman.EducStaff;

abstract class AbstractEntity {
    private String id = null;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
