import java.util.ArrayList;
import java.util.Random;
//import Card.Suit;

public class deck {
	private ArrayList<Card> usedCard= new ArrayList<Card>();
	private ArrayList<Card> openCard= new ArrayList<Card>();
	private ArrayList<Card> cards;
	public int nUsed;
	Random ran = new Random();
	///////////////////////////////
	
	public deck(int nDeck){
		cards=new ArrayList<Card>();
		
		for(int deckcount=1;deckcount<=nDeck;deckcount++) {
			
			for(int i=1;i<=4;i++) {
				for(int j=1;j<=13;j++) {
					Card card=new Card(i,j);
					cards.add(card);
					}
			}
          
		}
    }
	
	public void shuffle() {
		
		//int R =usedCard.size();//set random size by cards num
		for(int i=0;i<=51;i++) {
			Card handcard = cards.get(i);
			cards.remove(i);
			
			//select a space to insert card
			int r = ran.nextInt(51);
			cards.add(r,handcard);
			
			//reset nUsed count and usedCard array
			
			nUsed = 0;
			usedCard.clear();
			openCard.clear();
		}
		
	}
	
	public Card getOneCard(boolean isOpened) {
		if (nUsed==52)
		{
			shuffle();
		}
		int O =cards.size();
		int rnd_out= ran.nextInt(O);
		
		Card getcard = cards.get(rnd_out);//get random card
		usedCard.add(getcard);
		
		if(isOpened==true)//determine card if open or cover
		{
			openCard.add(getcard);
		}
		
		
		nUsed++;
		return getcard;
		
	}
	
	public ArrayList<Card> getAllCards() {
		return cards;
	}
	public ArrayList<Card> getOpenedCards() {
		return openCard;
	}
	
}