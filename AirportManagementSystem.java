import java.util.ArrayList;
import java.util.Scanner;

class Airport {
    int airportId;
    String airportName;
    String city;

    Airport(int airportId, String airportName, String city) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.city = city;
    }
}

public class AirportManagementSystem {
    static ArrayList<Airport> airports = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void insertAirport() {
        System.out.print("Enter Airport ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Airport Name: ");
        String name = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        airports.add(new Airport(id, name, city));

        System.out.println("Record Inserted Successfully");
    }

    static void updateAirport() {
        System.out.print("Enter Airport ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Airport a : airports) {
            if (a.airportId == id) {
                System.out.print("Enter New Airport Name: ");
                a.airportName = sc.nextLine();

                System.out.print("Enter New City: ");
                a.city = sc.nextLine();

                System.out.println("Record Updated Successfully");
                return;
            }
        }

        System.out.println("Airport ID Not Found");
    }

    static void deleteAirport() {
        System.out.print("Enter Airport ID to Delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).airportId == id) {
                airports.remove(i);
                System.out.println("Record Deleted Successfully");
                return;
            }
        }

        System.out.println("Airport ID Not Found");
    }

    static void displayAirports() {
        if (airports.isEmpty()) {
            System.out.println("No Records Found");
            return;
        }

        System.out.println("\nAirport Records");

        for (Airport a : airports) {
            System.out.println("Airport ID: " + a.airportId);
            System.out.println("Airport Name: " + a.airportName);
            System.out.println("City: " + a.city);
            System.out.println("----------------------");
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Airport Management System =====");
            System.out.println("1. Insert Airport");
            System.out.println("2. Update Airport");
            System.out.println("3. Delete Airport");
            System.out.println("4. Display Airports");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertAirport();
                    break;
                case 2:
                    updateAirport();
                    break;
                case 3:
                    deleteAirport();
                    break;
                case 4:
                    displayAirports();
                    break;
                case 5:
                    System.out.println("Program Ended");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    }
}