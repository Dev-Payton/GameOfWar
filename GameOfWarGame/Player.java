package ChapterFive.GameOfWar.GameOfWarGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private DeckOfCards deck;

    private static final Scanner SCANNER = new Scanner(System.in);

    private String playerName;

    public Player(DeckOfCards deck) {
        this.deck = deck;
    }

    public void playerTurn() {

    }

    public DeckOfCards getDeck(){
        return deck;
    }

    public void setPlayerName() {
        while (true) {
            System.out.println("Please enter a name ");
            String usernameInput = SCANNER.nextLine();

            if (usernameInput.isEmpty()) {
                System.out.println("Input Is Empty: Please enter another name ");

            } else {
                this.playerName = usernameInput;
                break;
            }
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public static void closeScanner() {
        SCANNER.close();
    }
}
