package easy;

public class PlusMinus {

    /**
     * Plus Minus
     */
    static void plusMinus(int[] arr) {

        int len = arr.length;
        int negtive = 0;
        int postive = 0;
        int zero = 0;
        for (int ele : arr){
            if(ele < 0 ){
                negtive++;
            }else if(ele == 0){
                zero++;
            }else {
                postive++;
            }
        }
        float f1 = (float)postive/len;
        float f2 = (float)negtive/len;
        float f3 = (float)zero/len;
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

    }


}
