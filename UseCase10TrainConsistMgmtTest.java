import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmtTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = Arrays.asList(
            new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72),
            new UseCase10TrainConsistMgmt.Bogie("AC Chair", 54)
        );
        int total = UseCase10TrainConsistMgmt.calculateTotalCapacity(bogies);
        assertEquals(126, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = Arrays.asList(
            new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72),
            new UseCase10TrainConsistMgmt.Bogie("AC Chair", 54),
            new UseCase10TrainConsistMgmt.Bogie("First Class", 24),
            new UseCase10TrainConsistMgmt.Bogie("Sleeper", 76)
        );
        int total = UseCase10TrainConsistMgmt.calculateTotalCapacity(bogies);
        assertEquals(226, total); // 72+54+24+76 = 226
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = Arrays.asList(
            new UseCase10TrainConsistMgmt.Bogie("First Class", 24)
        );
        int total = UseCase10TrainConsistMgmt.calculateTotalCapacity(bogies);
        assertEquals(24, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        int total = UseCase10TrainConsistMgmt.calculateTotalCapacity(bogies);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = Arrays.asList(
            new UseCase10TrainConsistMgmt.Bogie("TypeA", 10),
            new UseCase10TrainConsistMgmt.Bogie("TypeB", 20)
        );
        int total = UseCase10TrainConsistMgmt.calculateTotalCapacity(bogies);
        assertEquals(30, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = Arrays.asList(
            new UseCase10TrainConsistMgmt.Bogie("Sleeper", 5),
            new UseCase10TrainConsistMgmt.Bogie("Sleeper", 5),
            new UseCase10TrainConsistMgmt.Bogie("Sleeper", 5)
        );
        int total = UseCase10TrainConsistMgmt.calculateTotalCapacity(bogies);
        assertEquals(15, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>(Arrays.asList(
            new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72),
            new UseCase10TrainConsistMgmt.Bogie("AC Chair", 54)
        ));
        int originalSize = bogies.size();
        UseCase10TrainConsistMgmt.calculateTotalCapacity(bogies);
        assertEquals(originalSize, bogies.size());
    }
}
