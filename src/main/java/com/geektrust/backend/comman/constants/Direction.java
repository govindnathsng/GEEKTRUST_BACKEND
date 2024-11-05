package com.geektrust.backend.comman.constants;

public enum Direction {
    N("N"),
    S("S"),
    E("E"),
    W("W");

    private final String label;

    Direction(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    // public boolean equalsIgnoreCase(String skipTurnDirection) {
    //     return false;
    // }
}
