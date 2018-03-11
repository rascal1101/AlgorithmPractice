package baekjun;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int x1,x2,y1,y2;
		int[] cx;
		int[] cy;
		int[] r;
		int[] stack1 = new int[50];
		int[] stack2 = new int[50];
		int top1 = -1;
		int top2 = -1;
		
		for(int i=0;i<T;i++) {
			x1 = scanner.nextInt();
			y1 = scanner.nextInt();
			x2 = scanner.nextInt();
			y2 = scanner.nextInt();
			
			int n = scanner.nextInt();
			cx = new int[n];
			cy = new int[n];
			r = new int[n];
			for(int j=0;j<n;j++) {
				cx[j] = scanner.nextInt();
				cy[j] = scanner.nextInt();
				r[j] = scanner.nextInt();
				
				int distanceSquare1 = (x1-cx[j])*(x1-cx[j]) + (y1-cy[j])*(y1-cy[j]);
				if(distanceSquare1 < r[j]*r[j])
					stack1[++top1] = j;
				int distanceSquare2 = (x2-cx[j])*(x2-cx[j]) + (y2-cy[j])*(y2-cy[j]);
				if(distanceSquare2 < r[j]*r[j])
					stack2[++top2] = j;
			}
			int count=0;
			for(int k=0;k<=top1;k++) {
				for(int l=0;l<=top2;l++) {
					if(stack1[k] == stack2[l]) {
						count++;
					}
				}
			}
			System.out.println(top1+top2+2-2*count);
			
			top1 = -1;
			top2 = -1;
			
		}
	}
}

