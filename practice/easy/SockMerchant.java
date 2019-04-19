package easy;

import java.util.HashMap;
import java.util.Map;

public class SockMerchant {


    static int sockMerchant(int n, int[] ar) {

        Map colorMap = new HashMap();

        for (int i = 0; i < n; i++){

            if (!colorMap.containsKey(ar[i])){
                colorMap.put(ar[i], 1);
            } else {

                colorMap.remove(ar[i]);

            }
        }

        return  colorMap.size();
    }

}
