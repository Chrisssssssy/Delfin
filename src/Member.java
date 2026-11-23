public class Member {
  private String name;
  private int age;
  private int memberID;
  private String swimmingStyle;
  private String swimmingLevel;
  private MembershipStatus status;
  private boolean hasPaid;


  public Member(String name, int age, int memberID, String swimmingStyle, String swimmingLevel, MembershipStatus status, boolean hasPaid){
      this.name = name;
      this.age = age;
      this.memberID = memberID;
      this.swimmingStyle = swimmingStyle;
      this.swimmingLevel = swimmingLevel;
      this.status = status;
      this.hasPaid = hasPaid;

  }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getSwimmingStyle() {
        return swimmingStyle;
    }

    public String getSwimmingLevel() {
        return swimmingLevel;
    }

    public MembershipStatus getStatus() {
      return status;
    }

    public void setStatus(MembershipStatus status) {
      this.status = status;
    }
    public boolean getHasPaid() {
        return hasPaid;
    }
    public void markAsHasPaid() {
      this.hasPaid = true;
    }

}
