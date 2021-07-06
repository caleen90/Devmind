package ro.calin;

import java.util.Random;
import java.util.Scanner;

public class ExtraMile {

    private static Random random = new Random();

    public static void matriceSpiralataboolean(){
        int m = random.nextInt(7) + 3;
        int n = random.nextInt(7) + 3;
        int[][] matrix = new int[n][m];

        int rowMin = 0;
        int rowMax = n;
        int colMin = 0;
        int colMax = m - 1;
        int i = 0;
        int j = 0;
        boolean leftRight = true;
        boolean rightLeft = false;
        boolean upDown = false;
        boolean downUp = false;
        int value = 1;

        while(rowMin <= rowMax && colMin <= colMax) {
            if(leftRight) {
                for(j = colMin; j <= colMax; j++) {
                    matrix[i][j] = value++;
                }
                colMax--;
                leftRight = false;
                upDown = true;
                j--;
            }
            if(upDown){
                for (i = rowMin + 1; i < rowMax; i++) {
                    matrix[i][j] = value++;
                }
                upDown = false;
                rightLeft = true;
                rowMax--;
                i--;
            }
            if(rightLeft) {
                for (j = colMax; j > colMin - 1; j--) {
                    matrix[i][j] = value++;
                }
                rightLeft = false;
                downUp = true;
                colMin++;
                j++;
            }
            if(downUp) {
                for (i = rowMax - 1; i > rowMin ; i--) {
                    matrix[i][j] = value++;
                }
                downUp = false;
                leftRight = true;
                rowMin++;
                i++;
            }
        }

        for (int k = 0; k < matrix.length; k++) {
            for (int l = 0; l < matrix[k].length; l++) {
                System.out.print(matrix[k][l] + "\t");
            }
            System.out.println();
        }

    }


    public static void matriceSpiralata() {

        int m = random.nextInt(7) + 3;
        int n = random.nextInt(7) + 3;

        int[][] matrix = new int[n][m];
        int value = 1;
        int limitJ = 0;
        int limitI = 0;
        boolean start = true;
        int loopNo = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = 0;
            }
        }


        while(start) {
            System.out.println("loop");

            int i=limitI;
            int j;
            for (j = limitJ; j < m;j++) {
                if(matrix[i][j] != 0) {
                    start = false;
                } else {
                    matrix[i][j] = value++;
                }
            }
            j--;
            limitI++;

            for (i = limitI;i < n; i++) {
                if(matrix[i][j] != 0) {
                    start = false;
                } else {
                    matrix[i][j] = value++;
                }
            }
            i--;
            limitJ++;

            for (j = limitJ; j < m;j++) {
                if(matrix[i][m - j - 1 + loopNo] != 0) {
                    start = false;
                    break;
                } else {
                    matrix[i][m - j - 1 + loopNo] = value++;
                }
            }
            j = m - j + 1 - 1 + loopNo;
            n--;

            for (i = n - 1; i >= limitI; i--) {
                if(matrix[i][j] != 0) {
                    start = false;
                } else {
                    matrix[i][j] = value++;
                }
            }

            m--;
            loopNo++;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
