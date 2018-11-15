import java.util.*;

public class Main{
	
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	String[] s = new String[N];
    	s[0] = "  *  ";
    	s[1] = " * * ";
    	s[2] = "*****";
    	int i = 3;
    	String space = "   ";
    	while(i!=N){
    		for(int j=i;j<i*2;j++)
    			s[j] = s[j-i] + " " + s[j-i];
    		if(i!=3)
    			space = space + space;
    		
    		for(int j=0;j<i;j++){
    			s[j] = space + s[j] + space;
    		}
    		i=i*2;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(i=0;i<N;i++)
    		sb.append(s[i]).append("\n");
    	System.out.println(sb);
    	sc.close();
    }
}