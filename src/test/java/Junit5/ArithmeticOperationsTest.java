import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {
    @Test void testAdd() { assertEquals(7, ArithmeticOperations.add(3, 4)); }
    @Test void testSubtract() { assertEquals(1, ArithmeticOperations.subtract(5, 4)); }
    @Test void testMultiply() { assertEquals(20, ArithmeticOperations.multiply(4, 5)); }
    @Test void testDivide() { assertEquals(2.0, ArithmeticOperations.divide(10, 5)); }
    @Test void testDivideZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(10, 0));
    }
}
