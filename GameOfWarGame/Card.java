package ChapterFive.GameOfWar.GameOfWarGame;


public class Card {
    private int face;
    private int suit;

    private enum Face {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

        final int faceCount;

        Face(int faceAssign) {
            this.faceCount = faceAssign;
        }
    }

    private enum Suit {
        SPADES(1), HEARTS(2), DIAMONDS(3), CLUBS(4);
        final int suitCount;

        Suit(int suitAssign) {
            this.suitCount = suitAssign;
        }

    }


    public Card() {
        int randomNumber = (int) (Math.random() * 4 + 1);
        for (Suit r : Suit.values()) {
            if (r.suitCount == randomNumber)
                this.suit = r.suitCount;

        }
        randomNumber = (int) (Math.random() * 13 + 1);
        for (Face f : Face.values()) {
            if (f.faceCount == randomNumber)
                this.face = f.faceCount;

        }
    }

    public Card(int suit, int face) {
        for (Suit r : Suit.values()) {
            if (r.suitCount == suit)
                this.suit = r.suitCount;

        }
        for (Face f : Face.values()) {
            if (f.faceCount == face)
                this.face = f.faceCount;

        }
    }

    public int getFace() {
        return face;
    }


    public String cardInfoToString() {
        for (Suit i : Suit.values()) {
            if (i.suitCount == suit) {
                String substring = i.toString().toLowerCase().substring(1, i.toString().length());
                if (face == 1) {
                    return "Ace" + " of " + i.toString().charAt(0) + substring + "'s";
                } else if
                (face >= 11) {
                    if (face == 11)
                        return "Jack" + " of " + i.toString().charAt(0) + substring + "'s";
                    else if (face == 12)
                        return "Queen" + " of " + i.toString().charAt(0) + substring + "'s";
                    else if (face == 13)
                        return "King" + " of " + i.toString().charAt(0) + substring + "'s";
                }
                if (face <= 10) {
                    return face + " of " + i.toString().charAt(0) + substring + "'s";
                }


            }


        }
        return null;
    }


}