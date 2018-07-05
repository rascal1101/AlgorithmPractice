import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		int[] dp = new int[10];
		for(int i=0;i<10;i++)
			dp[i] = 1;
		for(int i=0;i<n-1;i++)
			for(int j=0;j<10;j++)
				for(int k=j+1;k<10;k++)
					dp[j] = (dp[j]+dp[k])%10007;
		int sum = 0;
		for(int i=0;i<10;i++)
			sum = (sum+dp[i])%10007;
		System.out.println(sum);
		sc.close();
	}
}
