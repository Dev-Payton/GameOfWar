package ChapterFive.GameOfWar.GameOfWarGame;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
    private ArrayList<Card> deck = new ArrayList<>(52); // The deck of cards that is encapsulated by the DeckOfCards class, this is the forefront of the class, every method of this class should manipulate this array in some sort of way

    public DeckOfCards() {
        setOrderedDeck();
        setRandomDeckOrder();
    }

    public void setOrderedDeck() { // Used in the DeckOfCards constructor then to set the initialization of the deck arrayList. Another reason why need to set an ordered deck isn't because of the suit's but because we use the suites to manage the number of each face value, so that there isn't a random number of faces in the deck/
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 14; j++) {
                deck.add(new Card(i, j));
            }
        }
    }

    public void wonWar(ArrayList<Card> wonWar){
        ArrayList<Card> wonWarTmpArray = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            wonWarTmpArray.add(deck.get(0));
            deck.remove(0);
        }
        this.deck.addAll(wonWarTmpArray);
        this.deck.addAll(wonWar);
    }

    public ArrayList<Card> lostWar() {
        ArrayList<Card> lostWarTmpArray = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lostWarTmpArray.add(deck.get(0));
            deck.remove(0);
        }
        return lostWarTmpArray;


    }

    public Card getSpecificCardIndex(int x){
       return this.deck.get(x);
    }

    public void setRandomDeckOrder() { // Used in the DeckOfCards constructor after the setOrderedDeck method , to set up the game with a shuffled deck before manipulation. This method uses a method from the array list's methods
        Collections.shuffle(deck);
    }

    public Card pullTopCardFromDeck() { // Used to pull the card from the top of the deck to then be compared against another player's card objects
        return deck.get(0);
    }

    public void removeTopCardFromDeck() { // Used to remove the top card of the deck after the player has drawn the card
        deck.remove(0);
    }

    public void winDrawnCards(Card wonCard) {
        deck.add(deck.get(0));
        deck.remove(0);
        deck.add(wonCard);
    }

    public int getCardCount() {
        return this.deck.size();
    }

    public void displayWholeDeck() { // This is used ot display the current cards in a given deck, this will call upon the individual card objects's method to return the card info to a string format so that we can print it here
        for (Card c : deck) {
            System.out.println(c.cardInfoToString());
        }
    }

    public void dropDeck() { // This is used to drop an entire deck, my thought process is that this will be used in the splitDeck methods below for the individual player, since each new DeckOfCards is initialized with a new standard deck, we need to first drop the tmp deck's deck of cards before we start assigning the elements from the parent arrayList.
        this.deck.clear();
    }

    // My rational for splitting the decks and returning an entire new class is so that each player can still manage their own deck's without interference of the other player.
    public DeckOfCards splitDeckForComputer() { // This will split the parent deck passed to both the Computer and the Player class, this method will split the first 26 cards and assign them to the empty tmp deck we dropped
        DeckOfCards tmpComputerDeck = new DeckOfCards();
        tmpComputerDeck.dropDeck();

        ArrayList<Card> computerDeck = new ArrayList<>();
        for (int i = 0; i <= 25; i++) {
            tmpComputerDeck.deck.add(deck.get(i));
        }
        return tmpComputerDeck;

    }

    public DeckOfCards splitDeckForPlayer() {// This will split the parent deck passed to both the Computer and the Player class, however this will split the last 26 cards from the parent deck and assign them to an empty tmp deck we dropped
        DeckOfCards tmpPlayerDeck;
        tmpPlayerDeck = new DeckOfCards();
        tmpPlayerDeck.dropDeck();
        ArrayList<Card> playerDeck = new ArrayList<>();
        for (int i = 26; i <= 51; i++) {
            tmpPlayerDeck.deck.add(deck.get(i));
        }
        return tmpPlayerDeck;
    }


}







