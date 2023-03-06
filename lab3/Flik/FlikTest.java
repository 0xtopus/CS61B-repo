import org.junit.Test;
import static org.junit.Assert.*;
public class FlikTest {
    /* test isSameNumber()  */
    @Test
    public void testIsSameNumber() {
        Integer a, b;
        a = 0;
        b = 0;
        for (a = 0, b = 0; a < 500; a++, b++) {
            assertTrue(Flik.isSameNumber(a, b));
        }
    }

    /* a great explaination about why this will broken once it exceeded 128 by ChatGPT:
    * In Java, integers from -128 to 127 are cached and reused by the JVM.
    * When the == operator is used with objects, it compares the references of the objects
    * rather than their values.

    * In the isSameNumber method, since the arguments are Integer objects (which are immutable),
    * the JVM reuses the same Integer objects for values between -128 and 127. Therefore,
    * when a and b are between -128 and 127, a == b returns true because they are pointing to the same Integer
    *  object in memory.

    * However, when a and b are greater than 127, the JVM creates new Integer objects,
    * so a == b returns false because they are pointing to different objects in memory.
    * */
}
