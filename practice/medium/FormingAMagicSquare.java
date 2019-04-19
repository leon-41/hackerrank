package medium;

import java.util.HashMap;
import java.util.Map;

public class FormingAMagicSquare {


    /**
     * Forming a Magic Square
     */
    static int formingMagicSquare(int[][] s) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] have = new int[100];
        int result = 0;
        int index = 0;
        for (int i = 0; i < s.length; i++){
            for (int j = 0; j < s[i].length; j++){
                int ele = s[i][j];
                if (map.containsKey(ele)){
                    have[index++] = ele;
                } else {
                    map.put(ele, 1);
                }
            }
        }

        insertSortion(have);

        int[] miss = new int[100];
        index = 0;
        int len = s.length * s.length;
        for (int k = 1; k <= len; k++){
            if (!map.containsKey(k)){
                miss[index++] = k;
            }
        }
        insertSortion(miss);

        for (int i=0; i < have.length; i++){
            int h = have[i];
            int m = miss[i];
            if (h > m){
                result += h-m;
            } else {
                result += m-h;
            }
        }
        return result;

    }



    private static void insertSortion(int[] A) {

        int n = A.length;
        for(int i = 0; i < n; i ++){
            int min = A[i];
            int minIndex = i;
            for(int j = i; j < n; j++){
                if(A[j] < min){
                    min = A[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){

                int temp = A[i];
                A[i] = A[minIndex];
                A[minIndex] = temp;
            }
        }

    }

}
