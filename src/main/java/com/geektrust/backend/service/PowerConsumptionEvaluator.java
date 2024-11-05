package com.geektrust.backend.service;

import com.geektrust.backend.comman.constants.Direction;
import com.geektrust.backend.comman.constants.PowerStringConstants;
import com.geektrust.backend.service.model.Coordinate;
import com.geektrust.backend.service.model.GManTrajectory;

/**
 * Implementation of ConsumptionEvaluator that evaluates power consumption based on the G-Man trajectory.
 */
public class PowerConsumptionEvaluator implements ConsumptionEvaluator {
    private int distanceTravelledX;
    private int distanceTravelledY;

    @Override
    public int evaluateConsumption(GManTrajectory gManTrajectory) {
        int totalTravelCost = calculateTotalTravelCost(gManTrajectory);
        int totalTurningCost = gManTrajectory.getConsumptionCostModel().getTurningCost() * calculateNoOfTurns(gManTrajectory);
        return totalTravelCost + totalTurningCost;
    }

    private int calculateTotalTravelCost(GManTrajectory gManTrajectory) {
        calculateDistanceTravelled(gManTrajectory.getSource(), gManTrajectory.getDestination());
        return (distanceTravelledX + distanceTravelledY) * gManTrajectory.getConsumptionCostModel().getTravellingCost();
    }

    private void calculateDistanceTravelled(Coordinate sourceCoordinate, Coordinate destinationCoordinate) {
        distanceTravelledX = Math.abs(sourceCoordinate.getX() - destinationCoordinate.getX());
        distanceTravelledY = Math.abs(sourceCoordinate.getY() - destinationCoordinate.getY());
    }

    private int calculateNoOfTurns(GManTrajectory gManTrajectory) {
        int turns = 0;
        int sourceX = gManTrajectory.getSource().getX();
        int sourceY = gManTrajectory.getSource().getY();
        int destinationX = gManTrajectory.getDestination().getX();
        int destinationY = gManTrajectory.getDestination().getY();
        String skipTurnDirection;
        String directionFacing = gManTrajectory.getCurrentDirection().toString();
        
        if (sourceX == destinationX) {
            turns += calculate180DegreeTurn(sourceY, destinationY, directionFacing, PowerStringConstants.Y_AXIS);
        } else {
            skipTurnDirection = sourceX > destinationX ? Direction.W.getLabel() : Direction.E.getLabel();
            if (!directionFacing.equalsIgnoreCase(skipTurnDirection)) {
                turns++;
            }
        }
        
        if (sourceY == destinationY) {
            turns += calculate180DegreeTurn(sourceX, destinationX, directionFacing, PowerStringConstants.X_AXIS);
        } else {
            skipTurnDirection = sourceY > destinationY ? Direction.S.getLabel() : Direction.N.getLabel();
            if (!directionFacing.equalsIgnoreCase(skipTurnDirection)) {
                turns++;
            }
        }
        
        return turns;
    }

    private int calculate180DegreeTurn(int sourceCoordinate, int destinationCoordinate, String directionFacing, String axis) {
        switch (axis) {
            case PowerStringConstants.X_AXIS:
                if ((destinationCoordinate > sourceCoordinate && directionFacing.equalsIgnoreCase(Direction.W.getLabel()))
                        || (destinationCoordinate < sourceCoordinate && directionFacing.equalsIgnoreCase(Direction.E.getLabel()))) {
                    return 1;
                }
                return 0;
            case PowerStringConstants.Y_AXIS:
                if ((destinationCoordinate > sourceCoordinate && directionFacing.equalsIgnoreCase(Direction.S.getLabel()))
                        || (destinationCoordinate < sourceCoordinate && directionFacing.equalsIgnoreCase(Direction.N.getLabel()))) {
                    return 1;
                }
                return 0;
            default:
                return 0;
        }
    }
}

