package baekjun;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int[] num = new int[T];
		int max = 0;
		for(int i=0;i<T;i++){
			num[i] = sc.nextInt();
			
			if(num[i]>max) max = num[i];
		}
		boolean[] isPrime = new boolean[max+1];
		for(int i=0;i<isPrime.length;i++)
			isPrime[i] = true;
		isPrime[1] = false;
		LinkedList<Integer> prime = new LinkedList<>();
		
		for(int i=2;i<=max;i++){
			if(isPrime[i]){
				for(int j=2;i*j<=max;j++){
					isPrime[i*j] = false;
				}
			}
		}
		for(int i=2;i<max+1;i++)
			if(isPrime[i])
				prime.add(i);
			
		for(int n : num){
			int index = 0;
			for(int i=0;i<prime.size();i++){
				if(prime.get(i)>n/2){
					index = i-1;
					break;
				}
			}
			
			for(;index>=0;index--){
				int lowPrime = prime.get(index);
				int largePrime = n-lowPrime;
				if(prime.contains(largePrime)){
					sb.append(lowPrime + " " + largePrime + "\n");
					break;
				}
			}
		}
		
		System.out.print(sb);
		sc.close();
	}
	
}
