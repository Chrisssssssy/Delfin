public class Member {

    private int memberNumber;
    private String name;
    private boolean hasPaid;

    public Member(int memberNumber, String name, boolean hasPaid) {
        this.memberNumber = memberNumber;
        this.name = name;
        this.hasPaid = hasPaid;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public String getName() {
        return name;
    }

    public boolean hasPaid() {
        return hasPaid;
    }

}
