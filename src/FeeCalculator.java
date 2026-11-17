public class FeeCalculator {

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
}
