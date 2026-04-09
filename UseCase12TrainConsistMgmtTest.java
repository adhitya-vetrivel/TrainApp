import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase12TrainConsistMgmtTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
            new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"),
            new UseCase12TrainConsistMgmt.GoodsBogie("Open", "Coal"),
            new UseCase12TrainConsistMgmt.GoodsBogie("Box", "Grain")
        );
        assertTrue(UseCase12TrainConsistMgmt.isTrainFormationSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
            new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(UseCase12TrainConsistMgmt.isTrainFormationSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
            new UseCase12TrainConsistMgmt.GoodsBogie("Open", "Petroleum"),
            new UseCase12TrainConsistMgmt.GoodsBogie("Box", "Coal")
        );
        assertTrue(UseCase12TrainConsistMgmt.isTrainFormationSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
            new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"), // Valid
            new UseCase12TrainConsistMgmt.GoodsBogie("Box", "Hardware"), // Valid
            new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Chemicals") // Invalid
        );
        assertFalse(UseCase12TrainConsistMgmt.isTrainFormationSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = new ArrayList<>();
        assertTrue(UseCase12TrainConsistMgmt.isTrainFormationSafe(bogies));
    }
}
