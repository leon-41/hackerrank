package medium;

public class CircularArrayRotation {





    /**
     * Circular Array Rotation
     */
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {

        int len = a.length;
        int move = k % len;

        int resultLen = queries.length;
        int[] result = new int[resultLen];
        for (int i = 0; i < resultLen; i++){

            int index = queries[i];
            if (index < move){
                result[i] = a[len - move + index];
            } else {
                result[i] = a[index - move];
            }
        }
        return result;
    }


}
