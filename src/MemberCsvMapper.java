public class MemberCsvMapper {
  private final String delimiter = ",";

  public Member fromCsv(String line) {
      String[] fields = line.split(delimiter, -1);
      String name = fields[0];
      int age = Integer.parseInt(fields[1]);
      int memberID = Integer.parseInt(fields[2]);
      String swimmingStyle = fields[3];
      String swimmingLevel = fields[4];
      MembershipStatus status = MembershipStatus.valueOf(fields[5]);


      return new Member(name, age, memberID, swimmingStyle, swimmingLevel, status);

  }

  public boolean getHasPaidFromCsv(String line) {
      String[] fields = line.split(delimiter, -1);
      return Boolean.parseBoolean(fields[6]);

  }

  public String toCsv(Member member, boolean hasPaid) {
      return member.getName() + delimiter + member.getAge() +
     delimiter + member.getMemberID() + delimiter + member.getSwimmingStyle() +
     delimiter + member.getSwimmingLevel() + delimiter + member.getStatus().name()
              + delimiter + hasPaid;
  }
}
