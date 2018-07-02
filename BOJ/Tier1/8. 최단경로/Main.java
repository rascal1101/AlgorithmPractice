package baekjun;

import java.util.*;

public class Main {
	public static int V,E,K;
	public static List<Edge>[] edges;
	public static int[] cost,visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		edges = new List[V];
		cost = new int[V];
		visit = new int[V];
		
		for(int i=0;i<V;i++){
			edges[i] = new LinkedList<Edge>();
			cost[i] = Integer.MAX_VALUE;
		}
		
		
		for(int i=0;i<E;i++)
			edges[sc.nextInt()-1].add(new Edge(sc.nextInt()-1,sc.nextInt()));
		
		for(int i=0;i<V;i++){
			//find node with unvisit && minimum cost
			int index = 0;
			if(i!=0){
				int minCost = Integer.MAX_VALUE;
				for(int j=0;j<V;j++){
					if(visit[j]==0 && cost[j]<minCost){
						minCost = cost[j];
						index = j;
					}
				}
			}else{
				index = K-1;
				cost[index] = 0;
			}
			
			//visit check
			visit[index] = 1;
			//System.out.println(index + " selected");
			//update path cost
			for(Edge e :edges[index]){
				if(cost[e.v]>cost[index] + e.cost){
					cost[e.v] = cost[index] + e.cost;
					//System.out.println(e.v + " : " + cost[e.v]);
				}
			}
		}
		
		//print answer
		StringBuilder sb = new StringBuilder();
		for(int c:cost){
			if(c!=Integer.MAX_VALUE)
				sb.append(c).append("\n");
			else
				sb.append("INF\n");
		}
		System.out.println(sb);
		
		sc.close();
	}
}

class Edge{
	public int v,cost;
	public Edge(int vv, int c){
		v = vv;
		cost = c;
	}
}