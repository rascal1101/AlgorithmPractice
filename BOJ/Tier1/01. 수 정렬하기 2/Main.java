package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] num = new int[N];
		for(int i=0;i<N;i++) {
			num[i] = scanner.nextInt();
		}
		
		Arrays.sort(num);

		StringBuffer s = new StringBuffer();
		
		
		for(int i=0;i<N;i++) {
			s.append(num[i]+"\n");
		}
		System.out.println(s);
	}
}
