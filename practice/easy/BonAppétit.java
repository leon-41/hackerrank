package easy;

import java.util.List;

public class BonAppétit {


    static void bonAppetit(List<Integer> bill, int k, int b) {

        int sum = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (i == k){
                continue;
            }
            sum += bill.get(i);
        }
        int s = sum / 2;
        if (s == b){
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - s);
        }
    }

}
