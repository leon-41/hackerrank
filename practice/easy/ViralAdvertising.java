package easy;

public class ViralAdvertising {



    /**
     * Viral Advertising
     */
    static int viralAdvertising(int n) {

        int temp = 0;
        int answer = 0;
        for (int i = 1; i <= n; i++){
            if (i ==  1){
                temp = 2;
                answer = 2;
            } else {
                temp = (3 * temp) / 2;
                answer += temp;
            }
        }
        return answer;

    }
}
