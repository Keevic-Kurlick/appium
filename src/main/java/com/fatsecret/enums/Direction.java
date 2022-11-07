package com.fatsecret.enums;

public enum Direction {
    UP("UP"),
    DOWN("DOWN"),
    LEFT("LEFT"),
    RIGHT("RIGHT");

    private final String dir;

    Direction(final String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }
}
