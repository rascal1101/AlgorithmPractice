package baekjun;

import java.util.Scanner;

public class Main {
	static int[] q = new int[100000];
	static int top=0;
	static int i=0;
	public static void push(int a, int b) {
		q[(top++)%100000] = a;
		q[(top++)%100000] = b;
	}
	public static int pop() {
		return q[(i++)%100000];
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[][] miro = new int[N][M];
		int[][] cost = new int[N][M];
		int[][] check = new int[N][M];
		String[] s = new String[N];
		int cal = N*M;
		scanner.nextLine();
		for(int i=0;i<N;i++) {
			s[i] = scanner.nextLine();
			for(int j=0;j<M;j++) {
				cost[i][j] = cal;
				miro[i][j] = s[i].charAt(j)-48;
			}
		}
		cost[0][0] = 1;
		check[0][0] = 1;
		int a,b;
		a=b=0;
		while(true) {
			if(a-1>=0 && miro[a-1][b]==1 && check[a-1][b] == 0) {
				cost[a-1][b] = Math.min(cost[a][b]+1, cost[a-1][b]);
				check[a-1][b]=1;
				push(a-1,b);
			}
			if(b-1>=0 && miro[a][b-1]==1 && check[a][b-1] == 0) {
				cost[a][b-1] = Math.min(cost[a][b]+1, cost[a][b-1]);
				check[a][b-1]=1;
				push(a,b-1);
			}
			if(a+1<N && miro[a+1][b]==1 && check[a+1][b] == 0) {
				cost[a+1][b] = Math.min(cost[a][b]+1, cost[a+1][b]);
				check[a+1][b]=1;
				push(a+1,b);
			}
			if(b+1<M && miro[a][b+1]==1 && check[a][b+1] == 0) {
				cost[a][b+1] = Math.min(cost[a][b]+1, cost[a][b+1]);
				check[a][b+1]=1;
				push(a,b+1);
			}
			if(i==top)
				break;
			else {
				a=pop();
				b=pop();
			}
		}
		System.out.println(cost[N-1][M-1]);
	}
}
