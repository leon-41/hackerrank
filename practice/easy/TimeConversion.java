package easy;

public class TimeConversion {

    /**
     * Time Conversion
     */
    static String timeConversion(String s) {
        String hour = s.substring(0, 2);
        String minute = s.substring(3, 5);
        String second = s.substring(6, 8);
        String timeZone = s.substring(8);

        if (timeZone.equals("PM")){

            if (hour.equals( "12")){
                hour = "00";
            } else {

                if (hour.startsWith("0")){
                    hour = hour.substring(1);
                }
                Integer h = Integer.valueOf(hour);
                hour = String.valueOf((h + 12));

            }
        }
//        else {
//
//            if (hour.startsWith("0")){
//                hour = hour.substring(1);
//            }
//            Integer h = Integer.valueOf(hour) - 1;
//            hour = String.valueOf((h - 1));
//
//
//        }

        return hour + ":" + minute + ":" + second;
    }



}
