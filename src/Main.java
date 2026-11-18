import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
void main() {
Path path = Path.of("members.csv");
MemberCsvMapper mapper = new MemberCsvMapper();
MemberCsvFileHandler fileHandler = new MemberCsvFileHandler(path, mapper);

List<Member> members;
try{
    members = fileHandler.loadMembers();
    IO.println("Indlæste " + members.size() + "medlemmer" );

} catch (IOException e) {
    IO.println("Fejl ved indlæsning: " + e.getMessage());

}
}