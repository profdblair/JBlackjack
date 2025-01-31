import java.util.Scanner;

/**
 * This is a basic blackjack game test-driver but could be used for game
 *        with a few modifications
 * TODO - show winner if dealer and player not busted
 *      - show score summary for dealer and player at end of game
 *      - loop to play again y/n
 *      - format output better
 *      - show dealer hand at first, one card up and one down
 */
public class BlackJack {

    // the main is the entry point for all java applications
    public static void main(String[] args) {

        // Default threshold used by dealer to stop taking another card
        int threshold = 17;

        try {
            Player player = new Player("Atticus Finch", threshold, false);
            Player dealer = new Player("Dealer", threshold, true);

            Deck deck = new Deck(true);

            PlayBlackJack(player, deck);
            PlayBlackJack(dealer, deck);

            DetermineOutcomeOfGame(player, dealer);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @param player is the player or dealer (autoplay), whichever that is currently active
     * @param deck playing card starts at 52 and is reduced by one on every deal
     * @throws Exception rethrows any exception from method calls below
     */
    static void PlayBlackJack(Player player, Deck deck) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean autoplay = player.isDealer;

        // add two cards to each hand
        player.AddCard(deck.Deal());
        player.AddCard(deck.Deal());

        while (true)
        {
            if(autoplay) {
                if (player.Score() < player.GetThreshold())
                {
                    try
                    {
                        player.AddCard(deck.Deal());
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                        throw e;
                    }
                }
                else
                {
                    System.out.println();
                    if (player.Score() > 21)
                        player.isBusted = true;

                    System.out.println(player.ShowHand());
                    System.out.println("Score for " + player.GetName() + " " + player.Score());
                    break;
                }
            }
            else {
                System.out.println();
                System.out.println(player.ShowHand());
                System.out.println("Score for " + player.GetName() + " " + player.Score());
                if(player.Score() > 21)
                {
                    player.isBusted = true;
                    System.out.println("You are BUSTED");
                    break;
                }
                else
                {
                    System.out.print("Would you like a card? ");
                    String input = scanner.nextLine();
                    if(input.equalsIgnoreCase("Y")) {
                        player.AddCard(deck.Deal());
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Determines who won, lost, or tied the game
     * @param p1 is player
     * @param p2 is dealer
     */
    static void DetermineOutcomeOfGame(Player p1, Player p2)
    {
        if(!p1.isBusted && !p2.isBusted)
        {
            System.out.println(p1.name + " and " + p2.name + " not busted");
            // TODO
            // calculate winner
        }
        if(!p1.isBusted && p2.isBusted)
        {
            System.out.println(p1.name + " Not busted, " + p2.name + " busted so " + p1.name + " wins");
        }
        if(p1.isBusted && !p2.isBusted)
        {
            System.out.println( p1.name + " Busted, " + p2.name + " not busted so " + p2.name + " wins");
        }
        if(p1.isBusted && p2.isBusted)
        {
            System.out.println( p1.name + " and " + p2.name + " busted so nobody wins");
        }
    }
}
