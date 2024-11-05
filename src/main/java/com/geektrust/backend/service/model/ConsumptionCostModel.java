package com.geektrust.backend.service.model;

public class ConsumptionCostModel {
    private final int totalPower; // Total power of the character
    private final int travellingCost; // Cost for making a move to an adjacent coordinate
    private final int turningCost; // Cost for making one left or right turn

   
    public ConsumptionCostModel(int totalPower, int travellingCost, int turningCost) {
        this.totalPower = totalPower;
        this.travellingCost = travellingCost;
        this.turningCost = turningCost;
    }

  
    public int getTotalPower() {
        return totalPower;
    }

  
    public int getTravellingCost() {
        return travellingCost;
    }

    
    public int getTurningCost() {
        return turningCost;
    }
}

