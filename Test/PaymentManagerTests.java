import org.junit.jupiter.api.Test;

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
}