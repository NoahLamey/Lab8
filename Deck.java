import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
    	cards = new ArrayList<>();
        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values(); 
        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }
    

    public int size() {
        return cards.size();
    }

    public Card draw() {
        if (cards.isEmpty()) 
        	return null;
        return cards.remove(0);  
    }

    public List<Card> draw(int count) {
        List<Card> cardsDrawn = new ArrayList<>();
        for (int i = 0; i < count && !cards.isEmpty(); i++) {
            cardsDrawn.add(draw());
        }
        return cardsDrawn;
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCardsByRank(Rank rank) {
        List<Card> cardRanks = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (card.getRank() == rank) {
                cardRanks.add(card);
            }
        }
        return cardRanks;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
