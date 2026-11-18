import java.util.ArrayList;
import java.util.List;

public class PaymentManager {

    public List<Member> getPaidMembers(List<Member> members) {

        List<Member> paidMembers = new ArrayList<>();

        for (Member member : members) {
            if (member.getHasPaid()) {
                paidMembers.add(member);
            }
        }

        return paidMembers;
    }

    public List<Member> getUnpaidMembers(List<Member> members) {

        List<Member> unpaidMembers = new ArrayList<>();

        for (Member member : members) {
            if (!member.getHasPaid()) {
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

    public int calculateTotal(List<Integer> fees) {
        int total = 0;

        for (Integer sum : fees) {
            total += sum;
        }

        return total;
    }

}
