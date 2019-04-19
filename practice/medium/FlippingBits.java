package medium;

public class FlippingBits {

    /**
     * Flipping bits
     */
    static long flippingBits(long n) {

        String s1= "";
        for(int i = 31;i >= 0; i--){
            s1 += (n >>> i & 1);
        }

        String s= "";
//        for (int i = 1; i <= 32; i++){
//            long temp = n >>> 1;
//
//            if (n == 1){
//                s = "1" + s;
//                n = temp;
//                continue;
//            }
//
//            if (temp != 0 && n % temp == 1){
//                s = "1" + s;
//            } else {
//                s = "0" + s;
//            }
//            n = temp;
//        }

        String[] arr = s.split("");

        long sum = 0;
        for (int i = 0; i < 32; i++){
            int ele = Integer.parseInt(arr[i]);
            if (ele == 1){
                long w = (long) Math.pow(2, 31-i);
                sum += w;
            }

        }

        for (int i = 0; i < 32; i++){
            int ele = Integer.parseInt(arr[i]);
            if (ele == 0){
                long w = (long) Math.pow(2, 31-i);
                sum += w;
            }

        }
        return sum;

    }

}
