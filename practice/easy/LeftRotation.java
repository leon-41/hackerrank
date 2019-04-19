package easy;

public class LeftRotation {


    /**
     * Left rotation
     */
    static int[] rotLeft(int[] a, int d) {

        int len = a.length;
        int[] b = new int[len];
        int p = len - 1 - d;
        for (int i = 0; i < len; i ++){
            if (i < p){
                b[i]= a[i+d];
            } else {
                b[i] = a[i-p];
            }
        }

        return b;

    }



}
