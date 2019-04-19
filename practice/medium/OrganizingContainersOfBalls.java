package medium;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrganizingContainersOfBalls {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] container = new int[][]{{0,2},{1,1}};
        String result = organizingContainers(container);
    }


    static String organizingContainers(int[][] container) {

        String result = "Possible";
        int len = container.length;

        Map<Integer, Integer> conMap = new HashMap<>();
        Map<Integer, Integer> typeMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int con = 0;
            int type = 0;
            for (int j = 0; j < len; j++) {
                con += container[i][j];
                type += container[j][i];
            }

            if (conMap.containsKey(con)){
                conMap.put(con, conMap.get(con) + 1);
            } else {
                conMap.put(con, 1);
            }
            if (typeMap.containsKey(type)){
                typeMap.put(type, typeMap.get(type) + 1);
            } else {
                typeMap.put(type, 1);
            }
        }

        if (conMap.size() != typeMap.size()){
            result = "Impossible";
        } else {
            for (Integer conKey : conMap.keySet()) {
                if (!typeMap.containsKey(conKey)) {
                    result = "Impossible";
                } else {
                    Integer conValue = conMap.get(conKey);
                    Integer typeValue = typeMap.get(conKey);
                    if (conValue != typeValue){
                        result = "Impossible";
                    }
                }
            }
        }
        return result;
    }

}
