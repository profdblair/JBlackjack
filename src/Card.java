/**
 *
 */
public class Card {

    private int value;
    private String strSuit;
    private String strValue;
    boolean isFaceUp;

    /**
     * Parameterized constructor
     * @param value 1 - 13
     * @param suit 1 - 4
     * @param isFaceUp true or false
     * @throws Exception if value or suit is out of range
     */
    public Card(int value, int suit, boolean isFaceUp) throws Exception {
        this.value = value;
        this.isFaceUp = isFaceUp;
        assignValue(value, suit, isFaceUp);
    }

    /**
     * This private method checks incoming values to be within range and
     *          converts value and suit to the string equivalent
     * @param value 1 - 13
     * @param suit 1 - 4
     * @param isFaceUp true or false
     * @throws Exception  if value or suit is out of range
     */
    private void assignValue(int value, int suit, boolean isFaceUp) throws Exception {
        try
        {
            if (value < 1 || value > 13)
                throw new Exception("Card value out of range. Must be 1 - 13");

            if (suit < 1 || suit > 4)
                throw new Exception("Suit value out of range. Must be 1 - 4");

            this.value = value;
            convertValueToString(value);

            // if Jack, Queen, or King, set to 10
            if (value > 10)
            {
                this.value = 10;
            }
            // if 1 (Ace) lets set it to 11 by default
            if (value == 1)
            {
                this.value += 10;
            }

            convertSuitToString(suit);

            this.isFaceUp = isFaceUp;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * gets the actual integer value of card
     * @return int value
     */
    public int GetValue()
    {
        return value;
    }

    /**
     * This private method takes an int value and translates it to a string
     * @param val 1 - 13
     * @throws Exception if value is outside valid range
     */
    private void convertValueToString(int val) throws Exception {
        switch (val)
        {
            case 1:
                strValue = "ACE";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                strValue = String.valueOf(val);
                break;
            case 11:
                strValue = "JACK";
                break;
            case 12:
                strValue = "QUEEN";
                break;
            case 13:
                strValue = "KING";
                break;
            default:
                throw new Exception("Card value must be between 1 and 13.");
        }
    }

    /**
     * converts the suit integer to a string representation,
     *          example: 1 = Clubs, 2 = Diamonds, 3 = Hearts, 4 = Spades
     *
     * @param suit 1 - 4
     */
    void convertSuitToString(int suit) throws Exception
    {
        switch (suit)
        {
            case 1:
                strSuit = "CLUBS";
                break;
            case 2:
                strSuit = "DIAMONDS";
                break;
            case 3:
                strSuit = "HEARTS";
                break;
            case 4:
                strSuit = "SPADES";
                break;
            default:
                throw new Exception("Suit must be a value between 1 and 4.");
        }
    }

    @Override
    public String toString() {
        return strValue + " " + strSuit;
    }
}
