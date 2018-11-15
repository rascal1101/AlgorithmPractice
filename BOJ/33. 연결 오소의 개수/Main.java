import java.util.*;

public class Main {
	static int N,M;
	static int[] visit;
	static LinkedList<Integer>[] lines;
	static Queue<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt();
		M = sc.nextInt();
		lines = new LinkedList[N];
		visit = new int[N];
		q = new LinkedList<Integer>();
		int result = 0;
		for(int i=0;i<N;i++){
			lines[i] = new LinkedList<Integer>();
		}
		for(int i=0;i<M;i++){
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			lines[a].add(b);
			lines[b].add(a);
		}
		
		for(int i=0;i<N;i++){
			if(visit[i]==0) {
				result++;
				//visit[i]=1;
				//dfs(i);
				bfs(i);
			}
		}
		System.out.println(result);
		sc.close();
	}
	public static void dfs(int v){
		for(int e : lines[v]){
			if(visit[e] == 0) {
				visit[e] = 1;
				dfs(e);
			}
		}
	}
	public static void bfs(int s){
		q.add(s);
		visit[s] = 1;
		while(!q.isEmpty()){
			int v = q.poll();
			for(int e : lines[v]){
				if(visit[e] == 0){
					visit[e] = 1;
					q.add(e);
				}
			}
		}
	}
}
