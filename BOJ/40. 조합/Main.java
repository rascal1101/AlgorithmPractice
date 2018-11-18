import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(combination(n,k));
		sc.close();
	}

	private static String combination(int n, int k) {
		BigInteger bi = new BigInteger("1");
		int div = 1; 
		while(div<=k){
			bi = bi.multiply(new BigInteger((n--) + "")).divide(new BigInteger( (div++)+"") );
		}
		return bi.toString();
	}
	
}