package ro.calin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//	Ex1 ex1 = new Ex1(sc);
//	ex1.Ex1Array(sc);
//	ex1.Ex1ArrayList(sc);



		///////////////////////////////EX2/////////////////////////////////


		int[][] matrix1 = new int[3][3];
		int[][] matrix2 = new int[3][3];
		int[][] matrix3 = new int[2][3];
		int[][] matrix4 = new int[3][2];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix1[i][j] = 2;
				matrix2[i][j] = 1;
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				matrix3[j][i] = i + 1;
				matrix4[i][j] = i + 2;
			}
		}


		Ex2 ex2 = new Ex2();
		Ex2.adunare(matrix1,matrix2);
		Ex2.scadere(matrix2,matrix1);
		Ex2.inmultireScalar(2,matrix1);
		Ex2.inmultire(matrix4,matrix3);


		//////////////////////////ciur///////////////////////

//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		for (int i = 0; i < 120; i++) {
//			arr.add(i + 1);
//		}
//		Ciur.ciurE(arr);

//		MatriceSerpuita.matriceSerpuitaDescOriz();
//		MatriceSerpuita.matriceSerpuitaCrescVertical();

//		goldMiners.goldMiners();

		//ExtraMile.matriceSpiralata();
		//ExtraMile.matriceSpiralataboolean();

    }
}
