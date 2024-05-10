package assignmentFour_000879513;

/**
 * This class is one of the Model Classes making up the card game. The card consists of two instance variables, which
 * are both private, and are not changed when the card object is created. The 'rank' represents the cards number, and
 * the 'suit' represents which suits the card has. The class includes a constructor for creating an instance of the
 * class/object, and the rank and suit are specified using the 'this' keyword. The class also has 'getter' methods
 * responsible for retrieving the cards rank, suit, as well as the cards value. Additionally, the class has a 'toString'
 * method which reports the rank, and suit of the card.
 *
 * @author BRENDAN DILEO, 000879513
 */
public class Card {
    /**
     * Instance variables:
     * 'rank' is of type int, and is responsible for a cards rank (number).
     * 'suit' is of type int, and is responsible for a cards suit (hearts, spades, diamonds, clubs, or more).
     */
    private int rank;
    private int suit;

    /**
     * Constructor for the new card object taking 'rank' and 'suit' as parameters. When an instance of the card is
     * created, both of the variables will be specified.
     *
     * @param rank which is the rank (number) of a card.
     * @param suit which is the suit of the card.
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * This method retrieves (gets) the cards rank (number).
     *
     * @return rank, which is the cards rank.
     */
    public int getRank() {
        return rank;
    }

    /**
     * This method retrieves (gets) the cards suit.
     *
     * @return suit, which is the integer representation of the cards suit.
     */
    public int getSuit() {
        return suit;
    }

    /**
     * This method is responsible for retrieving the cards value which is determined by its rank multiplied by its suit.
     *
     * @return rank * suit, which is the calculation responsible for determining a cards value.
     */
    public int getCardValue() {
        return rank * suit;
    }

    /**
     * This method is responsible for reporting the cards rank and suit in the form of a String.
     *
     * @return a String representation of the cards attributes.
     */
    @Override
    public String toString() {
        return "Card: " + "Rank: " + rank + ", Suit: " + suit;
    }
}