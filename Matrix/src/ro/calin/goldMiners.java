package ro.calin;

public class goldMiners {
    public static void goldMiners() {
        int[][] matrix = {{3,14,100,21},{1,23,3,5},{6,1,4,9}, {16,41,55,901}, {2,70,26,101}};
        int[][] matrix2 = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        int[] dirx = {-1,-1,0,1,1, 1, 0,-1};
        int[] diry = { 0, 1,1,1,0,-1,-1,-1};
        int[] vecini = {5,4,3,1,5,3,5,6};
        int x = 0;
        int y = 0;
        int points = matrix[x][y];
        int max = 0;

        for (int i = 0; i < vecini.length; i++) {
            matrix[x][y] = 0;
            matrix2[x][y]++;
            if(matrix2[x][y] > max) {
                max = matrix2[x][y];
            }
            x += dirx[vecini[i] - 1];
            y += diry[vecini[i] - 1];
            points += matrix[x][y];
        }

        matrix[x][y] = 0;
        matrix2[x][y]++;

        System.out.println("Puncte adunate: " + points);
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                if(matrix2[i][j] == max) {
                    System.out.println("(" + i + ", " + j + ") a fost parcurs de " + max + " ori");
                }

            }
        }

    }
}
