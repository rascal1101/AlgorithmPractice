import java.util.*;

public class Main {
	public static int[] s,visit;
	public static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		sb = new StringBuilder();
		while(true){
			int k = sc.nextInt();
			if(k==0) break;
			s = new int[k];
			visit = new int[k];
			for(int i=0;i<k;i++)
				s[i] = sc.nextInt();
			int len = s.length;
			for(int a=0;a<len-5;a++)
				for(int b=a+1;b<len-4;b++)
					for(int c=b+1;c<len-3;c++)
						for(int d=c+1;d<len-2;d++)
							for(int e=d+1;e<len-1;e++)
								for(int f=e+1;f<len;f++)
									sb.append(s[a]+" "+s[b]+" "+s[c]+" "+s[d]+" "+s[e]+" "+s[f]+"\n");
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	
	
}
