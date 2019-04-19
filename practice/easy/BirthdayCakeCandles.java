package easy;

public class BirthdayCakeCandles {

    /**
     * Birthday Cake Candles
     */
    static int birthdayCakeCandles(int[] ar) {

        int count = 1;
        int max = ar[0];
        for (int i = 1; i < ar.length; i++ ){

            if (ar[i] > max){
                max = ar[i];
                count = 1;
            }

            if (ar[i] == max){
                count++;
            }

        }
        return count;

    }


}
