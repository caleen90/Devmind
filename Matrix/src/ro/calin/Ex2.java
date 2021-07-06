package ro.calin;

public class Ex2 {
    public static void adunare(int[][] matrixA, int[][] matrixB) {
        int[][] result = new int[matrixA.length][matrixA.length];
        for(int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];

            }
        }
        afisare(matrixA,matrixB,result);


    }

    public static void scadere(int[][] matrixA, int[][] matrixB) {
        int[][] result = new int[matrixA.length][matrixA.length];
        for(int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];

            }
        }
        afisare(matrixA,matrixB,result);
    }

    public static void inmultire(int[][] matrixA, int[][] matrixB) {
        if (matrixA[0].length == matrixB.length) {
            int[][] result = new int[matrixA.length][matrixB[0].length];
            for(int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < matrixA[i].length; k++) {
                        result[i][j] += matrixA[i][k] * matrixB[k][j] ;
                    }
                }
            }
            afisare(matrixA,matrixB,result);
        } else {
            System.out.println("Matricile nu se pot inmultii");
        }

    }

    public static void inmultireScalar(int scalar, int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[i][j] * scalar;

            }
        }
        afisare(matrix,scalar,result);
    }

    public static void afisare(int[][] matrix1, int[][] matrix2, int[][] result) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("result: ");
        System.out.println();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void afisare(int[][] matrix1,int scalar, int[][] result) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("x " + scalar);
        System.out.println();
        System.out.println("result: ");
        System.out.println();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
