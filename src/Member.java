public class Member {
  private String name;
  private int age;
  private int memberID;
  private String swimmingStyle;
  private String swimmingLevel;
  private MembershipStatus status;


  public Member(String name, int age, int memberID, String swimmingStyle, String swimmingLevel, MembershipStatus status){
      this.name = name;
      this.age = age;
      this.memberID = memberID;
      this.swimmingStyle = swimmingStyle;
      this.swimmingLevel = swimmingLevel;
      this.status = status;

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

}
