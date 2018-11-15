import java.util.*;

public class Main{
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	String s = sc.nextLine();
    	int[] result = new int[26];
    	for(int i=0;i<s.length();i++)
    		result[s.charAt(i)-97]++;
    	
    	for(int a : result)
    		System.out.print(a + " ");
    	
    	sc.close();
    }
}