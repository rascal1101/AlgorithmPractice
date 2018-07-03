import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		for(int i=0;i<n;i++)
			coin[i] = sc.nextInt();
		for(int i=1;i<=k;i++){
			for(int j=0;j<n;j++){
				if(i==coin[j])
					dp[i] = 1;
				else if(i>coin[j] && dp[i-coin[j]]!=0 && (dp[i]==0 || dp[i] > dp[i-coin[j]]+1) )
					dp[i] = dp[i-coin[j]]+1;
			}
		}
		if(dp[k]==0) System.out.println("-1");
		else System.out.println(dp[k]);
		sc.close();
	}
}
