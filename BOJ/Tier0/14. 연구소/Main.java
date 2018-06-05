import java.util.*;

public class Main{
	public static int N,M;
	public static int[][] room;
	public static int[][] visit;
	public static int brick;
	public static LinkedList<Integer> ll = new LinkedList<>();
	public static Queue<Integer> q = new LinkedList<>();
	public static int result = 0;
	public static int virus=Integer.MAX_VALUE;
	public static int vc=0;
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	room = new int[N][M];
    	visit = new int[N][M];
    	for(int i=0;i<N;i++){
    		for(int j=0;j<M;j++){
    			room[i][j] = sc.nextInt();
    			if(room[i][j] == 2){
    				result++;
    				ll.add(i);
    				ll.add(j);
    			}else if(room[i][j] == 0){
    				result++;
    			}
    		}
    	}
    	dfs();
    	System.out.println(result-3-virus);
    	
    	sc.close();
    }
    public static void dfs(){
    	if(brick==3){
    		clearVisit();
    		vc = 0;
    		for(int i=0;i<ll.size();i=i+2){
    			q.add(ll.get(i));
    			q.add(ll.get(i+1));
    			visit[ll.get(i)][ll.get(i+1)] = 1;
    		}
    		
    		bfs();
    		if(vc < virus) 
    			virus = vc;
    	}else{
	    	for(int i=0;i<N;i++){
	    		for(int j=0;j<M;j++){
	    			if(room[i][j]==0){
	    				room[i][j]=1;
	    				brick++;
	    				dfs();
	    				room[i][j]=0;
	    				brick--;
	    			}
	    		}
	    	}
    	}
    }
    public static void clearVisit(){
    	for(int i=0;i<N;i++){
    		for(int j=0;j<M;j++){
    			visit[i][j] = 0;
    		}
    	}
    }
    
    public static void bfs(){
    	while(true){
    		if(q.isEmpty()) break;
    		int x = q.poll();
    		int y = q.poll();
    		vc++;
    		
	    	if(x+1<N && room[x+1][y]==0 && visit[x+1][y]==0){
	    		q.add(x+1);
	    		q.add(y);
	    		visit[x+1][y] = 1;
	    	}
	    	if(x-1>=0 && room[x-1][y]==0 && visit[x-1][y]==0){
	    		q.add(x-1);
	    		q.add(y);
	    		visit[x-1][y] = 1;
	    	}
	    	if(y+1<M && room[x][y+1]==0 && visit[x][y+1]==0){
	    		q.add(x);
	    		q.add(y+1);
	    		visit[x][y+1] = 1;
	    	}
	    	if(y-1>=0 && room[x][y-1]==0 && visit[x][y-1]==0){
	    		q.add(x);
	    		q.add(y-1);
	    		visit[x][y-1] = 1;
	    	}
    	}	
    }
    
}
