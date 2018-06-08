import java.util.*;

public class Main{
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	int N,M;
    	int[][] room;
    	N = sc.nextInt();
    	M = sc.nextInt();
    	room = new int[N][M];
    	for(int i=0;i<N;i++){
    		for(int j=0;j<M;j++){
    			room[i][j] = sc.nextInt();
    			if(i==0 && j==0) continue;
    			else if(i==0) room[i][j] += room[i][j-1];
    			else if(j==0) room[i][j] += room[i-1][j];
    			else room[i][j] += Math.max(room[i-1][j], Math.max(room[i][j-1], room[i-1][j-1])); 
    		}
    	}
    	System.out.println(room[N-1][M-1]);
    	sc.close();
    }   
}