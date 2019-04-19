package medium;

public class Bonetrousle {


    /**
     * Bonetrousle
     */
//    static long[] bonetrousle(long n, long k, int b) {
//
//        //迭代
//
//        long[] result = new long[b];
//
//
//
//
//        return result;
//
//    }





    static long[] bonetrousle(long n, long k, int b) {

        long[] result = new long[b];
        recursion(n, k, b, result);
        if (result.length != b){
            result = new long[]{-1};
        }
        return result;

    }

    private static long[] recursion(long target, long total, int count, long[] result) {

        if (count <= 0){
            return null;
        }

        if (count == 1){

            if (target <= total){
                result[0] = target;
                return result;
            }

            return null;
        }

        if (target > 0){

            if (target < total){
                total = target;
            }

            int round = count -1;
            for (int i = 1; i < total; i++ ){

                try {
                    result[round] = i;
                    target = target - i;
                    recursion(target, total, count --, result);
                }catch (ArrayIndexOutOfBoundsException e){
                    int l = 5;
                }
            }
        }

        return result;
    }


}
