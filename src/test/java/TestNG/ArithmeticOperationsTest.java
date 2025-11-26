import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticOperationsTest {
    @Test public void testAdd() { assertEquals(ArithmeticOperations.add(3, 4), 7); }
    @Test public void testSubtract() { assertEquals(ArithmeticOperations.subtract(5, 4), 1); }
    @Test public void testMultiply() { assertEquals(ArithmeticOperations.multiply(4, 5), 20); }
    @Test public void testDivide() { assertEquals(ArithmeticOperations.divide(10, 5), 2.0); }
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideZero() { ArithmeticOperations.divide(10, 0); }
}
