import java.util.ArrayList;

public class Table {
	static final int Maxplayer = 4;
	private deck Deck1;    //存放所排 
	private Player[] player; //存所有player 
	private Dealer Dealer;   //存莊家 
	private int[] pos_betArray = new int[Maxplayer]; //存All玩家's bet of each round
	private Player[] playerarray = new Player[Maxplayer]; //初始player的array 
	
			
	public Table(int nDeck) {
		
		    Deck1 = new deck(nDeck);
		    //playerarray = new Player[Maxplayer];
		    // Class Table's constructor
		
	}
	
	public void set_player(int pos, Player player) {
		
		    playerarray[pos]=player;
		    //player's setter
		
	}

	public Player[] get_player() {
		
		    return playerarray ;
		    //return參賽玩家 
			
	}
	
	public void set_dealer(Dealer dealer) {
		
		    Dealer = dealer;
		    //dealer's setter
		
	}
	
	public Card get_face_up_card_of_dealer() {
		   return null;
           //回傳dealer open card 施工中
	}
	
	private void ask_each_player_about_bets() {
		
		for(int i=0;i< playerarray.length;i++) {
			playerarray[i].sayHello(); //player say hello
			System.out.print("\n");
			////System.out.print(playerarray[i].makeBet()); //show every player's bet
		    pos_betArray[i]=playerarray[i].makeBet();//存player's bet
		}
		
	}
	
	
	private void distribute_cards_to_dealer_and_players() {
		
		for(int i=0;i< playerarray.length;i++) {
			
		   ArrayList<Card> playerCard=new ArrayList<Card>();

		   playerCard.add(Deck1.getOneCard(true));
		   playerarray[i].setOneRoundCard(playerCard);
		   //distribute two card to every player
		   
		}
		
		
		   ArrayList<Card> dealerCard=new ArrayList<Card>();
		   dealerCard.add(Deck1.getOneCard(false));
		   dealerCard.add(Deck1.getOneCard(true));
		   Dealer.setOneRoundCard(dealerCard);
		   //distribute two card to dealer
		   
		   System.out.print("Dealer's face up card is ");
		   
		
	}

	private void ask_each_player_about_hits() {
		
		for(int i=0;i< playerarray.length;i++) {
			ArrayList<Card> playerCard=new ArrayList<Card>();
		    boolean hit = false;
		            
			do{
				hit=playerarray[i].hit_me(this); 
				if(hit){
					playerCard.add(Deck1.getOneCard(true));
					playerarray[i].setOneRoundCard(playerCard);
					System.out.print("Hit! ");
					System.out.println(playerarray[i].getName()+"'s Cards now:");
					for(Card c : playerCard){
						c.printCard();
					}
				}
				else{
					System.out.println(playerarray[i].getName()+", Pass hit!");
					System.out.println(playerarray[i].getName()+", Final Card:");
					for(Card c : playerCard){
						c.printCard();
					}
				}
			}while(hit);
			
		
		}
		
	}

	private void ask_dealer_about_hits() {
		
		Dealer.hit_me(this);
		System.out.print("Dealer's hit is over!");
		// Ask dealer about hit
		
	}
	
	private void calculate_chips() {
		
		for(int i=0;i< playerarray.length;i++) {
        System.out.print("Dealer's card value is"+Dealer.getTotalValue()+" ,Cards:");
        Dealer.printAllCard();
		
		if(playerarray[i].getTotalValue()>21 && Dealer.getTotalValue()>21){
			System.out.println(",chips have no change! The Chips now is:" + playerarray[i].getCurrentChips());
			//hold the round
		}else if(playerarray[i].getTotalValue()<=21&&Dealer.getTotalValue()>21){
			playerarray[i].increaseChips(pos_betArray[i]);
			System.out.println(" ,Get "+pos_betArray[i]+"Chips,the Chips now is: "+playerarray[i].getCurrentChips());
			//win the round
		}else if(playerarray[i].getTotalValue()>21&&Dealer.getTotalValue()<=21){
			System.out.println(", Loss "+pos_betArray[i]+"Chips,the Chips now is: "+playerarray[i].getCurrentChips());
			//loss the round
		}else if(playerarray[i].getTotalValue()>Dealer.getTotalValue()&&playerarray[i].getTotalValue()<=21){
			playerarray[i].increaseChips(pos_betArray[i]);
			System.out.println(", Get "+pos_betArray[i]+"Chips,the Chips now is: "+playerarray[i].getCurrentChips());
			//win the round
		}else if(playerarray[i].getTotalValue()<Dealer.getTotalValue()&&Dealer.getTotalValue()<=21){
			System.out.println(", Loss "+pos_betArray[i]+"Chips,the Chips now is: "+playerarray[i].getCurrentChips());
			//loss the round
		}else{
			System.out.println(",chips have no change! The Chips now is:" + playerarray[i].getCurrentChips());
		}
		
	  }
		
	}

	public int[] get_palyers_bet() {
		
			return pos_betArray;
		
	}



	public void play() {
		ask_each_player_about_bets();
		distribute_cards_to_dealer_and_players();
		ask_each_player_about_hits();
		ask_dealer_about_hits();
		calculate_chips();
		
	}


	
}
