package easy;

public class JumpingOnTheClouds {

    /**
     * Jumping on the Clouds
     */
    static int jumpingOnClouds(int[] c) {

        int jumps = 0;
        int len = c.length;
        for (int i = 0; i < len - 1; i++){

            if (i == len - 3 || i == len - 2){
                jumps ++;
                break;
            }

            int nextOne = c[i + 1];
            int nextTwo = c[i + 2];

            if (nextTwo == 0 || nextOne == 1){
                i = i + 1;
            }

            jumps ++;

        }

        jumps ++;


        if (len == 0){
            jumps = 0;
        }

        return jumps;

    }

}
