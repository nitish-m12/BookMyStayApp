import java.util.HashMap;
import java.util.Map;

/**
 * CLASS: RoomInventory
 * -------------------------------------------------------
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class maintains a centralized inventory of hotel rooms.
 * It acts as the SINGLE SOURCE OF TRUTH for room availability.
 *
 * Instead of using scattered variables, all room availability
 * is stored in a HashMap:
 *
 *      Key   -> Room Type (String)
 *      Value -> Available Count (Integer)
 *
 * Key Features:
 * - Fast access using HashMap (O(1) average time)
 * - Encapsulation of inventory logic
 * - Controlled updates to maintain consistency
 * - Scalable when adding new room types
 *
 * Example:
 * Single -> 5 rooms
 * Double -> 3 rooms
 * Suite  -> 2 rooms
 */
class RoomInventory {

    /**
     * HashMap to store availability of each room type
     */
    private Map<String, Integer> roomAvailability;

    /**
     * Constructor
     * Initializes empty inventory
     */
    public RoomInventory() {
        roomAvailability = new HashMap<>();
    }

    /**
     * METHOD: initializeInventory
     * -------------------------------------------------------
     * Initializes the inventory with default room counts.
     * This simulates loading initial data into the system.
     */
    public void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    /**
     * METHOD: getAvailability
     * -------------------------------------------------------
     * Returns the complete availability map.
     *
     * @return Map<String, Integer>
     */
    public Map<String, Integer> getAvailability() {
        return roomAvailability;
    }

    /**
     * METHOD: updateAvailability
     * -------------------------------------------------------
     * Updates room count for a specific room type.
     *
     * @param roomType Type of room (e.g., Single, Double)
     * @param count    New available count
     */
    public void updateAvailability(String roomType, int count) {
        if (roomAvailability.containsKey(roomType)) {
            roomAvailability.put(roomType, count);
        } else {
            System.out.println("Room type not found: " + roomType);
        }
    }

    /**
     * METHOD: getRoomCount
     * -------------------------------------------------------
     * Returns available rooms for a specific type.
     *
     * @param roomType Room type
     * @return int count (0 if not found)
     */
    public int getRoomCount(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }
}
/**
 * CLASS: Room
 * -------------------------------------------------------
 * Represents a room type with its characteristics.
 *
 * NOTE:
 * This class DOES NOT manage availability.
 * That responsibility belongs to RoomInventory.
 *
 * This ensures Separation of Concerns.
 */
class Room {

    private String type;
    private int size;
    private double price;

    /**
     * Constructor to initialize room details
     *
     * @param type  Room type (Single, Double, Suite)
     * @param size  Size in square feet
     * @param price Price per night
     */
    public Room(String type, int size, double price) {
        this.type = type;
        this.size = size;
        this.price = price;
    }

    /**
     * Displays room details
     */
    public void displayDetails() {
        System.out.println(type + " Room:");
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
    }

    public String getType() {
        return type;
    }
}
/**
 * MAIN CLASS: UseCase3InventorySetup
 * -------------------------------------------------------
 * Demonstrates centralized inventory usage.
 *
 * Flow:
 * 1. Create RoomInventory
 * 2. Initialize inventory
 * 3. Create Room objects
 * 4. Display room details + availability
 */
class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Step 1: Create inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Initialize inventory
        inventory.initializeInventory();

        // Step 3: Create room objects
        Room single = new Room("Single", 150, 1500.0);
        Room dbl = new Room("Double", 300, 2500.0);
        Room suite = new Room("Suite", 750, 5000.0);

        // Step 4: Display inventory
        System.out.println("Hotel Room Inventory Status\n");

        // Single Room
        single.displayDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomCount(single.getType()));
        System.out.println();

        // Double Room
        dbl.displayDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomCount(dbl.getType()));
        System.out.println();

        // Suite Room
        suite.displayDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomCount(suite.getType()));
    }
}