import java.util.ArrayList;

public class Player {

    String name;
    int winThreshold;
    boolean isBusted;
    boolean isDealer;
    ArrayList<Card> hand = new ArrayList<>();

    /**
     * Parameterized constructor for a player
     * @param name of player
     * @param threshold where the player stops automatically takes a card if dealer
     * @param dealer true if the player is a dealer
     * @throws Exception if threshold is out of range
     */
    public Player(String name, int threshold, boolean dealer) throws Exception {
        this.name = name;

        if (threshold < 1 || threshold > 21)
            throw new Exception("Threshold must be between 1 and 21");

        winThreshold = threshold;
        isBusted = false;
        //isWinner = false;
        isDealer = dealer;
    }

    /**
     * Get the threshold that a player (dealer) stops taking a card
     * @return threshold
     */
    public int GetThreshold()
    {
        return winThreshold;
    }

    /**
     * Public access to the players score
     * @return an integer value for the score
     */
    public int Score()
    {
        return calculateScore();
    }

    /**
     * Currently not used, but could be used if the display show face-down cards
     * @param faceUp true if cards are face-up
     */
    public void FlipAllCards(boolean faceUp)
    {
        for (Card card : hand) {
            card.isFaceUp = faceUp;
        }
    }

    /**
     * Add a card to the player hand
     * @param card is the Card added to the players hand
     */
    public void AddCard(Card card)
    {
        hand.add(card);
    }

    /**
     * Returns a string optimized by using a StringBuilder
     * @return a string representing the players hand
     */
    public String ShowHand()
    {
        StringBuilder sb = new StringBuilder();
        for (Card card : hand)
        {
            sb.append(card.toString());
            sb.append(", ");
        }
        return sb.toString();
    }

    /**
     * Gets the name of the player
     * @return the name of the player
     */
    String GetName()
    {
        return name;
    }

    /**
     * Used in the Player class only (private)
     * @return an integer value representing a blackjack hand score
     */
    private int calculateScore()
    {
        int score = 0;
        int numberOfAces = 0;

        for (Card card : hand)
        {
            int val = card.GetValue();
            if (val == 11)
            {
                numberOfAces++;
            }
            score += val;
        }

        if (score > 21)
        {
            while (true)
            {
                if (numberOfAces > 0)
                {
                    score = score - 10;
                    numberOfAces--;
                }
                else
                    break;
            }
        }

        return score;
    }

}
