package medium;

import java.util.HashSet;
import java.util.Set;

public class ManasaAndStones {

    /**
     * Manasa and Stones
     */
    static int[] stones(int n, int a, int b) {

        int total = n - 1;

        Set<Integer> set = new HashSet<>();


        for (int i = 0; i <= total; i++){
            int sum = a*i + b*(total- i);
            set.add(sum);
        }

        int[] A = new int[set.size()];
        int i = 0;
        for (int ele : set){
            A[i++] = ele;
        }
        insertSortion(A);

        return A;
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
