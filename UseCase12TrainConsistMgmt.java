import java.util.ArrayList;
import java.util.List;

/**
 * ==========================================
 * MAIN CLASS - UseCase12TrainConsistMgmt
 * ==========================================
 * Use Case 12: Safety Compliance Check for Goods Bogies
 * 
 * Description:
 * This class enforces domain safety rules on goods bogies.
 * 
 * At this stage, the application:
 * - Creates goods bogie list
 * - Converts list into stream
 * - Applies safety validation rule
 * - Checks compliance using allMatch()
 * - Displays safety status
 * 
 * This maps real-world cargo safety rules using Streams.
 */
public class UseCase12TrainConsistMgmt {
    
    // Goods Bogie model
    public static class GoodsBogie {
        String type;
        String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("==========================================");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // This violates the safety rule

        System.out.println("\nGoods Bogies in Train:");
        for (GoodsBogie b : goodsBogies) {
            System.out.println(b);
        }
        System.out.println();

        // Apply safety compliance check using allMatch
        boolean isSafe = isTrainFormationSafe(goodsBogies);

        System.out.println("Safety Compliance Status: " + isSafe);
        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\n------------------------------------------");
        System.out.println("UC12 safety validation completed...");
    }

    // Helper method for the stream validation logic
    public static boolean isTrainFormationSafe(List<GoodsBogie> bogies) {
        if (bogies == null || bogies.isEmpty()) return true;

        return bogies.stream().allMatch(bogie -> {
            if ("Cylindrical".equalsIgnoreCase(bogie.getType())) {
                return "Petroleum".equalsIgnoreCase(bogie.getCargo());
            }
            return true; // Non-cylindrical bogies can carry anything safely in this context
        });
    }
}
