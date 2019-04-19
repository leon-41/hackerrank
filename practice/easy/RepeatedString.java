package easy;

public class RepeatedString {


    /**
     *  Repeated String
     */
    static long repeatedString(String s, long n) {

        long num = 0;

        int len = s.length();

        long over = n % len;
        long loop = n/len;

        int base = 0;
        int round = 0;
        for (int i = 0; i < len; i ++){

            if(s.charAt(i) == 'a'){
                base ++;

                if (i < over){
                    round ++;
                }
            }
        }

        num = base * loop + round;

        return num;

    }


}
