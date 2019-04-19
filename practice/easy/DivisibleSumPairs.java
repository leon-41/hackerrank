package easy;

import java.util.HashMap;
import java.util.Map;

public class DivisibleSumPairs {


    public static void main(String[] args) {
        divisibleSumPairs(5, 2, new int[]{5,9,10,7,4});
    }

    static int divisibleSumPairs(int n, int k, int[] ar) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int r = ar[i] % k;
            if (map.containsKey(r)){
                map.put(r, map.get(r) +1);
            }else {
                map.put(r, 1);
            }
        }

        int result = 0;
        int round = k/2;
        for (int i = 0; i <= round; i++) {

            if (!map.containsKey(i)){
                continue;
            }

            int count = map.get(i);
            if (i == 0){
                result += count * (count -1) /2;
            } else {

                int pair = k - i;
                if (map.containsKey(pair) && i != pair){
                    int pairCount = map.get(pair);
                    result += pairCount * count;
                }
                if (k / pair == 2){
                    result += count * (count -1) /2;
                }

            }
        }
        return result;
    }


}
