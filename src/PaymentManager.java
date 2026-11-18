import java.util.ArrayList;
import java.util.List;

public class PaymentManager {

    public List<Member> getPaidMembers(List<Member> members) {

        List<Member> paidMembers = new ArrayList<>();

        for (Member member : members) {
            if (member.hasPaid()) {
                paidMembers.add(member);
            }
        }

        return paidMembers;
    }

    public List<Member> getUnpaidMembers(List<Member> members) {

        List<Member> unpaidMembers = new ArrayList<>();

        for (Member member : members) {
            if (!member.hasPaid()) {
                unpaidMembers.add(member);
            }
        }

        return unpaidMembers;
    }

}
