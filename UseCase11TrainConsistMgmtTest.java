import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmtTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UseCase11TrainConsistMgmt.isValidTrainID("TRN-1234"));
        assertTrue(UseCase11TrainConsistMgmt.isValidTrainID("TRN-9999"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID("TRAIN12"));
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID("TRN1234"));
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UseCase11TrainConsistMgmt.isValidCargoCode("PCT-AB"));
        assertTrue(UseCase11TrainConsistMgmt.isValidCargoCode("PCT-XY"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("PCT-ab"));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("PCT123"));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("AB-PCT"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID("TRN-123"));
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("PCT-ab"));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("PCT-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID(""));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode(""));
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID(null));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode(null));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // Ensure matcher.matches() is used, not matcher.find()
        assertFalse(UseCase11TrainConsistMgmt.isValidTrainID("TRN-1234-EXTRA"));
        assertFalse(UseCase11TrainConsistMgmt.isValidCargoCode("EXTRA-PCT-AB"));
    }
}
