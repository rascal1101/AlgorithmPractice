package baekjun;

import java.util.Scanner;

public class Main {
	public static int getMin(int a, int b) {
		return a>b?b:a;
	}
	public static int getMin3(int a, int b, int c) {
		return a>b?(b>c?c:b):(a>c?c:a);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[][] RGB = new int[N][3];
		int[][] cost = new int[3][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				RGB[i][j] = scanner.nextInt();
			}
		}
		cost[0][0]=RGB[0][0];
		cost[1][0]=RGB[0][1];
		cost[2][0]=RGB[0][2];
		
		for(int i=1;i<N;i++) {	
			cost[0][i] = RGB[i][0] + getMin(cost[1][i-1],cost[2][i-1]);
			cost[1][i] = RGB[i][1] + getMin(cost[0][i-1],cost[2][i-1]);
			cost[2][i] = RGB[i][2] + getMin(cost[0][i-1],cost[1][i-1]);
		}
		
		
		System.out.println(getMin3(cost[0][N-1],cost[1][N-1],cost[2][N-1]));

	}
}
