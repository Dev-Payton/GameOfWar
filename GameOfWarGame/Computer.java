package ChapterFive.GameOfWar.GameOfWarGame;



public class Computer {



    private final String COMPUTER = "Computer";
    private DeckOfCards deck;
    public Computer(DeckOfCards deck){
        this.deck = deck;
    }
    public DeckOfCards getDeck(){
        return deck;
    }



    public String getComputerName(){
        return COMPUTER;
    }

}

