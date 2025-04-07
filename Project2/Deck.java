package Project2;

import java.util.Collections;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a standard deck of 52 playing cards for Blackjack.
 * Provides functionality to shuffle and draw cards from the deck.
 * 
 * @author 
 * @version 1.0
 */
public class Deck {

    private Stack<Card> cards;
    private final String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
    private final String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

    /**
     * Constructs and initializes the deck with 52 standard playing cards.
     */
    public Deck() {
        cards = new Stack<>();
        buildDeck();
        shuffle();
    }

    /**
     * Builds a new full deck of 52 cards.
     * Called during construction and reshuffle.
     */
    private void buildDeck() {
        cards.clear();
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.push(new Card(rank, suit));
            }
        }
    }

    /**
     * Shuffles the current deck using Java's Collections utility.
     */
    public void shuffle() {
        List<Card> temp = new ArrayList<>(cards);
        Collections.shuffle(temp);
        cards = new Stack<>();
        cards.addAll(temp);
    }

    /**
     * Draws the top card from the deck.
     * If the deck is empty, rebuilds and reshuffles before drawing.
     * 
     * @return The top card from the deck.
     */
    public Card drawCard() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty. Rebuilding and reshuffling...");
            buildDeck();
            shuffle();
        }
        return cards.pop();
    }

    /**
     * Gets the number of remaining cards in the deck.
     * 
     * @return Number of cards left in the deck.
     */
    public int cardsRemaining() {
        return cards.size();
    }
} // end of Deck class
