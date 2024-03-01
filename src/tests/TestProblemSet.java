package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestProblemSet {

    @Test

    public void average() {
        ArrayList<Double> numbers = new ArrayList<>();
        assertEquals(0.0, ProblemSet.average(numbers), 0.001);
        numbers.add(2.0);
        assertEquals(2.0, ProblemSet.average(numbers), 0.001);
        for (int i =1 ; i<= 1000000; i++) {
            numbers.add((double) i);
        }
        //double expAVG = 500000.5;
        //double actAVG = ProblemSet.average(numbers);
        assertEquals(500000.000002, ProblemSet.average(numbers),0.0001);
    }


    @Test
    public void sumOfDigits() {
        assertEquals(6, ProblemSet.sumOfDigits(123));
        assertEquals(12, ProblemSet.sumOfDigits(57));
        assertEquals(9, ProblemSet.sumOfDigits(-36));

    }


    @Test
    public void bestKey() {
            HashMap<String, Integer> hashMap1 = new HashMap<>();
            hashMap1.put("CSE", 100);
            hashMap1.put("MTH", 90);
            hashMap1.put("MGT", 10);
            assertEquals("CSE", ProblemSet.bestKey(hashMap1));

            HashMap<String, Integer> hashMap2 = new HashMap<>();
            hashMap2.put("cat", 5);
            hashMap2.put("dog", 5);
            hashMap2.put("fox", 4);
            String result = ProblemSet.bestKey(hashMap2);
            assertTrue(result.equals("cat") || result.equals("dog"));

            HashMap<String, Integer> hashMap3 = new HashMap<>();
            assertEquals("", ProblemSet.bestKey(hashMap3));

            HashMap<String, Integer> hashMap4 = new HashMap<>();
            hashMap4.put("A", -5);
            hashMap4.put("B", -10);
            hashMap4.put("C", -3);
            assertEquals("C", ProblemSet.bestKey(hashMap4));
    }

}