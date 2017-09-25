package baekjun;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int result=N;
		int pre;
		int post;
		int sum;
		int cycle = 0;
		
		while(true){
			pre = result/10;
			post = result%10;
			sum = pre + post;
			result = post*10 + sum%10;
			cycle++;
			if(result == N){
				break;
			}
		}
		
		System.out.println(cycle);
	}
}