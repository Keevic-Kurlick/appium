package com.fatsecret.enums;

public enum Activity {
    LOW_ACTIVITY("Low"),
    VERY_ACTIVE("High"),
    SEDENTARY("Sedentary"),
    ACTIVE("Active");

    private final String activity;

    Activity(final String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return this.activity;
    }
}
