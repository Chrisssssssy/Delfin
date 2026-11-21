import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MemberCsvFileHandler {
    private final Path path;
    private final MemberCsvMapper mapper;

    public MemberCsvFileHandler(Path path, MemberCsvMapper mapper) {
        this.path = path;
        this.mapper = mapper;
    }

    public List<Member> loadMembers() throws IOException {
        List<Member> members = new ArrayList<>();

        if (!Files.exists(path)) {
            return members;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    Member member = mapper.fromCsv(line);
                    members.add(member);
                }
            }
        }
        return members;
    }

    public void saveMembers(List<Member> members) throws IOException {
        Files.createDirectories(path.getParent());

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                writer.write(mapper.toCsv(member));
                writer.newLine();
            }
        }
    }
}
