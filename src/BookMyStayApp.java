import java.util.*;

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}

class RoomInventory {
    private Map<String, Integer> availability;

    public RoomInventory() {
        availability = new HashMap<>();
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);
    }

    public Map<String, Integer> getAvailability() {
        return availability;
    }
}

class RoomAllocationService {
    private Map<String, Integer> counters = new HashMap<>();

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getAvailability();

        if (availability.get(type) > 0) {
            int count = counters.getOrDefault(type, 0) + 1;
            counters.put(type, count);

            String roomId = type + "-" + count;
            availability.put(type, availability.get(type) - 1);

            System.out.println("Booking confirmed for Guest: "
                    + reservation.getGuestName()
                    + ", Room ID: " + roomId);
        }
    }
}

class ConcurrentBookingProcessor implements Runnable {

    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {

        while (true) {
            Reservation reservation;

            synchronized (bookingQueue) {
                if (!bookingQueue.hasPendingRequests()) {
                    break;
                }
                reservation = bookingQueue.getNextRequest();
            }

            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Double"));
        bookingQueue.addRequest(new Reservation("Kural", "Suite"));
        bookingQueue.addRequest(new Reservation("Subha", "Single"));

        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.getAvailability().get("Single"));
        System.out.println("Double: " + inventory.getAvailability().get("Double"));
        System.out.println("Suite: " + inventory.getAvailability().get("Suite"));
=======
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