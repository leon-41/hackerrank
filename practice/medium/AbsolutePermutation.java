package medium;

import java.util.HashSet;
import java.util.Set;

public class AbsolutePermutation {


    static int[] absolutePermutation(int n, int k) {

        int[] result = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++){
            int ele = i;
            int min = ele - k;
            int max = ele + k;

            if (min < 1 && max <= n){
                if (!set.contains(max)){
                    set.add(max);
                    result[i -1]= max;
                }
            }

            if (min >= 1 && max <= n){
                if (!set.contains(min)){
                    set.add(min);
                    result[i -1]= min;
                } else if (!set.contains(max)){
                    set.add(max);
                    result[i -1]= max;
                }
            }

            if (min >= 1 && max > n){
                if (!set.contains(min)){
                    set.add(min);
                    result[i -1]= min;
                }
            }
        }

        for (int i = 0; i < n; i++) {

            if (result[i] == 0){
                result = new int[]{-1};
                break;
            }

        }
        return result;
    }

}
