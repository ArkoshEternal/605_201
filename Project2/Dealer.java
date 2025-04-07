package Project2;

import java.util.LinkedList;
import java.util.Queue;
/**
 * This class represents a dealer in the game.
 * It contains properties for the dealer's hand of cards.
 * It also includes methods to deal cards to players and manage the dealer's hand.
 * @author Duncan Parke
 * @version 1.0
 */
public class Dealer {

    // Constructor
    /**
     * Constructor to create a dealer.
     * The name is set to "Dealer" by default.
     */
    public Dealer() {
        this.hand = new LinkedList<>();
        this.name = "Dealer"; // Default name for the dealer
    }    

    // Deal card to player
    /**
     * Method to deal a card to a player or the dealer.
     * @param player The player to deal the card to. If null, the dealer takes the card.
     * @param card The card to deal.
     */
    public void dealCard(Player player, Card card) {
        if (player != null) {
            player.takeCard(card);
        } else {
            hand.add(card);
        }
    }

    // Discard Hand at end of round
    /**
     * Method to discard the dealer's hand at the end of a round.
     */
    public void discardHand() {
        hand.clear();
    }

    // Getters
    /**
     * Gets the dealer's hand.
     * @return The dealer's hand.
     */
    public Queue<Card> getHand() {
        return hand;
    }

    /**
     * Gets the dealer's name.
     * @return The dealer's name.
     */
    public String getName() {
        return name;
    }

    // Setters
    /**
     * Sets the dealer's hand.
     * @param hand The hand to set.
     */
    public void setHand(Queue<Card> hand) {
        this.hand = hand;
    }

    // Class Members
    private Queue<Card> hand; // The dealer's hand of cards
    private String name; // The dealer's name
    
} // end of Dealer class
