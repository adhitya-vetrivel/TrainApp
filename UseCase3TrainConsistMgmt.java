import java.util.HashSet;
import java.util.Set;

/**
 * =====================================
 * MAIN CLASS - UseCase3TrainConsistMgmt
 * =====================================
 *
 * Use Case 3: Track Unique Bogie IDs
 *
 * Description:
 * This class ensures that duplicate bogie IDs are not
 * added into the train formation using HashSet.
 *
 * At this stage, the application:
 * - Stores bogie IDs
 * - Prevents duplicates automatically
 * - Displays unique bogie identifiers
 *
 * This maps uniqueness validation using Set.
 *
 * @author Developer
 * @version 1.0
 */
public class UseCase3TrainConsistMgmt {
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println(" UC3 - Track Unique Bogie IDs ");
        System.out.println("======================================");
        System.out.println();

        // Create a Set to store unique bogie IDs
        // HashSet stores only unique values
        Set<String> bogies = new HashSet<>();

        // ---- ADD IDs (including duplicates) ----
        // add() inserts bogie IDs into the set
        bogies.add("B0101");
        bogies.add("B0102");
        bogies.add("B0103");
        bogies.add("B0104");
        // Duplicate entries will be ignored internally by HashSet
        bogies.add("B0102"); //Duplicate entry
        bogies.add("B0102"); //Duplicate entry

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies);
        System.out.println();

        System.out.println("Note:");
        System.out.println("Duplicates are automatically ignored by HashSet.");
        System.out.println();
        
        System.out.println("UC3 uniqueness validation completed...");
    }
}