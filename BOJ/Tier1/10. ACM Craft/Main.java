import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt();
		
		while(T-->0){
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] time = new int[N];
			int[] check = new int[N];
			Queue<Integer> start = new LinkedList<>();
			for(int i=0;i<N;i++)//store constructing time
				time[i] = sc.nextInt();
			LinkedList<Integer>[] condition1 = new LinkedList[N];
			LinkedList<Integer>[] condition2 = new LinkedList[N];
			Queue<Integer> q = new LinkedList();
			
			for(int i=0;i<N;i++){
				condition1[i] = new LinkedList();
				condition2[i] = new LinkedList();
			}
			for(int i=0;i<K;i++){//store condition of constructing building
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				condition1[a].add(b);
				condition2[b].add(a);
				check[b]++;
			}
			int W = sc.nextInt()-1;
			for(int i=0;i<N;i++)
				if(check[i]==0)
					q.add(i);
			
			while(!q.isEmpty()){
				int a = q.poll();
				start.add(a);
				for(int b : condition1[a]){
					if((--check[b])==0){
						q.add(b);
					}
				}
			}
			
			while(true){
				if(start.isEmpty()) break;
				int a = start.poll();
				int maxTime = 0;
				for(int b : condition2[a]){
					if(time[b]>maxTime) maxTime = time[b];
				}
				time[a] += maxTime;
				
			}
			System.out.println(time[W]);
		}
		sc.close();
	}
}
