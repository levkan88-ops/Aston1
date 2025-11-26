import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTest {
    @Test public void testEquals() { assertEquals(NumberComparator.compare(5, 5), 0); }
    @Test public void testLess() { assertTrue(NumberComparator.compare(3, 5) < 0); }
    @Test public void testGreater() { assertTrue(NumberComparator.compare(7, 5) > 0); }
}
