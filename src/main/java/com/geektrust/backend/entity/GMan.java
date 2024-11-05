package com.geektrust.backend.entity;

import com.geektrust.backend.comman.constants.Direction;
import com.geektrust.backend.service.model.Coordinate;

public class GMan {
    private Coordinate sourceCoordinate;
    private Coordinate destinationCoordinate;
    private Direction directionFacing;

    public Coordinate getSourceCoordinate() {
        return sourceCoordinate;
    }

    public void setSourceCoordinate(Coordinate sourceCoordinate) {
        this.sourceCoordinate = sourceCoordinate;
    }

    public Coordinate getDestinationCoordinate() {
        return destinationCoordinate;
    }

    public void setDestinationCoordinate(Coordinate destinationCoordinate) {
        this.destinationCoordinate = destinationCoordinate;
    }

    public Direction getDirectionFacing() {
        return directionFacing;
    }

    public void setDirectionFacing(String directionFacing) {
        try {
            this.directionFacing = Direction.valueOf(directionFacing.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Handle the case where the input direction string is invalid
            System.err.println("Invalid direction: " + directionFacing);
            // Optionally, you can set a default direction or throw an exception
        }
    }
}

