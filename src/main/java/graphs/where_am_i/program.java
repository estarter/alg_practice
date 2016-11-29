package graphs.where_am_i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexey Merezhin
 */
public class program {

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] metrics = scanner.readLine().split(" ");
        int n = Integer.parseInt(metrics[0]);
        int m = Integer.parseInt(metrics[1]);
        int p = Integer.parseInt(metrics[2]);
        int q = Integer.parseInt(metrics[3]);

        String[] dest = scanner.readLine().split(" ");
        int x = Integer.parseInt(dest[0]);
        int y = Integer.parseInt(dest[1]);

        boolean[][] field = new boolean[n][];
        for (int i = 0; i < n; i++) {
            field[i] = new boolean[m];
            String row = scanner.readLine();
            for (int j = 0; j < m; j++) {
                field[i][j] = row.charAt(j) != '1';
            }
        }

        short[][] location = new short[p][];
        for (int i = 0; i < p; i++) {
            location[i] = new short[q];
            String row = scanner.readLine();
            for (int j = 0; j < q; j++) {
                location[i][j] = (short) (row.charAt(j) - '0');
            }
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(field[i]));
        // }
        // for (int i = 0; i < p; i++) {
        //     System.out.println(Arrays.toString(location[i]));
        // }

        int[][] startPosition = locateStart(field, location);
        if (startPosition.length == 0) {
            System.out.println("-1");
            return;
        }

        int length = pathLenght(startPosition, x-1, y-1, field);
        System.out.println(length);
    }

    static int[][] locateStart(boolean[][] field, short[][] location) {
        List<int[]> results = new ArrayList<>();
        for (int i = 0; i < field.length - location.length; i++) {
            for (int j = 0; j < field[0].length - location[0].length; j++) {

                boolean stop = false;
                int[] coordinates = new int[2];
                for (int ii = 0; ii < location.length && !stop; ii++) {
                    for (int jj = 0; jj < location[0].length; jj++) {
                        if (field[i + ii][j + jj] != (location[ii][jj] != 1)) {
                            stop = true;
                            continue;
                        }
                        if (location[ii][jj] == 2) {
                            coordinates[0] = ii;
                            coordinates[1] = jj;
                        }
                    }
                }
                if (!stop) {
                    results.add(coordinates);
                }
            }
        }
        return results.toArray(new int[0][]);
    }

    static int pathLenght(int[][] startPositions, int x1, int y1, boolean[][] field) {
        int[][] pathField = new int[field.length][];
        for (int i = 0; i < field.length; i++) {
            pathField[i] = new int[field[0].length];
        }

        pathField[x1][y1] = 1;

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x1, y1});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            addToQueue(pos[0]-1, pos[1], field, pathField, queue, pathField[pos[0]][pos[1]]);
            addToQueue(pos[0]+1, pos[1], field, pathField, queue, pathField[pos[0]][pos[1]]);
            addToQueue(pos[0], pos[1]-1, field, pathField, queue, pathField[pos[0]][pos[1]]);
            addToQueue(pos[0], pos[1]+1, field, pathField, queue, pathField[pos[0]][pos[1]]);

            // System.out.println(Arrays.toString(pos));
            // for (int i = 0; i < pathField.length; i++) {
            //     System.out.println(Arrays.toString(pathField[i]));
            // }
            // System.out.println();
        }

        int maxLength = Integer.MIN_VALUE;
        for (int[] pos : startPositions) {
            if (pathField[pos[0]][pos[1]] == 0) {
                return -2;
            }
            maxLength = Math.max(pathField[pos[0]][pos[1]], maxLength);
        }
        return maxLength-1;
    }

    static void addToQueue(int x, int y, boolean[][] field, int[][] pathField, LinkedList<int[]> queue, int length) {
        if (x < 0 || y < 0) return;
        if (x >= field.length || y >= field[0].length) return;
        if (!field[x][y]) return;
        if (pathField[x][y] != 0) return;
        queue.add(new int[]{x, y});
        pathField[x][y] = length + 1;
    }

}
