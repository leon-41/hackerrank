package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistances {


    static int minimumDistances(int[] a) {

        int len = a.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <= len; i++) {
            int ele = a[i];
            if (map.containsKey(ele)){
                List<Integer> indexes = map.get(ele);
                indexes.add(i);
                map.put(ele, indexes);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                map.put(ele, indexes);
            }
        }

        int min = -1;
        for (Integer key : map.keySet()){

            List<Integer> indexes = map.get(key);
            if (indexes.size() < 2){
                continue;
            }

            for (int i = 0; i < indexes.size() - 1; i++) {
                int distance = indexes.get(i+1) - indexes.get(i);

                if (min == -1){
                    min = distance;
                } else {
                    if (distance < min){
                        min = distance;
                    }
                }
            }
        }
        return min;

    }

}
