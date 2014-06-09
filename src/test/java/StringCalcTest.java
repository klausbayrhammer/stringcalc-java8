import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class StringCalcTest {

    @Test
    public void emptyString() throws Exception {
        assertEquals(0, StringCalc.calc(""));

    }

    @Test
    public void singleDigitString() throws Exception {
        assertEquals(1, StringCalc.calc("1"));
    }

    @Test
    public void multipleNumbers() throws Exception {
        assertEquals(3, StringCalc.calc("1,2"));
    }

    @Test
    public void onlyAddNumbersLowerThan1000() throws Exception {
        assertEquals(3, StringCalc.calc("1,2,1000"));
    }

    @Test
    public void exceptionsOnNegativeValues() throws Exception {
        try {
            StringCalc.calc("-1");
            fail();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("-1"));
        }
    }
}
