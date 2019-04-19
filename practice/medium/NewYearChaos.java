package medium;

public class NewYearChaos {


    /**
     * New Year Chaos
     */
    static void minimumBribes(int[] q) {

        int len = q.length;
        int bribes = 0;
        boolean chaos = false;
        for (int i = len - 1; i > 0; i--){

            int pos = i + 1;

            int ele = q[i];
            int preOne = q[ i - 1 ];
            int preTwo = 0;
            if (i >= 2){
                preTwo = q[ i - 2 ];
            }

            int diff = ele - pos;
            if (diff == 0){
                continue;
            }

            if (preOne == pos){
                bribes ++;
                int temp = ele;
                q[i] = preOne;
                q[i-1] = ele;
            }else if (preTwo == pos){
                bribes += 2;
                int temp = ele;
                q[i] = preTwo;
                q[i-1] = ele;
                q[i-2] = preOne;
            } else {
                chaos = true;
                break;
            }
        }

        if (chaos){
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribes);
        }

    }
}
