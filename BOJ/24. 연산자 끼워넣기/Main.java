import java.util.*;

public class Main {
	public static int N,result,max,min;
	public static int[] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		N = sc.nextInt();
		A = new int[N];
		for(int i=0;i<N;i++)
			A[i] = sc.nextInt();
		result = A[0];
		dfs(1,sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
		System.out.println(max+"\n"+min);
		sc.close();
	}
	
	public static void dfs(int i,int a, int b, int c,int d){
		if(i==N) {
			if(result>max) max = result;
			if(result<min) min = result;
			return;
		}
		
		if(a>0){
			result += A[i];
			dfs(i+1,a-1,b,c,d);
			result -= A[i];
		}
		if(b>0){
			result -= A[i];
			dfs(i+1,a,b-1,c,d);
			result += A[i];
		}
		if(c>0){
			result *= A[i];
			dfs(i+1,a,b,c-1,d);
			result /= A[i];
		}
		if(d>0){
			int tmp = result;
			result /= A[i];
			dfs(i+1,a,b,c,d-1);
			result = tmp;
		}
	}
}
