import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt();
		int KIM = sc.nextInt();
		int LIM = sc.nextInt();
		if(KIM>LIM) {
			int temp = KIM;
			KIM = LIM;
			LIM = temp;
		}
		int round = 1;
		while(true){
			if(KIM%2==1 && LIM-KIM==1){
				break;
			}else if(N==1){
				round = -1;
				break;
			}

			round++;
			if(N%2==0)
				N = N/2;
			else
				N = N/2 + 1;
			KIM = (KIM+1)/2;
			LIM = (LIM+1)/2;
		}
		System.out.println(round);
		sc.close();
	}
}
