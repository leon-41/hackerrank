package easy;

public class AppleAndOrange {


    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

        int apple = 0;
        int orange = 0;

        int aLen = apples.length;
        int bLen = oranges.length;
        for (int i = 0; i < aLen; i++) {
            int ele = apples[i];
            int index = a + ele;
            if ( s <= index && index <= t){
                apple++;
            }
        }
        for (int i = 0; i < bLen; i++) {
            int ele = oranges[i];
            int index = b + ele;
            if ( s <= index && index <= t){
                orange++;
            }
        }
        System.out.println(apple);
        System.out.println(orange);

    }

}
