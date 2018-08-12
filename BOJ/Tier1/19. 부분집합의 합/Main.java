import java.util.*;

public class Main {
	static int result=0,N,S;
	static int[]elements;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt();
		S = sc.nextInt();
		elements = new int[N];
		for(int i=0;i<N;i++)
			elements[i] = sc.nextInt();
		for(int i=1;i<=N;i++){
			dfs(i,0,-1);
		}
		System.out.println(result);
		sc.close();
	}
	public static void dfs(int n, int sum, int sel){
		if(n==0) {
			if(sum==S) result++;
			return;
		}
		if(N-sel-1<n) return;
		for(int i=sel+1;i<N;i++){
			dfs(n-1,sum+elements[i],i);
		}
	}
}
