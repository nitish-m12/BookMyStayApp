import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * MAIN CLASS: UseCase6TrainConsistMgmt
 * ============================================================
 * Use Case 6: Map Bogie to Capacity (HashMap)
 *
 * Description:
 * This program maps each bogie to its seating/load capacity
 * using a HashMap (key-value structure).
 *
 * Key Features:
 * - Stores bogie name as key
 * - Stores capacity as value
 * - Allows fast lookup and retrieval
 *
 * Concepts Used:
 * - HashMap
 * - Map Interface
 * - Key-Value Mapping
 * - entrySet() iteration
 *
 * Author: Student
 * Version: 6.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("======================================\n");

        /**
         * HashMap:
         * Stores data in key -> value format
         */
        Map<String, Integer> capacityMap = new HashMap<>();

        // Step 1: Insert bogie capacities
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 60);
        capacityMap.put("First Class", 40);

        /**
         * Step 2: Iterate using entrySet()
         */
        System.out.println("Bogie Capacity Details:\n");

        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey());
            System.out.println("Capacity: " + entry.getValue());
            System.out.println();
        }
    }
}