package easy;

import java.util.ArrayList;
import java.util.List;

public class CompareTheTriplets {

    /**
     * Compare the Triplets
     */
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {


        int alice = 0;
        int bob = 0;
        for (int i = 0; i < a.size(); i++){

            if (a.get(i) > b.get(i)){
                alice ++;
            }

            if (a.get(i) < b.get(i)){
                bob ++;
            }

        }

        List<Integer> result = new ArrayList<>();
        result.add(alice);
        result.add(bob);
        return result;
    }

}
