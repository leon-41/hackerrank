package easy;

public class AppendAndDelete {


    public static String appendAndDelete(String s, String t, int k) {

        String result = "Yes";
        int sourceLen = s.length();
        int targetLen = t.length();

        int start = -1;
        int change = 0;
        for (int i = 0; i < s.length(); i++){

            if (i + 1 ==  targetLen){
                start = i;
                break;
            }
            if (s.charAt(i) != t.charAt(i)){
                start = i;
                break;
            }
        }
        if (start == -1){
            change = targetLen - sourceLen;
            if ((k - change) % 2 != 0){
                result = "No";
            }
        } else {
            change = sourceLen + targetLen - 2 * start;
            if (k < change){
                result = "No";
            }
        }

        return result;

    }





}
