import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		int m = sc.nextInt();
		LinkedList<Bus>[] bus = new LinkedList[n];
		int[] cost = new int[n];
		int[] visit = new int[n];
		
		for(int i=0;i<n;i++){
			bus[i] = new LinkedList<>();
			cost[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<m;i++){
			bus[sc.nextInt()-1].add(new Bus(sc.nextInt()-1,sc.nextInt()));
		}
		
		for(int i=0;i<n;i++){
			int index = -1;
			if(i!=0){
				int minCost = Integer.MAX_VALUE;
				for(int j=0;j<n;j++){
					if(visit[j]==0 && cost[j]!=Integer.MAX_VALUE && cost[j]<minCost){
						minCost = cost[j];
						index = j;
					}
				}
			}else{
				index = sc.nextInt()-1;
				cost[index] = 0;
			}
			if(index==-1) break;
			
			visit[index] = 1;
			
			for(Bus b :bus[index]){
				if(cost[b.v]>cost[index] + b.cost){
					cost[b.v] = cost[index] + b.cost;
				}
			}
//			System.out.println(index + " selected");
//			for(int j=0;j<n;j++){
//				System.out.print(cost[j] + " ");
//			}
//			System.out.println();
		}
		
		System.out.println(cost[sc.nextInt()-1]);
		
		
		sc.close();
	}
}

class Bus{
	public int v,cost;
	public Bus(int vv,int c){
		v = vv;
		cost = c;
	}
}
