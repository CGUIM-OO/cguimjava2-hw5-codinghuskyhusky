
public class Card {

	    enum Suit {Club,Diamond,Heart,Spade;}
		private Suit suit; 
		private int rank; 
		
		public Card(int s,int r){
			if(s==1)
			    {suit=Card.Suit.Club;}
			else if(s==2)
				{suit=Card.Suit.Diamond;}
			else if(s==3)
				{suit=Card.Suit.Heart;}
			else if(s==4)
				{suit=Card.Suit.Spade;}
            rank=r;
		}	
		
		public void printCard(){
	        System.out.print("("+getSuit()+","+getRank()+")\n");
	    }
		public Suit getSuit(){
			return suit;
		}
		public int getRank(){
			return rank;
		}
	
}
