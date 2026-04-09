import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ==========================================
 * MAIN CLASS - UseCase11TrainConsistMgmt
 * ==========================================
 * Use Case 11: Validate Train ID and Cargo Code
 * 
 * Description:
 * This class validates input formats using Regular Expressions.
 * 
 * At this stage, the application:
 * - Accepts Train ID input
 * - Accepts Cargo Code input
 * - Applies regex validation
 * - Displays validation result
 * 
 * This maps format validation logic using Pattern matching.
 */
public class UseCase11TrainConsistMgmt {
    
    // Define regex rules
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PCT-[A-Z]{2}";
    
    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile(TRAIN_ID_REGEX);
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile(CARGO_CODE_REGEX);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("==========================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("==========================================");
        
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.hasNextLine() ? scanner.nextLine() : "TRN-1234";
        
        System.out.print("Enter Cargo Code (Format: PCT-AB): ");
        String cargoCode = scanner.hasNextLine() ? scanner.nextLine() : "PCT-XY";

        boolean isTrainIdValid = isValidTrainID(trainId);
        boolean isCargoCodeValid = isValidCargoCode(cargoCode);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);
        
        System.out.println("------------------------------------------");
        System.out.println("UC11 validation completed...");
        
        scanner.close();
    }

    public static boolean isValidTrainID(String trainId) {
        if (trainId == null) return false;
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);
        return matcher.matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        return matcher.matches();
    }
}
