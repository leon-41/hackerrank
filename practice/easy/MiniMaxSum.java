package easy;

public class MiniMaxSum {


    /**
     * Mini-Max Sum
     */
    static void miniMaxSum(int[] arr) {
        int sum = 0;
        int min = arr[0];
        int max = arr[0];
        for(int ele : arr){
            sum += ele;
            if(ele < min){
                min = ele;
            }
            if(ele > max){
                max = ele;
            }
        }

        System.out.println((sum - max) + " " + (sum - min));

    }




}
