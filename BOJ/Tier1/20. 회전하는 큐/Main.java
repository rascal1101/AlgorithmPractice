import java.util.*;

public class Main {
	static int N,M;
	static int[] location;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt();
		M = sc.nextInt();
		location = new int[M];
		for(int i=0;i<M;i++)
			location[i] = sc.nextInt();
		System.out.println(find(0,0,N));
		sc.close();
	}
	public static int find(int index,int sum,int size){
		if(index==M)
			return sum;
		int right = (size-location[index]+1)%size;
		int left = location[index]-1;
		if(right<=left) {
			for(int i=index+1;i<M;i++){
				int a = (location[i]+right)%size;
				a = (a==0) ? size : a;
				location[i] = a-1;
			}
			return find(index+1,sum+right,size-1);
		}else{
			for(int i=index+1;i<M;i++){
				int a = (location[i]-left+size)%size;
				a = (a==0) ? size : a;
				location[i] = a-1;
			}
			return find(index+1,sum+left,size-1);
		}
	}
}
