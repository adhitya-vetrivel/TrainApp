import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * =====================================
 * MAIN CLASS - UseCase8TrainConsistMgmt
 * =====================================
 *
 * Use Case 8: Filter Passenger Bogies Using Streams
 * 
 * Description:
 * This class filters passenger bogies based on seating
 * capacity using Java Stream API.
 *
 * At this stage, the application:
 * - Creates a list of bogies
 * - Converts list into stream
 * - Applies filter condition
 * - Collects filtered result
 * - Displays qualifying bogies
 *
 * This maps functional filtering using Streams.
 *
 * @author Developer
 * @version 1.0
 */
public class UseCase8TrainConsistMgmt {
    
    // Reusing Bogie model from UC7
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("======================================");
        System.out.println();

        // Create List of passenger bogies (same style as UC7)
        List<Bogie> bogies = new ArrayList<>();
        
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }
        System.out.println();

        // Convert the list into a stream pipeline and filter bogies with capacity > 60
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie b : filteredBogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }
        System.out.println();

        System.out.println("UC8 filtering completed...");
    }
}
