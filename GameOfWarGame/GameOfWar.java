package ChapterFive.GameOfWar.GameOfWarGame;

import java.util.Comparator;
import java.util.Scanner;

public class GameOfWar {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        DeckOfCards gameDeck = new DeckOfCards();
        playGame(new Player(gameDeck.splitDeckForPlayer()), new Computer(gameDeck.splitDeckForComputer()));
    }


    public static void playGame(Player player, Computer computer) {


        System.out.println("Game Of War\n\tVersion:0.1");
        System.out.println();
        player.setPlayerName();
        while (true) {

            while (true) {
                System.out.println("Press enter for both parties to flip their cards: ");
                String nextWar = SCANNER.nextLine();
                if (nextWar.isEmpty())
                    break;
            }
            System.out.println("\n" + player.getPlayerName() + " Placed:            " + computer.getComputerName() + " Placed: \n" + player.getDeck().pullTopCardFromDeck().cardInfoToString() + "             " + computer.getDeck().pullTopCardFromDeck().cardInfoToString());
            if (player.getDeck().pullTopCardFromDeck().getFace() == computer.getDeck().pullTopCardFromDeck().getFace()) {
                System.out.println("War Has Been Declared");
                System.out.println("Both Players must draw 3 cards face down and one more face up.");
                System.out.println();
                while (true) {
                    System.out.println(); // Used to place 3 face down cards
                    System.out.println("\n" + player.getPlayerName() + " Face up Card:            " + computer.getComputerName() + " Face up Card: \n" + player.getDeck().getSpecificCardIndex(1).cardInfoToString() + "             " + computer.getDeck().getSpecificCardIndex(1).cardInfoToString());
                    if (!(player.getDeck().getSpecificCardIndex(1).getFace() == computer.getDeck().getSpecificCardIndex(1).getFace())) {
                        if (player.getDeck().getSpecificCardIndex(1).getFace() > computer.getDeck().getSpecificCardIndex(1).getFace()) {
                            player.getDeck().wonWar(computer.getDeck().lostWar());
                            System.out.println(player.getPlayerName() + "Has won the war!");
                            break;
                        } else if (computer.getDeck().getSpecificCardIndex(1).getFace() > player.getDeck().getSpecificCardIndex(1).getFace()) {
                            computer.getDeck().wonWar(player.getDeck().lostWar());
                            System.out.println(computer.getComputerName() + "Has won the war!");

                            break;
                        }
                    }

                    System.out.println();
                }
            } else {
                if (player.getDeck().pullTopCardFromDeck().getFace() > computer.getDeck().pullTopCardFromDeck().getFace()) {
                    System.out.println(player.getPlayerName() + ": Has won the round!");
                    player.getDeck().winDrawnCards(computer.getDeck().pullTopCardFromDeck());
                    computer.getDeck().removeTopCardFromDeck();

                } else {
                    System.out.println(computer.getComputerName() + ": Has won the round!");
                    computer.getDeck().winDrawnCards(player.getDeck().pullTopCardFromDeck());
                    player.getDeck().removeTopCardFromDeck();

                }
                System.out.println(player.getPlayerName() + ": Has " + player.getDeck().getCardCount() + " Cards!" + " AND " + (computer.getComputerName() + ": Has " + computer.getDeck().getCardCount()));

            }


        }


    }


}
