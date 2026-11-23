import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class testSaveAndLoadMembers {
    @Test
    void testSaveAndLoadMembers(@TempDir Path tempDir) throws Exception {
        // arrange
        Path file = tempDir.resolve("members.csv");
        MemberCsvMapper mapper = new MemberCsvMapper();
        MemberCsvFileHandler handler = new MemberCsvFileHandler(file, mapper);

        Member member = new Member("Mikkel", 25, 100, "crawl", "beginner", MembershipStatus.ACTIVE);
        List<Member> membersToSave = List.of(member);

        // act
        handler.saveMembers(membersToSave);
        List<Member> loadedMembers = handler.loadMembers();

        // assert
        assertEquals(1, loadedMembers.size());
        Member loaded = loadedMembers.get(0);
        assertEquals("Mikkel", loaded.getName());
        assertEquals(25, loaded.getAge());
        assertEquals(100, loaded.getMemberID());
    }
}
