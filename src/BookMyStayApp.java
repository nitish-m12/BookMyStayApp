import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ============================================================
 * MAIN CLASS: UseCase5TrainConsistMgmt
 * ============================================================
 * Use Case 5: Preserve Insertion Order of Bogies
 *
 * Description:
 * This program simulates a train consist (formation of bogies)
 * using LinkedHashSet.
 *
 * Key Features:
 * - Maintains insertion order
 * - Prevents duplicate bogies
 * - Represents real-world train attachment sequence
 *
 * Concepts Used:
 * - LinkedHashSet
 * - Set Interface
 * - Automatic duplicate handling
 *
 * Author: Student
 * Version: 5.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("======================================\n");

        /**
         * LinkedHashSet:
         * - Preserves insertion order
         * - Ensures uniqueness
         */
        Set<String> formation = new LinkedHashSet<>();

        // Step 1: Add bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Step 2: Attempt duplicate entry
        formation.add("Sleeper"); // Will be ignored automatically

        /**
         * Step 3: Display final formation
         */
        System.out.println("Final Train Formation:\n");

        for (String bogie : formation) {
            System.out.println(bogie);
        }
    }
}