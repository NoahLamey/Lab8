import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
    private static final Map<Rank, Integer> CARD_VALUES = new HashMap<>();

    static {
        for (Rank rank : Rank.values()) {
            if (rank.ordinal() <= Rank.TEN.ordinal()) {
                CARD_VALUES.put(rank, rank.ordinal() + 2); 
            } else if (rank == Rank.ACE) {
                CARD_VALUES.put(rank, 11);
            } else {
                CARD_VALUES.put(rank, 10); 
            }
        }
    }

    private static final int MAX_VALUE = 21;
    private List<Card> cards;
    private int value;
    private int numAcesAs11;

    public BlackjackHand(Card c1, Card c2) {
        cards = new ArrayList<>();
        value = 0;
        numAcesAs11 = 0;
        addCard(c1);
        addCard(c2);
    }

    public void addCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("null");
        }
        if (value < MAX_VALUE) {
            cards.add(card);
            int cardVal = CARD_VALUES.get(card.getRank());
            value += cardVal;
            if (card.getRank() == Rank.ACE) {
                numAcesAs11++;
            }
        }
    }

    public int getValue() {
        while (value > MAX_VALUE && numAcesAs11 > 0) {
            value -= 10;
            numAcesAs11--;
        }
        return value;
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public static Map<Rank, Integer> getCardValues() {
        return new HashMap<>(CARD_VALUES);
    }
    @Override
    public String toString() {
        return cards.toString();
    }
}
