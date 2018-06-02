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
import java.io.*;
public class Main {

        //Matriz en donde se va a guardar
	static int[][] P;
        //Numero de filas y columnas
	static final int N = 4;

	public static void main(String[] args) throws FileNotFoundException, IOException {
            int[][] M = { { 1000, 5}, { 50, 32} };
            int[][] matriz = new int[N][N];
                
            File grafo = new File("src/Hoja11/guategrafo.txt");
            FileReader read = new FileReader(grafo);
            BufferedReader buff = new BufferedReader(read);
            
            String line;        
        
            while((line = buff.readLine()) != null){
                String linea = line.replaceAll("\\n", ", ");
                String[] separate = linea.split(", ");
                int j = 0;
                for(int i = 0; i < N; i ++){                    
                    for(int k = 0; k < N; k++){                        
                        matriz[i][k] = Integer.parseInt(separate[j]);
                        j++;
                    }                    
                }
            }
            
                
            P = new int[N][N];
            System.out.println("Matriz de adyacencia");
            printMatrix(matriz);
            System.out.println("Matriz reducida");
            printMatrix(Floyd(matriz));
		
	}

        //Algoritmo de FLoyd
	public static int[][] Floyd(int[][] M) {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					M[i][j] = Math.min(M[i][j], M[i][k] + M[k][j]);
				}
			}
		}
		return M;
	}
        
        
        //Imprimiendo la matriz que se dio
	public static void printMatrix(int[][] Matrix) {
		System.out.print("\n\t");
		for (int j = 0; j < N; j++) {
			System.out.print("    Ciudad: " + j + "\t");
		}
		System.out.println();
		for (int j = 0; j < 35; j++) {
			System.out.print("--");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print("Ciudad: " + i + " |\t");
			for (int j = 0; j < N; j++) {
				System.out.print(Matrix[i][j]);
				System.out.print("\t");
                                System.out.print("\t");
			}
			System.out.println("\n");
		}
		System.out.println("\n");
	}

}
