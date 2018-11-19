import java.util.*;

public class Main {
	static int M,N;
	static int[][] road,dp; 
	static int[] dirX = {1,-1,0,0},dirY = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		road = new int[M][N];
		dp = new int[M][N];
		
		
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				road[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		System.out.println(count(0,0,M-1,N-1));
		sc.close();
	}
	private static int count(int sx, int sy, int dx, int dy) {
		if(sx == dx && sy == dy) return 1;
		
		if(dp[sx][sy] > -1) return dp[sx][sy];
		dp[sx][sy] = 0;
		for(int i=0;i<4;i++){
			int nextX = sx + dirX[i];
			int nextY = sy + dirY[i];
			
			if(nextX<0 || nextY<0 || nextX>=M || nextY>=N) continue;
			if(road[nextX][nextY] >= road[sx][sy]) continue;
			
			dp[sx][sy] += count(nextX,nextY,dx,dy);
		}
		return dp[sx][sy];
	}

	
}
