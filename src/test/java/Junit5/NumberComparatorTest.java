import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {
    @Test void testCompareEquals() { assertEquals(0, NumberComparator.compare(5, 5)); }
    @Test void testCompareLess() { assertTrue(NumberComparator.compare(3, 5) < 0); }
    @Test void testCompareGreater() { assertTrue(NumberComparator.compare(7, 5) > 0); }
}
