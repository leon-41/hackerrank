package medium;

public class AlmostSorted {






    /**
     * Almost Sorted
     */
    static void almostSorted(int[] arr) {

        int len = arr.length;

        int start = arr[0];
        int end = arr[len - 1];


        int peek =  -1;
        int vally = -1;
        int count = 0;
        for (int i = 1; i < len - 1; i++) {

            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]){
                peek = i;
                count ++;
            }

            if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]){
                vally = i;
                count ++;
            }
        }

        if (count == 0){
            if (start <= end){
                System.out.println("no");
            } else {

                System.out.println("yes");
                if (len == 2){
                    System.out.println(String.format("swap %s %s", 1, 2));
                } else {
                    System.out.println(String.format("reverse %s %s", 1, len));
                }
            }
        }

        if (count == 1){
            if (peek > -1){
                int beforePeek = arr[peek - 1];
                if (end < beforePeek){
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                    if (len - 1 - peek == 1){
                        System.out.println(String.format("swap %s %s", peek+1, len));
                    } else {
                        System.out.println(String.format("reverse %s %s", peek+1, len));
                    }
                }

            } else if (vally > -1){

                int afterVally = arr[vally + 1];
                if (start > afterVally){
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                    if (vally == 1){
                        System.out.println(String.format("swap %s %s", 1, 2));
                    } else {
                        System.out.println(String.format("reverse %s %s", 1, vally+1));
                    }
                }

            }


        }
        else if (count == 2){

            if (peek < vally){

                if (start < end && arr[peek - 1] < arr[vally] && arr[peek] < arr[vally + 1]){

                    System.out.println("yes");
                    if (vally - peek == 1){
                        System.out.println(String.format("swap %s %s", peek+1, vally+1));
                    } else {
                        System.out.println(String.format("reverse %s %s", peek+1, vally+1));
                    }

                } else {
                    System.out.println("no");
                }

            } else {

                System.out.println("no");

            }


        }

        else if (count == 3){
            System.out.println("no");
        } else if (count == 4){


        }

    }


}
