import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ==========================================
 * MAIN CLASS - UseCase9TrainConsistMgmt
 * ==========================================
 * Use Case 9: Group Bogies by Type
 * 
 * Description:
 * This class groups similar bogies together using
 * Java Stream Collectors.groupingBy().
 * 
 * At this stage, the application:
 * - Creates a list of bogies
 * - Streams the list
 * - Groups bogies by name
 * - Stores grouped data in a Map
 * - Displays grouped structure
 */
public class UseCase9TrainConsistMgmt {
    
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
            return "Bogie Type: " + name + "\nCapacity -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("==========================================");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 76));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }
        System.out.println();

        // Group using Collectors.groupingBy
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
            .collect(Collectors.groupingBy(Bogie::getName));

        System.out.println("Grouped Bogies");
        System.out.println("------------------------------------------");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            for (Bogie b : entry.getValue()) {
                System.out.println(b);
                System.out.println();
            }
        }
        
        System.out.println("UC9 grouping completed...");
    }

    // Helper method for testing
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        if (bogies == null) return Map.of();
        return bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
    }
}
