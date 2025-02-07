import java.util.ArrayList;
import java.util.Collections;

/**
 * The Deck class is an Arraylist of 52 Cards and deals a single
 * Card at a time removing each from the top of the deck.
 */
public class Deck {

    private ArrayList<Card> deck = new ArrayList<>();

    /**
     * Parameterized constructor the build a new deck of 52 cards
     * either shuffled or not shuffled depending on the parameter
     * @param shuffle true to shuffle deck
     * @throws Exception if any value is out of range while building the deck
     */
    public Deck(boolean shuffle) throws Exception {
        if (shuffle)
        {
            buildDeck();
            shuffleDeck();
        }
        else
        {
            buildDeck();
        }
    }

    /**
     * Builds the deck of 52 cards using a nested for-loop
     * @throws Exception if i or j is out of range
     */
    private void buildDeck() throws Exception {
        for (int i = 1; i <= 4; i++)
        {
            for (int j = 1; j <= 13; j++)
            {
                Card card = new Card(j, i, true);
                deck.add(card);
            }
        }
    }

    /**
     *  Shuffled the arraylist of Cards
     */
    private void shuffleDeck()
    {
        Collections.shuffle(deck);
    }

    /**
     * Returns a single card from the top of the deck
     * @return a single card from the top of the deck
     * @throws Exception if deck is out of cards
     */
    public Card Deal() throws Exception {
        if (deck.size() > 1)
        {
            Card card = deck.get(0);
            deck.remove(0);
            return card;
        }
        else
        {
            throw new Exception("Deck is out of cards.");
        }
    }

    /**
     * Override of the base class toString
     * @return string representation of the arraylist of cards
     */
    @Override
    public String toString() {
        return "deck => " + deck;
    }
}
