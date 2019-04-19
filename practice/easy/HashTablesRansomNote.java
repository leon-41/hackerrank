package easy;

import java.util.HashMap;
import java.util.Map;

public class HashTablesRansomNote {


    /**
     * Hash Tables: Ransom Note
     */
    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> noteMap = new HashMap<>();
        Map<String, Integer> magazineMap = new HashMap<>();

        for (String n : note){

            for (String ch : n.split("[^a-zA-Z]+")){
                if (noteMap.containsKey(ch)){
                    noteMap.put(n, noteMap.get(n) + 1);
                }else {
                    noteMap.put(n, 1);
                }
            }
        }


        for (String m : magazine){
            for (String ch : m.split("[^a-zA-Z]+")){
                if (magazineMap.containsKey(ch)){
                    magazineMap.put(m, magazineMap.get(m) + 1);
                }else {
                    magazineMap.put(m, 1);
                }
            }
        }


        boolean match = true;
        for (Map.Entry<String, Integer> item : noteMap.entrySet()){

            String key = item.getKey();
            Integer times = item.getValue();

            if (!magazineMap.containsKey(key) || magazineMap.get(key).intValue() < times){
                match = false;
                break;
            }
        }

        if (match){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }

}
