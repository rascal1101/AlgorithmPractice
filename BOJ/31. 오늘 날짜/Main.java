import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
	    Date date = new Date();
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    df.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
	    System.out.println(df.format(date));
		sc.close();
	}
}
