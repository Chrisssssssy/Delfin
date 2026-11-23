import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MemberCsvMapperTest {

    @Test
    void testToCsv() {
        // arrange
        MemberCsvMapper mapper = new MemberCsvMapper();
        Member member = new Member("Mikkel", 25, 100, "crawl", "beginner", MembershipStatus.ACTIVE);

        // act
        String result = mapper.toCsv(member);

        // assert
        assertEquals("Mikkel,25,100,crawl,beginner,ACTIVE", result);
    }

    @Test
    void testFromCsv() {
        // arrange
        MemberCsvMapper mapper = new MemberCsvMapper();
        String csvLine = "Mikkel,25,100,crawl,beginner,ACTIVE";

        // act
        Member member = mapper.fromCsv(csvLine);

        // assert
        assertEquals("Mikkel", member.getName());
        assertEquals(25, member.getAge());
        assertEquals(100, member.getMemberID());
        assertEquals("crawl", member.getSwimmingStyle());
        assertEquals("beginner", member.getSwimmingLevel());
        assertEquals(MembershipStatus.ACTIVE, member.getStatus());
    }
}