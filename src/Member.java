public class Member {
  private String name;
  private int age;
  private int memberID;
  private String swimmingStyle;
  private String swimmingLevel;


  public Member(String name, int age, int memberID, String swimmingStyle, String swimmingLevel){
      this.name = name;
      this.age = age;
      this.memberID = memberID;
      this.swimmingStyle = swimmingStyle;
      this.swimmingLevel = swimmingLevel;

  }
public String toString(){
      return String.format("""
              Navn: %s
              Alder: %d
              Medlemsnummer: %d
              Svømmestil: %s
              Svømmeniveau: %s""", name, age, memberID, swimmingStyle, swimmingLevel);
}
}
