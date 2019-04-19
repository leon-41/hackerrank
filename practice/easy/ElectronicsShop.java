package easy;

public class ElectronicsShop {


    /**
     * Electronics Shop
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        int moneySpent = -1;

        for (int keyboard : keyboards){

            for (int drive : drives){

                int spent = keyboard + drive;

                if (spent <= b){
                    moneySpent = spent > moneySpent ? spent : moneySpent;
                }

            }

        }

        return moneySpent;

    }

}
