package easy;

public class TwoDArrayDS {


    /**
     * 2D Array - DS
     */
    static int hourglassSum(int[][] arr) {

        int max = arr[0][0] + arr[0][1] + arr[0][2] + arr[1][1] + arr[2][0] + arr[2][1] + arr[2][2];;

        int rows = arr.length;
        int columns = arr[0].length;

        for (int i = 1; i < rows - 1; i++){

            for (int j = 1; j < columns - 1; j++){

                int sum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i][j] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];

                max = sum >= max ? sum : max;

            }
        }

        return max;

    }

}
