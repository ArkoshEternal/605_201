package Project2;

import java.util.Scanner;
import java.util.Queue;

/**
 * Main class that runs the Blackjack game simulation.
 * Handles game loop, player input, and overall game orchestration.
 * 
 * @author 
 * @version 1.0
 */
public class BlackJackGameSimulator {

    /**
     * Entry point for the Blackjack game.
     * Handles game setup, user input, and round progression.
     * 
     * @param args Command line arguments (unused).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!");

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        Dealer dealer = new Dealer();
        Deck deck = new Deck();

        int handCount = 0;
        final int RESHUFFLE_AFTER = 4;

        boolean playing = true;

        while (playing) {
            System.out.println("\n--- New Hand ---");

            // Reshuffle deck if needed
            if (handCount % RESHUFFLE_AFTER == 0) {
                deck.shuffle();
                System.out.println("Deck reshuffled!");
            }

            handCount++;

            // Get Bet Amount from User
            System.out.print("Enter your bet amount (current balance: $" + player.getMoney() + "): ");
            int bet;
            while (true) {
                try {
                    bet = Integer.parseInt(scanner.nextLine());
                    if (bet <= 0 || bet > player.getMoney()) {
                        System.out.print("Invalid bet. Please enter a valid amount: ");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a number: ");
                }
            }
            // Deduct bet from player's money   
            if (player.getMoney() < bet) {
                System.out.println("Not enough money to bet. Game over.");
                break;
            }
            player.takeMoney(bet);

            // Deal initial cards
            dealer.dealCard(player, deck.drawCard());
            dealer.dealCard(player, deck.drawCard());

            Card faceUpCard = deck.drawCard(); // face up
            dealer.getHand().add(faceUpCard);
            Card faceDownCard = deck.drawCard(); // face down
            dealer.getHand().add(faceDownCard);

            System.out.println(player.getName() + "'s hand: " + displayHand(player.getHand()));
            System.out.println("Dealer shows: " + faceUpCard);

            // Check for immediate Blackjack
            int playerScore = calculateScore(player.getHand());
            if (playerScore == 21) {
                System.out.println("Blackjack! You win!");
                player.giveMoney(bet * 2);
                clearHands(player, dealer);
                continue;
            }

            // Player turn
            boolean playerTurnOver = false;
            while (!playerTurnOver) {
                System.out.print("Hit or Stay? (h/s): ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("h")) {
                    dealer.dealCard(player, deck.drawCard());
                    System.out.println("Your hand: " + displayHand(player.getHand()));

                    playerScore = calculateScore(player.getHand());
                    if (playerScore > 21) {
                        System.out.println("Bust! You lose.");
                        playerTurnOver = true;
                    }
                } else if (choice.equalsIgnoreCase("s")) {
                    playerTurnOver = true;
                } else {
                    System.out.println("Invalid input. Please enter 'h' or 's'.");
                }
            }

            // Dealer turn
            if (playerScore <= 21) {
                System.out.println("Dealer's hidden card: " + faceDownCard);
                int dealerScore = calculateScore(dealer.getHand());
                while (dealerScore < 17) {
                    dealer.getHand().add(deck.drawCard());
                    dealerScore = calculateScore(dealer.getHand());
                }

                System.out.println("Dealer's hand: " + displayHand(dealer.getHand()));

                // Determine winner
                if (dealerScore > 21 || playerScore > dealerScore) {
                    System.out.println("You win!");
                    player.giveMoney(bet * 2);
                } else if (dealerScore == playerScore) {
                    System.out.println("Push! Bet returned.");
                    player.giveMoney(bet);
                } else {
                    System.out.println("Dealer wins.");
                }
            }

            clearHands(player, dealer);

            // If player is bankrupt, end game
            if (player.getMoney() <= 0) {
                System.out.println("You are out of money! Game over.");
                break;
            }

            // Ask to continue
            System.out.print("Play another hand? (y/n): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                playing = false;
            }
        }

        System.out.println("Thanks for playing, " + player.getName() + "! You leave with $" + player.getMoney());
        scanner.close();
    }

    /**
     * Clears the hands of both the player and the dealer.
     * 
     * @param player The player whose hand is to be cleared.
     * @param dealer The dealer whose hand is to be cleared.
     */
    private static void clearHands(Player player, Dealer dealer) {
        player.discardHand();
        dealer.discardHand();
    }

    /**
     * Displays the hand of cards as a string.
     * 
     * @param hand The hand of cards to display.
     * @return A string representation of the hand.
     */
    private static String displayHand(Queue<Card> hand) {
        StringBuilder sb = new StringBuilder();
        for (Card card : hand) {
            sb.append(card.toString()).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "Empty hand";
    }

    /**
     * Calculates the total score of a given hand.
     * Aces are counted as 11 unless it would bust the hand, then counted as 1.
     * 
     * @param hand The hand of cards to score.
     * @return The total point value of the hand.
     */
    private static int calculateScore(Queue<Card> hand) {
        int total = 0;
        int aces = 0;

        for (Card card : hand) {
            int value = card.getValue();
            if (card.getRank().equals("A")) {
                aces++;
                value = 11;
            }
            total += value;
        }

        // Downgrade Aces from 11 to 1 as needed
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    } // end of calculateScore method
} // end of BlackJackGameSimulator class
