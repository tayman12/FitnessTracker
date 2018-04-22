package org.learning.spring.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class Exercise {

    @Range(min = 1, max = 120)
    private int minutes;

    @NotNull
    private String activity;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
