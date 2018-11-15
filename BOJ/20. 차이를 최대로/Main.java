import java.util.*;

public class Main{
	public static int N,indexCount,result;
	public static int[] num,index;
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	num = new int[N];
    	index = new int[N];
    	result = Integer.MIN_VALUE;
    	for(int i=0;i<N;i++){
    		num[i] = sc.nextInt();
    		index[i] = -1;
    	}
    	dfs();
    	System.out.println(result);
    	sc.close();
    }
    public static void dfs(){
    	if(indexCount==N){
    		int sum = 0;
    		for(int j=0;j<N-1;j++){
    			int temp = num[index[j]]-num[index[j+1]];
    			if(temp<0) temp = -1*temp;
    			sum += temp;	
    		}
    		if(sum>result) result = sum;
    		return;
    	}
    	for(int i=0;i<N;i++){
    		if(index[i]==-1){
    			index[i] = indexCount;
    			indexCount++;
    			dfs();
    			index[i] = -1;
    			indexCount--;
    		}
    	}
    }
}