package medium;

public class StrangeCounter {



    /**
     * Strange Counter
     */
    static long strangeCounter(long t) {

        long s = ((t-1)/3) + 1;

        long round = (long) (Math.log(s) / Math.log(2));

        long base = ((long) Math.pow(2, round) - 1) * 3;

        long max = base + 3;

        long diff = t - base - 1;

        //better solution
        long n = 1;
        while (3 * (n - 1) < t){
            n = 2 * n;
        }
        long result = 3 * (n - 1) - t + 1;

        return max - diff;

    }




}
