package easy;

import java.util.HashMap;
import java.util.Map;

public class CutTheSticks {

    static int[] cutTheSticks(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int ele : arr){
            if (map.containsKey(ele)){
                map.put(ele, map.get(ele).intValue()+1);
            } else {
                map.put(ele, 1);
            }
        }

        int[] result = new int[map.size()];

        int index = 0;
        while (!map.isEmpty()){

            int min = 2000000000;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                int key = entry.getKey();
                if (min > key){
                    min = key;
                }
            }

            int count = 0;
            Map<Integer, Integer> newMap = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){

                int key = entry.getKey();
                int value = entry.getValue();

                int afterKey = key - min;
                count += value;
                if (key == min){
                    continue;
                }
                newMap.put(afterKey, value);

            }
            result[index] = count;
            index ++;
            map = newMap;
        }
        return result;

    }

}
