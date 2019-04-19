package hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Matrix Layer Rotation
 */
public class MatrixLayerRotation {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }


    static void matrixRotation(List<List<Integer>> matrix, int r) {

        int line = matrix.size();
        int column = matrix.get(0).size();
        int[][] mtx = new int[line][column];
        for (int i = 0; i < line; i++) {
            List<Integer> list = matrix.get(i);
            for (int j = 0; j < column; j++) {
                mtx[i][j] = list.get(j);
            }
        }

        int[][] rotation = new int[line][column];
        for (int i = 0; i < line; i++) {

            int yMin = i < line - i - 1 ? i : line - i - 1;

            for (int j = 0; j < column; j++) {
                int ele = mtx[i][j];

                int xMin = j < column - j -1 ? j : column - j - 1;
                int min = xMin < yMin ? xMin : yMin;

                int xMove = column - 2 * min;
                int yMove = line - 2 * min;

                int xLeft = min;
                int xRight = column - xLeft -1;
                int yUp = min;
                int yDown = line - yUp - 1;

                int x = j;
                int y = i;

                int mode = 0;
                if (y == yUp && x != xLeft){
                    mode = 1;
                }
                if (y != yDown && x == xLeft){
                    mode = 2;
                }
                if (y == yDown && x != xRight){
                    mode = 3;
                }
                if (y != yUp && x == xRight){
                    mode = 4;
                }

                int remain = r;
                int move = 0;
                while (remain > 0){

                    switch (mode){
                        case 1:
                            move = xMove <= remain ? x - xMove : remain;
                            x = x - move;
                            remain -= move;
                            mode = 2;
                            break;

                        case 2:
                            move = yMove <= remain ? yMove : remain;
                            y = y +  move;
                            remain -= move;
                            mode = 3;
                            break;

                        case 3:
                            move = xMove <= remain ? xMove : remain;
                            x = x + move;
                            remain -= move;
                            mode = 4;
                            break;

                        case 4:
                            move = yMove <= remain ? yMove : remain;
                            y = y - move;
                            remain -= move;
                            mode = 1;
                            break;
                    }

                }
                rotation[y][x] = ele;
            }
        }



        for (int i = 0; i < line; i++) {
            int[] arr = rotation[i];
            for (int j = 0; j < column; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }


}
