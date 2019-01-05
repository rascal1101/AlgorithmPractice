import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			map = new int[m][n];
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int lands = 0;
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==1) {
						dfs(i,j);
						lands++;
					}
				}
			}
			System.out.println(lands);
		}
	}
	private static void dfs(int i, int j) {
		map[i][j] = 0;
		if(i+1<m && map[i+1][j]==1) {
			dfs(i+1,j);
		}
		if(i-1>=0 && map[i-1][j]==1) {
			dfs(i-1,j);			
		}
		if(j+1<n && map[i][j+1]==1) {
			dfs(i,j+1);
		}
		if(j-1>=0 && map[i][j-1]==1) {
			dfs(i,j-1);
		}
		if(i+1<m && j+1<n && map[i+1][j+1]==1) {
			dfs(i+1,j+1);
		}
		if(i+1<m && j-1>=0 && map[i+1][j-1]==1) {
			dfs(i+1,j-1);
		}
		if(i-1>=0 && j+1<n && map[i-1][j+1]==1) {
			dfs(i-1,j+1);
		}
		if(i-1>=0 && j-1>=0 && map[i-1][j-1]==1) {
			dfs(i-1,j-1);
		}
	}
}
