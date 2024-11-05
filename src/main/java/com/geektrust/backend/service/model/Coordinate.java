package com.geektrust.backend.service.model;


public class Coordinate {
    private final int x; // x-coordinate
    private final int y; // y-coordinate

   
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

  
    public int getX() {
        return x;
    }

  
    public int getY() {
        return y;
    }
}

