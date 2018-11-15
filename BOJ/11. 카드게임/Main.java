import java.util.*;

public class Main{
	public static Card[] cards;
	public static int oneCount,twoCount,threeCount,fourCount,fiveCount;
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	cards = new Card[5];
    	for(int i=0;i<5;i++){
    		String[] s = sc.nextLine().trim().split(" ");
    		cards[i] = new Card(s[0].charAt(0),Integer.parseInt(s[1]));
    	}
    	Arrays.sort(cards);
    	check();
    	boolean asc = allSameColor();
    	boolean aan = allAscendingNumber();
    	if(asc && aan){//1.모든 색이 같고 숫자가 연속적일 때
    		System.out.println(cards[4].number+900);
    	}else if(fourSameNumber()){//2.4장의 숫자가 같을 때
    		System.out.println(cards[1].number+800);
    	}else if(twoThreeSameNumber()){//3. 2,3숫자 같은 경우
    		if(cards[1].number == cards[2].number){//3,2
    			System.out.println(cards[0].number * 10 + cards[3].number + 700);
    		}else{//2,3
    			System.out.println(cards[2].number * 10 + cards[0].number + 700);
    		}
    	}else if(asc){//4.색만 모두 같은 경우
    		System.out.println(cards[4].number + 600);
    	}else if(aan){//5.숫자 연속
    		System.out.println(cards[4].number + 500);
    	}else if(threeSameNumber()){//6.3장의 숫자가 같을 때
    		System.out.println(cards[2].number+400);
    	}else if(twoTwoSameNumber()){//7.2장, 2장의 숫자가 같을 때
    		System.out.println(cards[3].number * 10 + cards[1].number + 300);
    	}else if(twoSameNumber()){//8.2장의 숫자가 같을 때
    		for(int i=0;i<4;i++){
    			if(cards[i].number == cards[i+1].number){
    				System.out.println(cards[i].number+200);
    				break;
    			}
    		}
    	}else{//9.가장 큰 숫자 + 100
    		System.out.println(cards[4].number+100);
    	}
    }
    public static void check(){
    	int[] n = new int[10];
    	for(int i=0;i<5;i++){
    		n[cards[i].number]++;
    	}
    	for(int i=0;i<10;i++){
    		if(n[i]==1) oneCount++;
    		else if(n[i]==2) twoCount++;
    		else if(n[i]==3) threeCount++;
    		else if(n[i]==4) fourCount++;
    		else if(n[i]==5) fiveCount++;
    	}
    }
    public static boolean threeSameNumber(){
    	if(threeCount==1 && oneCount==2) return true;
    	else return false;
    }
    public static boolean twoTwoSameNumber(){
    	if(twoCount==2) return true;
    	else return false;
    }
    public static boolean twoSameNumber(){
    	if(twoCount==1 && oneCount==3) return true;
    	else return false;
    }
    public static boolean twoThreeSameNumber(){
    	if(twoCount==1 && threeCount==1) return true;
    	else return false;
    }
    public static boolean fourSameNumber(){
    	if(fourCount==1) return true;
    	else return false;
    }
    public static boolean allAscendingNumber(){
    	int f = cards[0].number;
    	for(int i=1;i<5;i++){
    		if(f!=cards[i].number-1){
    			return false;
    		}
    		f++;
    	}
    	return true;
    }
    public static boolean allSameColor(){
    	char c = cards[0].color;
    	for(int i=0;i<5;i++){
    		if(c!=cards[i].color){
    			return false;
    		}
    	}
    	return true;
    }
}

class Card implements Comparable<Card>{
	char color;
	int number;
	public Card(char c, int n){
		color = c;
		number = n;
	}
	public int compareTo(Card c){
		return this.number - c.number;
	}
}