package easy;

public class LisasWorkbook {

    public static void main(String[] args) {
        workbook(10,5, new int[]{3,8,15,11,14,1,9,2,24,31});
    }

    static int workbook(int n, int k, int[] arr) {

        int count = 0;
        int page = 1;
        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            int d = ele / k;
            int r = ele % k;

            for (int j = 1; j <= d; j++){
                int min = (j - 1) *  k + 1;
                int max = j *  k;
                if (min <= page && page <= max){
                    count ++;
                }
                page ++;
            }

            if (r != 0){
                int min = ele - r + 1;
                int max = ele;
                if (min <= page && page <= max){
                    count ++;
                }
                page ++;
            }
        }
        return count;
    }

}
