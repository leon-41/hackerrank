package easy;

public class ACMICPCTeam {

    public static void main(String[] args) {
        acmTeam(new String[]{"10101", "11100", "11010", "00101"});
    }


    static int[] acmTeam(String[] topic) {

        int len = topic.length;

        int max = 0;
        int pairs = 0;
        for (int i = 0; i < len; i++) {
            String a = topic[i];

            int size = a.length();
            for (int j = i + 1; j < len; j++) {
                String b = topic[j];
                int count = 0;
                for (int k = 0; k < size; k++) {
                    if (a.charAt(k) == '1' || b.charAt(k) == '1'){
                        count++;
                    }
                }
                if (count > max){
                    max = count;
                    pairs = 1;
                } else if (count == max){
                    pairs++;
                }
            }
        }

        int[] result = new int[]{max, pairs};
        return result;
    }

}
