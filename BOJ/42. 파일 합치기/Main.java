import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0){
			int k = sc.nextInt();
			int[] num = new int[k+1];
			int[] sum = new int[k+1];
			int[][] dp = new int[k+1][k+1];
			
			for(int i=1;i<=k;i++){
				num[i] = sc.nextInt();
				sum[i] = sum[i-1] + num[i];
			}
			
			for(int i=1;i<k;i++){
				for(int j=1;i+j<=k;j++){
					dp[j][i+j] = Integer.MAX_VALUE;
					for(int m=j;m<i+j;m++){
						dp[j][i+j] = Math.min(dp[j][i+j], dp[j][m] + dp[m+1][i+j] + sum[i+j] - sum[j-1]);
					}
				}
			}
			System.out.println(dp[1][k]);
		}
		sc.close();
	}

	
}
