import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int up1 = sc.nextInt();
		int down1 = sc.nextInt();
		int up2 = sc.nextInt();
		int down2 = sc.nextInt();
		int up3 = up1*down2 + up2*down1;
		int down3 = down1*down2;
		int n = GCM(up3,down3);
		up3 = up3/n;
		down3 = down3/n;
		
		System.out.println(up3 + " " + down3);
		sc.close();
	}
	public static int GCM(int a, int b){
		if(b==0) return a;
		else return GCM(b,a%b);
	}
}
