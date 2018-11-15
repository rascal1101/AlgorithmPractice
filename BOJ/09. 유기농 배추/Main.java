package baekjun;

import java.util.Scanner;

public class Main {
	
	public static int[][][] matrix;
	public static int[][][] visit;
	public static int[] count;
	public static boolean isVisit = false;
	public static void travel(int T, int x, int y) {
		if(matrix[T][x][y] == 1 && visit[T][x][y] ==0) {
			visit[T][x][y]=1;
			isVisit = true;
			if(matrix[T][x-1][y] == 1 && visit[T][x-1][y] ==0) {
				travel(T,x-1,y);
			}if(matrix[T][x+1][y] == 1 && visit[T][x+1][y] ==0) {
				travel(T,x+1,y);
			}if(matrix[T][x][y-1] == 1 && visit[T][x][y-1] ==0) {
				travel(T,x,y-1);
			}if(matrix[T][x][y+1] == 1 && visit[T][x][y+1] ==0) {
				travel(T,x,y+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int[] M = new int[T];
		int[] N = new int[T];
		int[] K = new int[T];
		matrix = new int[T][][];
		visit = new int[T][][];
		count = new int[T];
		for(int i=0;i<T;i++) {
			M[i] = scanner.nextInt();
			N[i] = scanner.nextInt();
			K[i] = scanner.nextInt();
			matrix[i] = new int[M[i]+2][N[i]+2];
			visit[i] = new int[M[i]+2][N[i]+2];
			for(int j=0;j<K[i];j++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				matrix[i][x+1][y+1] = 1;
			}
		}
		
		for(int i=0;i<T;i++) {
			for(int j=1;j<=M[i];j++) {
				for(int k=1;k<=N[i];k++) {
					travel(i,j,k);
					if(isVisit) {
						count[i]++;
						isVisit=false;
					}
				}
			}
		}
		for(int i=0;i<T;i++) {
			System.out.println(count[i]);
		}
	}
}
