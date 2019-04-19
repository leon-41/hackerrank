package easy;

import java.util.HashMap;
import java.util.Map;

public class TheTimeInWords {


    static String timeInWords(int h, int m) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "one");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "quarter");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(21, "twenty one");
        map.put(22, "twenty two");
        map.put(23, "twenty three");
        map.put(24, "twenty four");
        map.put(25, "twenty five");
        map.put(26, "twenty six");
        map.put(27, "twenty seven");
        map.put(28, "twenty eight");
        map.put(29, "twenty nine");
        map.put(30, "half");

        String hour = map.get(h);
        String minute = map.get(m);
        String result = "";
        if (m == 0){
            result = String.format("%s o' clock", hour);
        } else if(m == 1){
            result = String.format("%s minute past %s", minute, hour);
        } else if (m == 15){
            result = String.format("quarter past %s", hour);
        } else if (m == 30){
            result = String.format("half past %s", hour);
        } else if (m == 45){
            hour = map.get(h + 1);
            result = String.format("quarter to %s", hour);
        } else if (m < 30){
            result = String.format("%s minutes past %s", minute, hour);
        } else {

            m = 60 - m;
            minute = map.get(m);
            hour = map.get(h + 1);
            result = String.format("%s minutes to %s", minute, hour);
        }
        return result;

    }


}
