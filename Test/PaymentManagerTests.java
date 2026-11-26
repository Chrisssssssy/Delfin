import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentManagerTests {

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
        Member member1 = new Member("Hans", 17, 13, "Junior", MembershipStatus.ACTIVE, true);
        Member member2 = new Member("Kirsten", 35, 11, "Adult", MembershipStatus.ACTIVE, true);
        Member member3 = new Member("Niels", 70, 12, "Old Boys", MembershipStatus.PASSIVE, true);

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
}