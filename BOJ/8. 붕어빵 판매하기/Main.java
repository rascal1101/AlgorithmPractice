package baekjun;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] p = new int[N+1];
		int[] max = new int[N+1];
		for(int i=1;i<=N;i++) {
			p[i] = scanner.nextInt();
		}
		
		max[1] = p[1];
		for(int i=2;i<=N;i++) {
			max[i] = p[i];
			for(int j=1;j<i;j++) {
				if(max[i-j] + max[j] > max[i])
					max[i] = max[i-j] + max[j];
			}
		}
	
		System.out.println(max[N]);
	}
}
