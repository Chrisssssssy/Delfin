import java.util.ArrayList;
import java.util.List;

public class PaymentManager {

    private final List<Integer> paidMemberIds = new ArrayList<>();

    public void markAsPaid(int memberid) {
        if (!paidMemberIds.contains(memberid)) {
            paidMemberIds.add(memberid);
        }
    }

    public boolean hasPaid(int memberId) {
        return paidMemberIds.contains(memberId);
    }

    public boolean hasPaid(Member member) {
        return hasPaid(member.getMemberID());
    }

    public List<Member> getPaidMembers(List<Member> members) {

        List<Member> paidMembers = new ArrayList<>();

        for (Member member : members) {
            if (hasPaid(member)) {
                paidMembers.add(member);
            }
        }

        return paidMembers;
    }

    public List<Member> getUnpaidMembers(List<Member> members) {

        List<Member> unpaidMembers = new ArrayList<>();

        for (Member member : members) {
            if (!hasPaid(member)) {
                unpaidMembers.add(member);
            }
        }

        return unpaidMembers;
    }

    public int calculateFee(int age, MembershipStatus status) {

        if (status == MembershipStatus.PASSIVE) {
            return 500;
        }
        if (status == MembershipStatus.ACTIVE) {

            if (age < 18) {
                return 1000;
            }
            if (age > 60) {
                return 1200;
            }
        }
        return 1600;
    }

    public int calculateTotal(List<Member> members) {
        int total = 0;

        for (Member member : members) {
            int age = member.getAge();
            MembershipStatus status = member.getStatus();

            int fee = calculateFee(age, status);

            total += fee;
        }

        return total;
    }

}
