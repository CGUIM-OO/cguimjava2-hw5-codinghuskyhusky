
public class Player extends Person {

	String name;
	int    chips;
	
	
	public Player(String in_name,int in_chips) {
		name=in_name;
		chips=in_chips;
	}

	public String getName(){
		return name;
	}
	
	
	public boolean hit_me(Table table) {
		if(getTotalValue()<17)
		{
			return true;
		}
		else return false;
	}

	public void sayHello(){
		System.out.print("Hello,i am " +name+".");
		System.out.print("i have "+chips+" chips. ");
	}
	
	public int makeBet(){
		int bet;
		if(chips ==0)
		{
			System.out.print("run out of chips");
			bet=0;
		}
		else
		{
			bet=1;
			chips--;
		}
        
		return bet;
	}
	
	public void increaseChips(int diff) {
		diff = 2;
		chips += diff;
	}
	
	public void decreaseChips(int diff) {
		diff = -1;
		chips += diff;
	}
	
	public int getCurrentChips() {
		return chips;
	}

}
