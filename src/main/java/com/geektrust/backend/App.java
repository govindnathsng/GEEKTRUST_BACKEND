package com.geektrust.backend;

import java.io.IOException;
import java.util.List;
import com.geektrust.backend.comman.utils.DriverCodeUtil;
import com.geektrust.backend.service.model.ConsumptionCostModel;

public class App {

    public static void main(String[] args) {
        String filePath;  
        
        // Check if command-line arguments are provided
        if (args.length == 0) {
            // If not, specify a default file path
            filePath = "/home/crio-user/workspace/govindnathsng-ME_GEEKTRUST_BACKEND/sample_input/input2.txt"; 
        } else {
            // If provided, use the file path from the command-line arguments
            filePath = args[0];
        }

        // Define consumption cost model
        ConsumptionCostModel consumptionCostModel = new ConsumptionCostModel(200, 10, 5);

        try {
            // Read inputs from the provided file
            List<String> inputs = DriverCodeUtil.readInputs(filePath);
            // Process the results
            DriverCodeUtil.processResults(inputs, consumptionCostModel);
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }

} 

