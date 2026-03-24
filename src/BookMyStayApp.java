/**
 * ============================================================
 * ABSTRACT CLASS - Room
 * ============================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This abstract class represents a generic hotel room.
 * It defines common attributes shared by all room types.
 *
 * The class focuses only on intrinsic properties of a room
 * and does NOT handle availability (state is external).
 *
 * @version 2.1
 */
abstract class Room {

    /** Number of beds available in the room */
    protected int numberOfBeds;

    /** Total size of the room in square feet */
    protected int squareFeet;

    /** Price charged per night */
    protected double pricePerNight;

    /**
     * Constructor to initialize room attributes
     *
     * @param numberOfBeds number of beds
     * @param squareFeet size of the room
     * @param pricePerNight cost per night
     */
    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    /**
     * Displays room details along with availability
     *
     * @param availableRooms number of available rooms
     */
    public void displayRoomDetails(int availableRooms) {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
        System.out.println("Available: " + availableRooms);
    }
}
/**
 * ============================================================
 * CLASS - SingleRoom
 * ============================================================
 *
 * Represents a single room in the hotel.
 *
 * @version 2.1
 */
class SingleRoom extends Room {

    /**
     * Initializes a SingleRoom with predefined attributes
     */
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}
/**
 * ============================================================
 * CLASS - DoubleRoom
 * ============================================================
 *
 * Represents a double room in the hotel.
 *
 * @version 2.1
 */
class DoubleRoom extends Room {

    /**
     * Initializes a DoubleRoom with predefined attributes
     */
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}
/**
 * ============================================================
 * CLASS - SuiteRoom
 * ============================================================
 *
 * Represents a suite room in the hotel.
 *
 * @version 2.1
 */
class SuiteRoom extends Room {

    /**
     * Initializes a SuiteRoom with predefined attributes
     */
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}
/**
 * ============================================================
 * MAIN CLASS - UseCase2RoomInitialization
 * ============================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This class demonstrates room initialization using
 * object-oriented design principles such as abstraction,
 * inheritance, and polymorphism.
 *
 * Availability is represented using simple variables
 * to highlight limitations before introducing inventory systems.
 *
 * @version 2.1
 */
class UseCase2RoomInitialization {

    /**
     * Application entry point
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        // Creating room objects (Polymorphism)
        Room single = new SingleRoom();
        Room dbl = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability values (state separated from domain)
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Displaying room details
        System.out.println("Single Room:");
        single.displayRoomDetails(singleAvailable);

        System.out.println("\nDouble Room:");
        dbl.displayRoomDetails(doubleAvailable);

        System.out.println("\nSuite Room:");
        suite.displayRoomDetails(suiteAvailable);
    }
}