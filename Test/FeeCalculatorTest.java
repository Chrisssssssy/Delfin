import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FeeCalculatorTest {

    @Test
    void testFeeCalculatorActiveMemberAge17() {
        //Arrange
        FeeCalculator calculator = new FeeCalculator();

        //Act
        int result = calculator.calculateFee(17, MembershipStatus.ACTIVE);

        //Assert
        assertEquals(1000, result);
    }

    @Test
    void testFeeCalculatorActiveMemberAge18() {
        //Arrange
        FeeCalculator calculator = new FeeCalculator();

        //Act
        int result = calculator.calculateFee(18, MembershipStatus.ACTIVE);

        //Assert
        assertEquals(1600, result);

    }

    @Test
    void testFeeCalculatorActiveMemberAge60() {
        //Arrange
        FeeCalculator calculator = new FeeCalculator();

        //Act
        int result = calculator.calculateFee(60, MembershipStatus.ACTIVE);

        //Assert
        assertEquals(1600, result);
    }
    @Test
    void testFeeCalculatorActiveMemberAge61() {
        //Arrange
        FeeCalculator calculator = new FeeCalculator();

        //Act
        int result = calculator.calculateFee(61, MembershipStatus.ACTIVE);

        //Assert
        assertEquals(1200, result);
    }
    @Test
    void testFeeCalculatorPassiveMember() {
        //Arrange
        FeeCalculator calculator = new FeeCalculator();

        //Act
        int result = calculator.calculateFee(44, MembershipStatus.PASSIVE);

        //Assert
        assertEquals(500, result);
    }
}