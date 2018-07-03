import java.util.*;

public class Main{
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] num = new int[n];
    	boolean no = false;
    	StringBuilder sb = new StringBuilder();
    	num[0] = sc.nextInt();
    	int max = num[0];
    	for(int i=1;i<n;i++){
    		num[i] = sc.nextInt();
    		if(num[i] > max) max = num[i];
    		else if(!no && max > num[i] && max > num[i-1] && num[i] > num[i-1]){
    			sb.append("NO");
    			no = true;
    		}
    	}
    	if(!no){
    		int i=1;
    		int j=0;
    		while(j<n){
    			if(num[j]==i){
    				sb.append("+\n-\n");
    				i++;
    				j++;
    			}else if(num[j]>i){
    				sb.append("+\n");
    				i++;
    			}else{
    				sb.append("-\n");
    				j++;
    			}
    		}
    	}
    	System.out.print(sb);
    	
    	sc.close();
    }
   
}