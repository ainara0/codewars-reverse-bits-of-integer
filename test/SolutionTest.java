import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.concurrent.ThreadLocalRandom;

public class SolutionTest {
    @Test
    public void fixedTests() {
        assertEquals("Failed for n = 417:\n", 267, reverseBits(417));
        assertEquals("Failed for n = 267:\n", 417, reverseBits(267));
        assertEquals("Failed for n = 0:\n", 0, reverseBits(0));
        assertEquals("Failed for n = 2017:\n", 1087, reverseBits(2017));
        assertEquals("Failed for n = 1023:\n", 1023, reverseBits(1023));
        assertEquals("Failed for n = 1024:\n", 1, reverseBits(1024));
    }
    
    @Test
    public void randomTests(){
      for(int i=0; i<40; i++){
        int test_n = ThreadLocalRandom.current().nextInt(0, ThreadLocalRandom.current().nextInt(1, 1000000));
        int expected = Integer.parseInt(new StringBuilder(Integer.toBinaryString(test_n)).reverse().toString(), 2);
//         System.out.println(String.format("Testing %d, Expecting %d", test_n, expected));
        assertEquals(String.format("Failed for n = %d:\n", test_n), expected, reverseBits(test_n));
      }
    }
  
    private int reverseBits(int n) {
      java.lang.reflect.Method method = null;
      try {
        method = BitsOfInteger.class.getDeclaredMethod("reverse_bits", int.class); // old solutions
      } catch (NoSuchMethodException ignore) {}

      try {
        if (method == null) {
          method = BitsOfInteger.class.getDeclaredMethod("reverseBits", int.class); // new solutions
        }
        return (int) method.invoke(null, n);
      } catch (Exception cause) {
        throw new RuntimeException(cause);
      }
   }
}