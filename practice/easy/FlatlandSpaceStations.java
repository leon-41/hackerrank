package easy;


/**
 * Flatland Space Stations
 */
public class FlatlandSpaceStations {


    static int flatlandSpaceStations(int n, int[] c) {

        int max = 0;
        for (int i = 0; i < n; i++) {

            int min = n;
            for (int ele : c){
                int distance = ele - i >= 0 ? ele - i : i - ele;
                if (min > distance){
                    min = distance;
                }
            }
            if (min > max){
                max = min;
            }

        }
        return max;

    }




}
