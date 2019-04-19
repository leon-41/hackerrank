package easy;

public class Kangaroo {


    /**
     * Kangaroo
     */
    static String kangaroo(int x1, int v1, int x2, int v2) {

        String result = "NO";
        int distanceDiff = x1 - x2;
        int speedDiff = v1 - v2;
        if (distanceDiff == 0 && speedDiff == 0){
            result = "YES";
        }
        if (distanceDiff < 0 && speedDiff > 0 && distanceDiff + speedDiff <= 0){
            result = "YES";
        }
        if (distanceDiff > 0 && speedDiff < 0 && distanceDiff + speedDiff >= 0){
            result = "YES";
        }
        return result;

    }
}
