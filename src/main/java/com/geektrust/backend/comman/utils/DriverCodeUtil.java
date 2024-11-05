package com.geektrust.backend.comman.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.geektrust.backend.comman.constants.PowerStringConstants;
import com.geektrust.backend.entity.GMan;
import com.geektrust.backend.service.ConsumptionEvaluator;
import com.geektrust.backend.service.PowerConsumptionEvaluator;
import com.geektrust.backend.service.model.ConsumptionCostModel;
import com.geektrust.backend.service.model.Coordinate;
import com.geektrust.backend.service.model.GManTrajectory;

public class DriverCodeUtil {
    private DriverCodeUtil() {
    }

    public static List<String> readInputs(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             Scanner sc = new Scanner(fis)) {
            List<String> inputLines = new ArrayList<>();
            while (sc.hasNextLine()) {
                inputLines.add(sc.nextLine());
            }
            return inputLines;
        }
    }

    private static int calculateRemainingPower(GMan gMan, ConsumptionCostModel consumptionCostModel) {
        ConsumptionEvaluator powerConsumptionEvaluator = new PowerConsumptionEvaluator();
        GManTrajectory gManTrajectory = new GManTrajectory(gMan.getSourceCoordinate(), gMan.getDestinationCoordinate(), gMan.getDirectionFacing(), consumptionCostModel);
        return consumptionCostModel.getTotalPower() - powerConsumptionEvaluator.evaluateConsumption(gManTrajectory);
    }

    public static void processResults(List<String> inputs, ConsumptionCostModel consumptionCostModel) {
        GMan gMan = new GMan();
        for (String inputLine : inputs) {
            String[] cmd = inputLine.split(PowerStringConstants.SPACE);
            switch (cmd[0]) {
                case PowerStringConstants.SOURCE:
                    Coordinate sourceCoordinate = new Coordinate(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    gMan.setSourceCoordinate(sourceCoordinate);
                    gMan.setDirectionFacing(cmd[3]);
                    break;
                case PowerStringConstants.DESTINATION:
                    Coordinate destinationCoordinate = new Coordinate(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    gMan.setDestinationCoordinate(destinationCoordinate);
                    break;
                case PowerStringConstants.PRINT_POWER:
                    int remainingPower = calculateRemainingPower(gMan, consumptionCostModel);
                    System.out.println(PowerStringConstants.POWER + PowerStringConstants.SPACE + remainingPower);
                    break;
                default:
                    break;
            }
        }
    }
}

