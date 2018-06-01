/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hoja11;

/**
 *
 * @author Andres
 */

import java.util.*;
import java.math.*;
public class Main {

	static int[][] P;
	static final int N = 2;

	public static void main(String[] args) {
		int[][] M = { { 1000, 5}, { 50, 32} };
		P = new int[N][N];
		System.out.println("Matrix to find the shortest path of.");
		printMatrix(M);
		System.out.println("Shortest Path Matrix.");
		printMatrix(FloydAlgo(M));
		
	}

	public static int[][] FloydAlgo(int[][] M) {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					M[i][j] = Math.min(M[i][j], M[i][k] + M[k][j]);
				}
			}
		}
                System.out.println(Arrays.toString(M));
		return M;
	}

	public static void printMatrix(int[][] Matrix) {
		System.out.print("\n\t");
		for (int j = 0; j < N; j++) {
			System.out.print(j + "\t");
		}
		System.out.println();
		for (int j = 0; j < 35; j++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print(i + " |\t");
			for (int j = 0; j < N; j++) {
				System.out.print(Matrix[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		System.out.println("\n");
	}

}
