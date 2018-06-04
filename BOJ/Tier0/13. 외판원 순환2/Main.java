import java.util.*;

public class Main{
	public static int N;
	public static int[][] W;
	public static int cost=0,result;
	public static int[] visit;
	public static Queue<Integer> q = new LinkedList<>();
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	visit = new int[N];
    	W = new int[N][N];
    	for(int i=0;i<N;i++){
    		for(int j=0;j<N;j++){
    			W[i][j] = sc.nextInt();
    		}
    	}    	
    	result = Integer.MAX_VALUE;
    	visit[0] = 1;
    	dfs(0);
    	System.out.println(result);
    	sc.close();
    }
    public static void dfs(int v){
    	for(int i=0;i<N;i++){
    		if(W[v][i]!=0 && visit[i]==0){
    			visit[i] = 1;
    			cost += W[v][i];
    			dfs(i);
    			visit[i] = 0;
    			cost -= W[v][i];
    		}
    	}
    	if(allVisit() && W[v][0] !=0 && result > cost+W[v][0])
			result = cost+W[v][0];
    	
    }
    public static boolean allVisit(){
    	for(int i=0;i<N;i++){
    		if(visit[i]==0) return false;
    	}
    	return true;
    }
}
