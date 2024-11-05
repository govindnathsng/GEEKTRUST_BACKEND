package com.geektrust.backend.service;

import com.geektrust.backend.service.model.GManTrajectory;

public interface ConsumptionEvaluator {
    int evaluateConsumption(GManTrajectory gManTrajectory);
}
