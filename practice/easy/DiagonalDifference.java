package easy;

public class DiagonalDifference {


    /**
     * Diagonal Difference
     */
    static int diagonalDifference(int[][] arr) {

        int x = arr.length;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < x; i++){
            sum1 += arr[i][i];
            sum2 += arr[x-1-i][i];
        }
        return sum1-sum2 > 0 ? sum1 - sum2 : sum2 - sum1;

    }

}
