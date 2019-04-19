package medium;

public class LarrysArray {



    /**
     * Larry's Array
     */
    static String larrysArray(int[] A) {

        String result = "YES";

        int len = A.length;
        for (int i = 0; i < len; i++){

            int ele = A[i];
            int standard = i + 1;
            if (ele == standard){
                continue;
            }

            if (i == len - 2 && ele != standard){
                result = "NO";
                break;
            }

            int index = 0;
            for (int j = i; j < len; j++){
                if (A[j] == standard){
                    index = j;
                    continue;
                }
            }

            while (index != i){

                int diff = index - i;
                if (diff == 1){
                    rotation1(A, index - 1);
                    index += -1;
                } else if (diff > 1){
                    rotation2(A, index - 2);
                    index += -2;
                }
            }
        }



        return result;
    }

    private static void rotation2(int[] A, int i) {
        int temp = A[i];
        A[i] = A[i + 2];
        A[i + 2] = A[i + 1];
        A[i + 1] = temp;

    }

    private static void rotation1(int[] A, int i) {
        int temp = A[i];
        A[i] = A[i + 1];
        A[i + 1] = A[i + 2];
        A[i + 2] = temp;
    }

}
