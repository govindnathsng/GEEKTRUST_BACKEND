package com.geektrust.backend.service.model;

import com.geektrust.backend.comman.constants.Direction;

/**
 * Represents the trajectory of a G-Man character.
 */
public class GManTrajectory {
    private final Coordinate source; // Source coordinate of the trajectory
    private final Coordinate destination; // Destination coordinate of the trajectory
    private final Direction currentDirection; // Current direction of the trajectory
    private final ConsumptionCostModel consumptionCostModel; // Consumption cost model for the trajectory

    /**
     * Constructs a new GManTrajectory with the specified parameters.
     *
     * @param source              the source coordinate of the trajectory
     * @param destination         the destination coordinate of the trajectory
     * @param direction    the current direction of the trajectory
     * @param consumptionCostModel the consumption cost model for the trajectory
     */
    public GManTrajectory(Coordinate source, Coordinate destination, Direction direction, ConsumptionCostModel consumptionCostModel) {
        this.source = source;
        this.destination = destination;
        this.currentDirection = direction;
        this.consumptionCostModel = consumptionCostModel;
    }

    /**
     * Retrieves the source coordinate of the trajectory.
     *
     * @return the source coordinate
     */
    public Coordinate getSource() {
        return source;
    }

    /**
     * Retrieves the destination coordinate of the trajectory.
     *
     * @return the destination coordinate
     */
    public Coordinate getDestination() {
        return destination;
    }

    /**
     * Retrieves the current direction of the trajectory.
     *
     * @return the current direction
     */
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    /**
     * Retrieves the consumption cost model for the trajectory.
     *
     * @return the consumption cost model
     */
    public ConsumptionCostModel getConsumptionCostModel() {
        return consumptionCostModel;
    }
}

