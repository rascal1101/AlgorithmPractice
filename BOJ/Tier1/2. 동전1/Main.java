package baekjun;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n];
		int[] result = new int[k+1];
		for(int i=0;i<n;i++){
			coin[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++){
			for(int j=1;j<=k;j++){
				if(i==0){
					if(j%coin[i] == 0) 
						result[j]++;
				}else{
					if(j==coin[i])
						result[j]++;
					if(j-coin[i]>0){
						result[j] = result[j]+result[j-coin[i]];
					}
				}
			}
		}
		System.out.println(result[k]);
	}
}