package medium;

public class FairRations {

    /**
     * Fair Rations
     * 测试用例20 写得有问题，题目中说没有结果输出 "NO"，这个用例期望输出 "0"
     */
    static int fairRations(int[] B) {

        /**
         * 加一次要么奇数 -2 要么奇数 -0 （一边加1，一边-1）
         */
        int result = 0;

        int len = B.length;
        int odd = 0;
        int[] index = new int[1000000000];
        for (int i = 0; i < len; i++){
            int re = B[i] % 2;
            if (re != 0){
                index[odd] = i;
                odd ++;
            }
        }

        if (odd % 2 != 0){
            System.out.println("NO");
            return result;
        }

        for (int j = 0; j < index.length; j++){

            if (j % 2 != 0){
                continue;
            }
            int start = index[j];
            int end = index[j+1];

            result += 2 * (end - start);
        }

        return result;
    }

}
