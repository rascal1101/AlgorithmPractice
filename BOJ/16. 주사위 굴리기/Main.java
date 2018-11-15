import java.util.*;

public class Main{
	public static int N,M,x,y,K;
	public static int[][] map;
	public static int[] dice;
	public static final int east = 1;
	public static final int west = 2;
	public static final int south = 4;
	public static final int north = 3;
	public static final int bottom = 0;
	public static final int top = 5;
	public static boolean moved = false;
	
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	x = sc.nextInt();
    	y = sc.nextInt();
    	K = sc.nextInt();
    	map = new int[N][M];
    	dice = new int[6];
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<N;i++)
    		for(int j=0;j<M;j++)
    			map[i][j] = sc.nextInt();
    	for(int i=0;i<K;i++){
    		throwDice(sc.nextInt());
    		if(moved)
    			sb.append(dice[top]).append("\n");
    		
    	}
    	System.out.print(sb);
    	
    	sc.close();
    }
    
    public static void throwDice(int command){
    	moved = false;
    	if(command == east && y+1<M){
    		y = y+1;
    		int temp=dice[bottom];
    		dice[bottom] = dice[east];
    		dice[east] = dice[top];
    		dice[top] = dice[west];
    		dice[west] = temp;
    		moved = true;
    	}else if(command == west && y-1>=0){
    		y = y-1;
    		int temp = dice[bottom];
    		dice[bottom] = dice[west];
    		dice[west] = dice[top];
    		dice[top] = dice[east];
    		dice[east] = temp;
    		moved = true;
    	}else if(command == north && x-1>=0){
    		x = x-1;
    		int temp = dice[bottom];
    		dice[bottom] = dice[north];
    		dice[north] = dice[top];
    		dice[top] = dice[south];
    		dice[south] = temp;
    		moved = true;
    	}else if(command == south && x+1<N){
    		x = x+1;
    		int temp = dice[bottom];
    		dice[bottom] = dice[south];
    		dice[south] = dice[top];
    		dice[top] = dice[north];
    		dice[north] = temp;
    		moved = true;
    	}
    	if(moved){
    		if(map[x][y] == 0){
    			map[x][y] = dice[bottom];
    		}else{
    			dice[bottom] = map[x][y];
    			map[x][y] = 0;
    		}
    	}
    }
}