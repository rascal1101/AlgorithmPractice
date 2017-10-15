package baekjun;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] score = new int[N];
		int[][] step = new int[2][N];
		
		for(int i=0;i<N;i++) {
			score[i] = scanner.nextInt();
		}
		if(N==1)
			System.out.println(score[0]);
		else if(N==2)
			System.out.println(score[0]+score[1]);
		else {
			step[0][0] = score[0];
			step[1][0] = 0;
			step[0][1] = score[0] + score[1];
			step[1][1] = score[1];
			for(int j=2;j<N;j++) {
				step[0][j] = score[j] + step[1][j-1];
				step[1][j] = score[j] + Math.max(step[0][j-2],step[1][j-2]);
			}
			System.out.println(Math.max(step[0][N-1], step[1][N-1]));
		}
	}
}
