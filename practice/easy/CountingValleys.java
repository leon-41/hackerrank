package easy;

public class CountingValleys {

    static int countingValleys(int n, String s) {

        int num = 0;
        int seaLevel = 0;
        for (int i = 0; i < n; i++){

            int preSeaLevel = seaLevel;

            char c = s.charAt(i);

            if (c == 'U'){

                seaLevel ++;
                if (seaLevel == 0 && preSeaLevel == -1){
                    num ++;
                }

            }else if (c == 'D'){
                seaLevel --;

            }
        }

        return num;

    }


}
