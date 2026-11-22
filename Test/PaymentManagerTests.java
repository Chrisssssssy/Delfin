import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentManagerTests {

    PaymentManager paymentManager = new PaymentManager();

    @Test
    void testFeeCalculatorActiveMemberAge17() {
        //Arrange
        PaymentManager calculator = new PaymentManager();

        //Act
        int result = calculator.calculateFee(17, MembershipStatus.ACTIVE);

        //Assert
        assertEquals(1000, result);
    }

    @Test
    void testFeeCalculatorActiveMemberAge18() {
        //Arrange
        PaymentManager calculator = new PaymentManager();

        //Act
        int result = calculator.calculateFee(18, MembershipStatus.ACTIVE);

        //Assert
        assertEquals(1600, result);

    }

    @Test
    void testFeeCalculatorActiveMemberAge60() {
        //Arrange
        PaymentManager calculator = new PaymentManager();

        //Act
        int result = calculator.calculateFee(60, MembershipStatus.ACTIVE);

        //Assert
        assertEquals(1600, result);
    }

    @Test
    void testFeeCalculatorActiveMemberAge61() {
        //Arrange
        PaymentManager calculator = new PaymentManager();

        //Act
        int result = calculator.calculateFee(61, MembershipStatus.ACTIVE);

        //Assert
        assertEquals(1200, result);
    }

    @Test
    void testFeeCalculatorPassiveMemberAge44() {
        //Arrange
        PaymentManager calculator = new PaymentManager();

        //Act
        int result = calculator.calculateFee(44, MembershipStatus.PASSIVE);

        //Assert
        assertEquals(500, result);
    }

    @Test
    void testFeeCalculatorPassiveMemberAge16() {
        //Arrange
        PaymentManager calculator = new PaymentManager();

        //Act
        int result = calculator.calculateFee(16, MembershipStatus.PASSIVE);

        //Assert
        assertEquals(500, result);
    }

    @Test
    void testCalculateTotalWithThreeMembers() {
        //Arrange
        PaymentManager calculator = new PaymentManager();
        Member member1 = new Member("Hans", 17, 13,
                "Bryst", "Junior", MembershipStatus.ACTIVE, true);
        Member member2 = new Member("Kirsten", 35, 11,
                "Slow", "Adult", MembershipStatus.ACTIVE, true);
        Member member3 = new Member("Niels", 70, 12,
                "Bryst", "Old Boys", MembershipStatus.PASSIVE, true);

        List<Member> members = new ArrayList<>(List.of(member1, member2, member3));

        //Act
        int result = calculator.calculateTotal(members);

        //Assert
        assertEquals(3100, result);
    }

    @Test
    void testCalculateTotalWithNoMembers() {
        //Arrange
        PaymentManager calculator = new PaymentManager();

        List<Member> members = new ArrayList<>(List.of());

        //Act
        int result = calculator.calculateTotal(members);

        //Assert
        assertEquals(0, result);
    }

    @Test
    void testGetPaidMembers() {

        //Arrange
        Member member1 = new Member("Jens jensen", 18, 233,
                "Bryst", "Adult", MembershipStatus.ACTIVE, true);
        Member member2 = new Member("Tom Thomsen", 20, 533,
                "Hurtig", "Adult", MembershipStatus.ACTIVE, true);

        List<Member> members = List.of(member1, member2);
        //Act
        List<Member> result = paymentManager.getPaidMembers(members);
        //Assert
        assertEquals(2, result.size());
    }

    @Test
    void testGetUnpaidMembers() {

        Member member1 = new Member("Jonatan jensen", 45, 633,
                "Bryst", "Adult", MembershipStatus.ACTIVE, true);
        Member member2 = new Member("Tobias Thomsen", 23, 733,
                "Hurtig", "Adult", MembershipStatus.ACTIVE, false);
        Member member3 = new Member("Frederik Frederiksen", 33, 833,
                "Langsom", "Adult", MembershipStatus.ACTIVE, false);


        List<Member> members = List.of(member1, member2, member3);

        List<Member> result = paymentManager.getUnpaidMembers(members);

        assertEquals(2, result.size());

        assertTrue(result.contains(member2));
        assertTrue(result.contains(member3));
        assertFalse(result.contains(member1));

    }


}