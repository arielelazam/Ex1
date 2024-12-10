package assignments.ex1;
import assignments.ex1.Ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
       int v = Ex1.number2Int(s2); // v = 11
       assertEquals(v,11);
        String s10 = "1011bA";
       v = Ex1.number2Int(s10); // v = 1011
        s2 = Ex1.int2Number(v,2); // s2 = 1111110011b2
         int v2 = Ex1.number2Int(s2); // v2 = 1011
        assertEquals(v,v2);
         assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }

        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        String test1 = "100b2";
        String test2 = "3b9";
        String test3 = "1111b2";
        String test4 = "FFbG";
        String test5 = "173b8";
        assertEquals(Ex1.int2Number(4,2), test1);
        assertEquals(Ex1.int2Number(3,9), test2);
        assertEquals(Ex1.int2Number(15,2), test3);
        assertEquals(Ex1.int2Number(255,16), test4);
        assertEquals(Ex1.int2Number(123,8), test5);
    }
    @Test
    void maxIndexTest() {
        String[] array0 = {"1C3b16", "12b8", "1111b2", "200b5", "110b3"};
        String[] array1 = {"1111b2", "F1bG", "173b8", "400b5", "1120b3"};
        String[] array2 = {"101b2", "100bG", "700b8", "224b5", "201b3"};
        String[] array3 = {"1001b2", "80b16", "77b8", "1444b5", "1000b3"};
        String[] array4 = {"1110b2", "11b8", "1A3b16", "234b5", "121010b3"};

        assertEquals(Ex1.maxIndex(array0), 0);
        assertEquals(Ex1.maxIndex(array1), 1);
        assertEquals(Ex1.maxIndex(array2), 2);
        assertEquals(Ex1.maxIndex(array3), 3);
        assertEquals(Ex1.maxIndex(array4), 4);
    }
    @Test
    void equalsTest() {
        assertEquals(true,Ex1.equals("1100b2","CbD"));
        assertEquals(true,Ex1.equals("357bD","2403b6"));
        assertEquals(true,Ex1.equals("13202b4","111100010b2"));
        assertEquals(true,Ex1.equals("2205b7","1002020b3"));
        assertEquals(true,Ex1.equals("125bG","445b8"));
        assertEquals(false,Ex1.equals("1100b2","Cb9"));
        assertEquals(false,Ex1.equals("943b5","A1bB"));
        assertEquals(false,Ex1.equals("218b7","A1b9"));
        assertEquals(false,Ex1.equals("157","234b9"));
        assertEquals(false,Ex1.equals("854b9","45b5"));



    }

    @Test
    void isNumericTest() {
        String[] trueExamples = {"123456","9876543210","0000","111222333","456789"};
        String[] falseExamples = {"abc123","123 456","100.50","4567a",""};
        for (int i = 0; i < trueExamples.length; i++) {
            assertEquals(Ex1.isNumeric(trueExamples[i]), true);
            assertEquals(Ex1.isNumeric(falseExamples[i]), false);
        }

    }

}


