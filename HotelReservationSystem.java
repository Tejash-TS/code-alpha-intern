import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Room class to represent a room in the hotel
class Room {
    private int roomId;
    private String category;
    private boolean isAvailable;
    private double pricePerNight;

    public Room(int roomId, String category, boolean isAvailable, double pricePerNight) {
        this.roomId = roomId;
        this.category = category;
        this.isAvailable = isAvailable;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
}

// Reservation class to represent a reservation
class Reservation {
    private Room room;
    private String userName;

    public Reservation(Room room, String userName) {
        this.room = room;
        this.userName = userName;
    }

    public Room getRoom() {
        return room;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "room=" + room.getRoomId() +
                ", userName='" + userName + '\'' +
                '}';
    }
}

// HotelReservationSystem class to handle the reservation system
public class HotelReservationSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public HotelReservationSystem() {
        // Initialize with some rooms
        rooms.add(new Room(1, "Single", true, 100.0));
        rooms.add(new Room(2, "Double", true, 150.0));
        rooms.add(new Room(3, "Suite", true, 250.0));
    }

    // Search for available rooms by category
    public void searchRooms(String category) {
        System.out.println("Available rooms in category: " + category);
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                System.out.println("Room ID: " + room.getRoomId() + ", Price per night: $" + room.getPricePerNight());
            }
        }
    }

    // Make a reservation
    public void makeReservation(int roomId, String userName) {
        for (Room room : rooms) {
            if (room.getRoomId() == roomId && room.isAvailable()) {
                room.setAvailable(false);
                Reservation reservation = new Reservation(room, userName);
                reservations.add(reservation);
                System.out.println("Reservation successful for " + userName + " in Room ID: " + roomId);
                return;
            }
        }
        System.out.println("Room ID: " + roomId + " is not available.");
    }

    // View all reservations
    public void viewReservations() {
        System.out.println("All Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search for Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter room category to search (Single, Double, Suite): ");
                    String category = scanner.nextLine();
                    system.searchRooms(category);
                    break;
                case 2:
                    System.out.print("Enter Room ID to reserve: ");
                    int roomId = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();
                    system.makeReservation(roomId, userName);
                    break;
                case 3:
                    system.viewReservations();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
