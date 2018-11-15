import java.util.*;

public class Main{
	
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	String s = sc.nextLine();
    	int lc=0,result=0;
    	s = s.replace("()", "a");
    	for(int i=0;i<s.length();i++){
    		char c = s.charAt(i);
    		if(c=='('){
    			lc++;
    		}else if(c==')'){
    			lc--;
    			result++;
    		}else if(c=='a'){
    			result+=lc;
    		}
    	}
    	System.out.println(result);
    }    
}
