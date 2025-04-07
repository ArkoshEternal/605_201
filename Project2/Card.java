package Project2;

/**
 * Represents a playing card used in Blackjack.
 * Contains rank, suit, and value information.
 * Face cards (J, Q, K) have a value of 10.
 * Ace (A) has a default value of 1 (can be treated as 11 in hand calculation).
 * 
 * @author 
 * @version 1.0
 */
public class Card {

    /**
     * Constructs a new card with the given rank and suit.
     * Automatically sets the Blackjack value.
     * 
     * @param rank The rank of the card (2-10, J, Q, K, A).
     * @param suit The suit of the card (Hearts, Diamonds, Clubs, Spades).
     */
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        this.value = determineValue(rank);
    }

    /**
     * Determines the Blackjack value of a card based on its rank.
     * 
     * @param rank The rank of the card.
     * @return The Blackjack value.
     */
    private int determineValue(String rank) {
        switch (rank) {
            case "J":
            case "Q":
            case "K":
                return 10;
            case "A":
                return 1; // Will be treated as 11 in hand calculation if appropriate
            default:
                return Integer.parseInt(rank);
        }
    }

    /**
     * Gets the card's rank.
     * @return The card's rank.
     */
    public String getRank() {
        return rank;
    }

    /**
     * Gets the card's suit.
     * @return The card's suit.
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Gets the card's value in Blackjack.
     * @return The card's value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a string representation of the card.
     * @return A string in the format "Rank of Suit", e.g., "A of Hearts".
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    // Class Members
    private String rank;
    private String suit;
    private int value;

} // end of Card class
