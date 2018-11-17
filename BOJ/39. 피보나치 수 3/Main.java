package baekjun;

import java.math.BigInteger;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger bi = new BigInteger(sc.nextLine());
		int n = Integer.parseInt(bi.mod(new BigInteger("1500000")).toString());
		if(n==0) System.out.println(0);
		else if(n==1) System.out.println(1);
		else{
			int a = 0;
			int b = 1;
			int result=0;
			for(int i=0;i<n-1;i++){
				result = (a+b)%1000000;
				a = b;
				b = result;
			}
			System.out.println(result);
		}
		sc.close();
	}
	
}