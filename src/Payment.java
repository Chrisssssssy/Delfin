public class Payment {

    private int memberId;
    private int year;
    private int amount;

    //Constructor
    public Payment(int memberId, int year, int amount) {
        this.memberId = memberId;
        this.year = year;
        this.amount = amount;
    }

    //Getters
      public int getMemberId() {
        return memberId;
    }
    public int getYear() {
        return year;
    }
    public int getAmount() {
        return amount;
    }

}
