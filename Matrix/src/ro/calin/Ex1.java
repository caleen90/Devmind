package ro.calin;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1 {
    private Scanner sc ;
    private int matrixDimension;
    private int mainDiagValue;
    private int sndDiagValue;
    private int centerValue;
    private int leftValue;
    private int upValue;
    private int rightValue;
    private int bottomValue;

    public Ex1(Scanner sc) {
        this.sc = sc;
    }
    public  void Ex1Array(Scanner sc) {
        citireValori(sc);
        int[][] matrix = new int[this.matrixDimension][this.matrixDimension];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    matrix[i][j] = this.mainDiagValue;
                }
                if (i + j == this.matrixDimension - 1) {
                    matrix[i][j] = this.sndDiagValue;
                }
                if (this.matrixDimension % 2 == 1 && i == this.matrixDimension / 2 && j == this.matrixDimension / 2) {
                    matrix[i][j] = this.centerValue;
                }
                if (i > j && i + j < this.matrixDimension - 1) {
                    matrix[i][j] = this.leftValue;
                }
                if (i < j && i + j < this.matrixDimension - 1) {
                    matrix[i][j] = this.upValue;
                }
                if (i < j && i + j > this.matrixDimension - 1) {
                    matrix[i][j] = this.rightValue;
                }
                if (i > j && i + j > this.matrixDimension - 1) {
                    matrix[i][j] = this.bottomValue;
                }
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public  void Ex1ArrayList(Scanner sc) {
        citireValori(sc);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>(this.matrixDimension);
        for (int i = 0; i < this.matrixDimension; i++) {
            ArrayList<Integer> newRow = new ArrayList<Integer>(this.matrixDimension);
            matrix.add(newRow);
            for (int j = 0; j < this.matrixDimension; j++) {
                if (this.matrixDimension % 2 == 1 && i == this.matrixDimension / 2 && j == this.matrixDimension / 2) {
                    matrix.get(i).add(this.centerValue);
                    System.out.print(matrix.get(i).get(j) + "\t");
                    continue;
                }
                if (i == j) {
                    matrix.get(i).add(this.mainDiagValue);
                }
                if (i + j == this.matrixDimension - 1) {
                    matrix.get(i).add(this.sndDiagValue);
                }
                if (i > j && i + j < this.matrixDimension - 1) {
                    matrix.get(i).add(this.leftValue);
                }
                if (i < j && i + j < this.matrixDimension - 1) {
                    matrix.get(i).add(this.upValue);
                }
                if (i < j && i + j > this.matrixDimension - 1) {
                    matrix.get(i).add(this.rightValue);
                }
                if (i > j && i + j > this.matrixDimension - 1) {
                    matrix.get(i).add(this.bottomValue);
                }
                System.out.print(matrix.get(i).get(j) + "\t");
            }
            System.out.println();
        }

    }

    private void citireValori(Scanner sc) {
        System.out.println("Introduceti dimensiunea matricei");
        this.matrixDimension = sc.nextInt();
        System.out.println("Introduceti valoarea elementelor de pe diagonala principala");
        this.mainDiagValue = sc.nextInt();
        System.out.println("Introduceti valoarea elementelor de pe diagonala secundara");
        this.sndDiagValue = sc.nextInt();
        if(this.matrixDimension % 2 == 1) {
            System.out.println("Introduceti valoarea elementului central");
            this.centerValue = sc.nextInt();
        }
        System.out.println("Introduceti valoarea elementelor din cadranul stanga");
        this.leftValue = sc.nextInt();
        System.out.println("Introduceti valoarea elementelor din cadranul superior");
        this.upValue = sc.nextInt();
        System.out.println("Introduceti valoarea elementelor din cadranul dreapta");
        this.rightValue = sc.nextInt();
        System.out.println("Introduceti valoarea elementelor din cadranul jos");
        this.bottomValue = sc.nextInt();
    }


}
