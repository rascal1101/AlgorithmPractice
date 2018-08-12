import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int N = Integer.parseInt(sc.nextLine());
		int[] deque = new int[20001];
		int front=10000;
		int back=9999;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			String[] s = sc.nextLine().split(" ");
			if(s[0].equals("push_front")){
				deque[--front] = Integer.parseInt(s[1]);
			}else if(s[0].equals("push_back")){
				deque[++back] = Integer.parseInt(s[1]);
			}else if(s[0].equals("pop_front")){
				if(front==back+1) sb.append("-1\n");
				else sb.append(deque[front++]).append("\n");
			}else if(s[0].equals("pop_back")){
				if(front==back+1) sb.append("-1\n");
				else sb.append(deque[back--]).append("\n");
			}else if(s[0].equals("size")){
				sb.append(back-front+1).append("\n");
			}else if(s[0].equals("empty")){
				if(front==back+1) sb.append("1\n");
				else sb.append("0\n");
			}else if(s[0].equals("front")){
				if(front==back+1) sb.append("-1\n");
				else sb.append(deque[front]).append("\n");
			}else if(s[0].equals("back")){
				if(front==back+1) sb.append("-1\n");
				else sb.append(deque[back]).append("\n");
			} 
		}
		System.out.println(sb);
		sc.close();
	}
}
