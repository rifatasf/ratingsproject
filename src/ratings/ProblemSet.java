package ratings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProblemSet {


    public static double average(ArrayList<Double> numbers) {
        if (numbers.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (double num : numbers) {
            sum += num;
        }
        return sum/ numbers.size();

        // TODO: Implement this method to return the average of all the numbers in the input ArrayList
        //       If the ArrayList is empty, return 0.0
        //
        // Examples
        // [1.0,2.0,3.0] returns 2.0
        // [-5.0,5.0] returns 0.0
        // [6.5,6.5,8.5,8.5] returns 7.5
        // [] returns 0.0

    }

    public static int sumOfDigits(int number) {
        number = Math.abs(number);
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += digit;
            number/=10;
        }
        return sum;
    }
    // TODO: Write a public static method named sumOfDigits that takes an int as a parameter and
    //       returns the sum of the digits of the input as an int
    //
    // Examples
    // 123 returns 6
    // 57 returns 12
    // -36 returns 9


    // TODO: Write a public static method named bestKey that takes a HashMap of String to Integer
    //       as a parameter and returns a key mapping to the largest Integer. Ties can be broken arbitrarily.
    //       If the HashMap is empty, return the empty String
    //
    // Examples
    // {"CSE": 100, "MTH": 90, "MGT": 10} returns "CSE"
    // {"cat": 5, "dog": 5, "fox": 4} can return either "cat" or "dog"
    // {} returns ""

    public static String bestKey(HashMap<String, Integer> map) {
        String bestKey = "";
        if (map.isEmpty()) {
            return bestKey;
        }
        int maxval = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value > maxval) {
                maxval = value;
                bestKey = key;
            }
        }
        return bestKey;

    }

}
