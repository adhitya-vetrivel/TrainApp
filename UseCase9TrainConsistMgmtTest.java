import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmtTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = Arrays.asList(
            new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72),
            new UseCase9TrainConsistMgmt.Bogie("Sleeper", 76)
        );
        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);
        assertEquals(1, grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = Arrays.asList(
            new UseCase9TrainConsistMgmt.Bogie("AC Chair", 54),
            new UseCase9TrainConsistMgmt.Bogie("AC Chair", 60)
        );
        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);
        assertEquals(2, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = Arrays.asList(
            new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72),
            new UseCase9TrainConsistMgmt.Bogie("AC Chair", 54)
        );
        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);
        assertEquals(2, grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);
        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = Arrays.asList(
            new UseCase9TrainConsistMgmt.Bogie("First Class", 24)
        );
        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);
        assertEquals(1, grouped.size());
        assertEquals(1, grouped.get("First Class").size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = Arrays.asList(
            new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72),
            new UseCase9TrainConsistMgmt.Bogie("AC Chair", 54),
            new UseCase9TrainConsistMgmt.Bogie("First Class", 24)
        );
        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);
        assertTrue(grouped.keySet().containsAll(Arrays.asList("Sleeper", "AC Chair", "First Class")));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = Arrays.asList(
            new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72),
            new UseCase9TrainConsistMgmt.Bogie("Sleeper", 76),
            new UseCase9TrainConsistMgmt.Bogie("AC Chair", 54)
        );
        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = UseCase9TrainConsistMgmt.groupBogiesByType(bogies);
        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(1, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>(Arrays.asList(
            new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72)
        ));
        int originalSize = bogies.size();
        UseCase9TrainConsistMgmt.groupBogiesByType(bogies);
        assertEquals(originalSize, bogies.size());
    }
}
