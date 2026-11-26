public class MemberCsvMapper {
  private final String delimiter = ",";

  public Member fromCsv(String line) {
      String[] fields = line.split(delimiter, -1);
      String name = fields[0];
      int age = Integer.parseInt(fields[1]);
      int memberID = Integer.parseInt(fields[2]);
      String swimmingLevel = fields[3];
      MembershipStatus status = MembershipStatus.valueOf(fields[4]);
      boolean hasPaid = Boolean.parseBoolean(fields[5]);

      return new Member(name, age, memberID, swimmingLevel, status, hasPaid);

  }

  public String toCsv(Member member){
      return member.getName() + delimiter + member.getAge() +
     delimiter + member.getMemberID() + delimiter  + member.getSwimmingLevel() + delimiter + member.getStatus().name()
              + delimiter + member.getHasPaid();
  }
}
