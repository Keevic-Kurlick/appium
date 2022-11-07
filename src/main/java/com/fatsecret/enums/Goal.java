package com.fatsecret.enums;

public enum Goal {
    WEIGHT_LOSS("Weight loss"),
    WEIGHT_GAIN("Weight gain"),
    MAINTAIN("Maintain");
    private final String goal;
    Goal(final String goal) {
        this.goal = goal;
    }

    public String getGoal() {
        return goal;
    }
}
