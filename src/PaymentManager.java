import java.util.ArrayList;
import java.util.List;

public class PaymentManager {

    public List<Payment> payments = new ArrayList<>();

    // Metode til at registrere en betaling

    public void registerPayment(int memberId, int year, int amount) {
        Payment payment = new Payment(memberId, year, amount);
        payments.add(payment);
    }



    // metode til at returnere en liste over betalinger

    public List<Payment> getPayments() {
        return payments;
    }

    //Metode til at hente betalinger for et bestemt medlem

    public List<Payment> getPaymentsForMember(int memberId) {
        List<Payment> result = new ArrayList<>();
        for (Payment payment : payments) {
            if (payment.getMemberId() == memberId) {
                 result.add(payment);
            }
        }
        return result;
    }

    // getter til medlemmer der har betalt
    public List<Member> getPaidMembers(List<Member> members) {

        List<Member> paidMembers = new ArrayList<>();

        for (Member member : members) {
            if (member.getHasPaid()) {
                paidMembers.add(member);
            }
        }

        return paidMembers;
    }

    // getter til medlemmer der ikke har betalt
    public List<Member> getUnpaidMembers(List<Member> members) {

        List<Member> unpaidMembers = new ArrayList<>();

        for (Member member : members) {
            if (!member.getHasPaid()) {
                unpaidMembers.add(member);
            }
        }

        return unpaidMembers;
    }

    // Metode til at beregne kontingent
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

    // metode til at beregne den forventede total af kontingent
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
