import java.util.ArrayList;
import java.util.List;

/**
 * ==========================================
 * MAIN CLASS - UseCase10TrainConsistMgmt
 * ==========================================
 * Use Case 10: Count Total Seats in Train
 * 
 * Description:
 * This class aggregates seating capacity of all bogies
 * into a single total using Stream reduce().
 * 
 * At this stage, the application:
 * - Creates Bogie List
 * - Maps bogies to capacity
 * - Reduces values into total
 * - Displays total seat count
 * 
 * This maps aggregation logic using reduce().
 */
public class UseCase10TrainConsistMgmt {
    
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("==========================================");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 76));

        System.out.println("\nBogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        System.out.println();

        // Aggregate using reduce
        int totalSeats = bogies.stream()
            .map(Bogie::getCapacity)
            .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity of Train: " + totalSeats);
        System.out.println("------------------------------------------");
        System.out.println("UC10 aggregation completed...");
    }

    // Helper method for unit tests
    public static int calculateTotalCapacity(List<Bogie> bogies) {
        if (bogies == null) return 0;
        return bogies.stream()
            .map(Bogie::getCapacity)
            .reduce(0, Integer::sum);
    }
}
