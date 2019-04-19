package medium;

public class NonDivisibleSubset {

    /**
     * Non-Divisible Subset
     */
    static int nonDivisibleSubset(int k, int[] S) {
        int result = 0;
        int[] res = new int[k];
        for (int i = 0; i < S.length; i++) {
            int r = S[i] % k;
            if (r == 0 || 2 * r == k){
                res[r] = 1;
                continue;
            }
            res[r]++;
        }
        for (int i = 1; i < (k + 1)/2; i++){
            result += Math.max(res[i], res[k-i]);
        }

        if (res[0] == 1){
            result ++;
        }

        if (k % 2 == 0 && res[k/2] > 0){
            result ++;
        }

        return result;
    }


}
