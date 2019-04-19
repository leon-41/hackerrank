package easy;

public class CatsAndAMouse {


    static String catAndMouse(int x, int y, int z) {
        String result = "";
        int a = x - z >= 0 ? x - z : z - x;
        int b = y - z >= 0 ? y - z : z - y;

        if (a < b){
            result = "Cat A";
        } else if (a == b){
            result = "Mouse C";
        } else if (a > b){
            result = "Cat B";
        }
        return result;
    }

}
