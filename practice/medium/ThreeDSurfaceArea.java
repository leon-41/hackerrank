package medium;

public class ThreeDSurfaceArea {


    static int surfaceArea(int[][] A) {

        int x = A.length;
        int y = A[0].length;

        int result = 0;
        for (int i = 0; i < x; i++) {

            for (int j = 0; j < y; j++) {

                int ele = A[i][j];
                int base = 4 * ele + 2;

                if (i - 1 > -1){
                    int next = A[i-1][j];
                    if (next < ele){
                        base -= next;
                    } else {
                        base -= ele;
                    }
                }

                if (i + 1 > -1 && i + 1 < x){
                    int next = A[i+1][j];
                    if (next < ele){
                        base -= next;
                    } else {
                        base -= ele;
                    }
                }

                if (j - 1 > -1){
                    int next = A[i][j-1];
                    if (next < ele){
                        base -= next;
                    } else {
                        base -= ele;
                    }
                }

                if (j + 1 > -1 && j + 1 < y){
                    int next = A[i][j+1];
                    if (next < ele){
                        base -= next;
                    } else {
                        base -= ele;
                    }
                }
                result += base;
            }
        }

        return result;
    }




}
