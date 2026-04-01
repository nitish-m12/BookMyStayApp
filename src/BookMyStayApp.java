import java.util.HashMap;
import java.util.Map;

abstract class Room {

    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        SingleRoom single = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        SuiteRoom suite = new SuiteRoom();

        System.out.println("Hotel Room Inventory Status\n");

        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Single"));
        System.out.println();

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Double"));
        System.out.println();

        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Suite"));
=======
import java.util.*;
/**
 * CLASS: Service
 * -----------------------------------------
 * Represents an optional add-on service
 * that can be attached to a reservation.
 *
 * Examples:
 * - Breakfast
 * - Airport Pickup
 *
 * Each service has:
 * - serviceName → Name of the service
 * - cost → Price of the service
 */
class Service {

    // Name of the service
    private String serviceName;

    // Cost of the service
    private double cost;

    /**
     * Constructor to initialize service details
     *
     * @param serviceName Name of the service
     * @param cost Cost of the service
     */
    public Service(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    /**
     * Returns the name of the service
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Returns the cost of the service
     */
    public double getCost() {
        return cost;
    }
}
/**
 * CLASS: AddOnServiceManager
 * -----------------------------------------
 * Manages add-on services linked to reservations.
 *
 * Responsibilities:
 * - Store services per reservation
 * - Add new services
 * - Calculate total service cost
 * - Display selected services
 */
class AddOnServiceManager {

    /**
     * Map Structure:
     * Key   → Reservation ID (String)
     * Value → List of Services
     *
     * Represents One-to-Many relationship:
     * One Reservation → Multiple Services
     */
    private Map<String, List<Service>> servicesByReservation;

    /**
     * Constructor initializes the map
     */
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Adds a service to a specific reservation
     *
     * @param reservationId Unique reservation ID
     * @param service Service to be added
     */
    public void addService(String reservationId, Service service) {

        // If reservation does not exist, create new list
        servicesByReservation
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    /**
     * Calculates total cost of all services
     * for a given reservation
     *
     * @param reservationId Reservation ID
     * @return Total cost
     */
    public double calculateTotalServiceCost(String reservationId) {

        double total = 0;

        // Get services list
        List<Service> services = servicesByReservation.get(reservationId);

        // Sum up all service costs
        if (services != null) {
            for (Service s : services) {
                total += s.getCost();
            }
        }

        return total;
    }

    /**
     * Displays all services for a reservation
     *
     * @param reservationId Reservation ID
     */
    public void displayServices(String reservationId) {

        List<Service> services = servicesByReservation.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services added.");
            return;
        }

        System.out.println("Selected Services:");

        for (Service s : services) {
            System.out.println("- " + s.getServiceName() + " : " + s.getCost());
        }
    }
}
/**
 * MAIN CLASS: UseCase7AddOnServiceSelection
 * -----------------------------------------
 * Demonstrates how add-on services are:
 * - Created
 * - Attached to reservation
 * - Calculated
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        // Create manager object
        AddOnServiceManager manager = new AddOnServiceManager();

        // Sample reservation
        String reservationId = "Single-1";

        /**
         * Create services
         */
        Service breakfast = new Service("Breakfast", 500);
        Service airportPickup = new Service("Airport Pickup", 1000);

        /**
         * Add services to reservation
         */
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, airportPickup);

        /**
         * Display services
         */
        System.out.println("Reservation ID: " + reservationId);
        manager.displayServices(reservationId);

        /**
         * Calculate total cost
         */
        double totalCost = manager.calculateTotalServiceCost(reservationId);

        System.out.println("Total Add-On Cost: " + totalCost);
    }
}