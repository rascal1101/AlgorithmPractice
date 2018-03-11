package baekjun;

public class Main {
	public static void main(String[] args){
		int[] n = new int[10001];
		
		int result;
		for(int i=1;i<=10000;i++) {
			if(n[i] == 1)
				continue;
			else
				result = i;
			
			while(true) {
				result = result + result%10 + (result/10)%10 + (result/100)%10 + (result/1000)%10 + (result/10000)%10;
				if(result<=10000)
					n[result]=1;
				else if(result>10000)
					break;
			}
		}
		
		for(int i=1;i<=10000;i++) {
			if(n[i]==0)
				System.out.println(i);
		}
	}
}

