import java.util.*;

public class Main {
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt();
		M = sc.nextInt();
		int[] A = new int[N];
		int result=0;
		for(int i=0;i<N;i++){
			A[i] = sc.nextInt();
		}
		for(int i=0;i<N;i++){
			int sum=0;
			for(int j=i;j<N;j++){
				sum+=A[j];
				if(sum==M){
					result++;
					break;
				}else if(sum>M){
					break;
				}
			}
		}
		System.out.println(result);
		sc.close();
	}
}
