package ro.calin;

import java.util.Random;

public class MatriceSerpuita {
    private static Random random = new Random();

    public static void matriceSerpuitaDescOriz() {
        int m = random.nextInt(7) + 3;
        int n = random.nextInt(7) + 3;

        int[][] matrix = new int[n][m];
        int value = 1;
        boolean changeDirection = false;
        for (int i = 0; i < n; i++) {
            changeDirection = !changeDirection;
            for (int j = 0; j < m; j++) {
                if(changeDirection) {
                    matrix[n - i - 1][j] = value++;
                } else {
                    matrix[n - i - 1][m - j - 1] = value++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void matriceSerpuitaCrescVertical() {
        int m = random.nextInt(7) + 3;
        int n = random.nextInt(7) + 3;

        int[][] matrix = new int[n][m];
        int value = 1;
        boolean changeDirection = false;
        for (int j = 0; j < m; j++) {
            changeDirection = !changeDirection;
            for (int i = 0; i < n; i++) {
                if(changeDirection) {
                    matrix[i][j] = value++;
                } else {
                    matrix[n - i - 1][j] = value++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
