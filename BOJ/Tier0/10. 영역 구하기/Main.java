import java.util.*;

public class Main{
	public static int[][] matrix;
	
	public static Queue<Integer> q = new LinkedList();
	public static int count = 0,M,N,K;
	public static LinkedList<Integer> result = new LinkedList();
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	M = sc.nextInt();
    	N = sc.nextInt();
    	K = sc.nextInt();
    	matrix = new int[N][M];
   
    	for(int i=0;i<K;i++){
    		int x1,y1,x2,y2;
    		x1 = sc.nextInt();
    		y1 = sc.nextInt();
    		x2 = sc.nextInt();
    		y2 = sc.nextInt();
    		for(int j=x1;j<x2;j++){
    			for(int k=y1;k<y2;k++){
    				matrix[j][k] = 1;
    			}
    		}
    	}
    	for(int i=0;i<N;i++){
    		for(int j=0;j<M;j++){
    			if(matrix[i][j] == 0)
    				bfs(i,j);
    		}
    	}
    	StringBuffer sb = new StringBuffer();
    	sb.append(result.size()).append("\n");
    	result.sort((a,b)-> a-b);
    	for(int i=0;i<result.size();i++){
    		sb.append(result.get(i)+" ");
    	}
    	System.out.println(sb);
    }
    public static void bfs(int x, int y){
    	count = 0;
    	q.add(x);
    	q.add(y);
    	matrix[x][y] = 1;
    	while(true){
    		if(q.isEmpty()){
    			break;
    		}
    		int xx = q.poll();
    		int yy = q.poll();
    		count++;
    		if(xx+1<N && matrix[xx+1][yy] == 0){
    			q.add(xx+1);
    			q.add(yy);
    			matrix[xx+1][yy] = 1;
    		}
    		if(xx-1>=0 && matrix[xx-1][yy] == 0){
    			q.add(xx-1);
    			q.add(yy);
    			matrix[xx-1][yy] = 1;
    		}
    		if(yy-1>=0 && matrix[xx][yy-1] == 0){
    			q.add(xx);
    			q.add(yy-1);
    			matrix[xx][yy-1] = 1;
    		}
    		if(yy+1<M && matrix[xx][yy+1] == 0){
    			q.add(xx);
    			q.add(yy+1);
    			matrix[xx][yy+1] = 1;
    		}    		
    	}
    	result.add(count);
    }
    
}
