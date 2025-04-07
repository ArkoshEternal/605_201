package Project2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents a player in the game.
 * It contains properties for the player's name and hand of cards.
 * It also includes methods to get the player's name and hand.
 * @author Duncan Parke
 * @version 1.0
 */

public class Player {

    // Default constructor
    /**
     * Default constructor to create a player with no specific name.
     */
    public Player() {
        this.name = "Player";
        this.money = 100; // Default money amount
    }

    // Constructor
    /**
     * Constructor to create a player with a specific name.
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.money = 100; // Default money amount
    }    

    // Take card from dealer
    /**
     * Method to take a card from the dealer and add it to the player's hand.
     * @param card The card to add to the player's hand.
     */
    public void takeCard(Card card) {
        hand.add(card);
    }

    // Discard Hand at end of round
    /**
     * Method to discard the player's hand at the end of a round.
     */
    public void discardHand() {
        hand.clear();
    }

    // Function which takes money from the player
    /**
     * Method to take money from the player.
     * @param amount The amount of money to take.
     */
    public void takeMoney(int amount) {
        money -= amount;
    }
    // Function which gives money to the player
    /**
     * Method to give money to the player.
     * @param amount The amount of money to give.
     */
    public void giveMoney(int amount) {
        money += amount;
    }

    // Function which returns the amount of money the player has
    /**
     * Method to get the amount of money the player has.
     * @return The amount of money the player has.
     */
    public int getMoney() {
        return money;
    }
    // Getters
    /**
     * Gets the name of the player.
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the player's hand of cards.
     * @return The player's hand of cards.
     */
    public Queue<Card> getHand() {
        return hand;
    }

    // Class Members
    private String name;
    // Queue of Cards
    private Queue<Card> hand = new LinkedList<Card>();
    // Money 
    private int money;

} // End of Player class
