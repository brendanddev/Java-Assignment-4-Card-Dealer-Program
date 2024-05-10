package assignmentFour_000879513;

import java.util.Random;

/**
 * This class is the other model class which makes up the card game. This class represents a deck of cards, which can be
 * shuffled, dealt, returned, guessed from, and can display various forms of the card values with the use of methods.
 * This class will consist of four instance variables, each of which are private for encapsulation, and play a part in
 * the use of the deck. The class uses a constructor to create an instance of the deck of cards, which takes two
 * parameters from the user. The class will also have methods that are dependent on values entered by the user to
 * shuffle the deck, deal some cards, return some cards, find the lowest card, highest card, reset the deck, and to
 * display values of the card. Majority of the classes methods rely on storing objects in, and the use of arrays.
 *
 * @author BRENDAN DILEO, 000879513.
 */

public class DeckOfCards {
    // Instance Variables:
    /**
     * 'cardsOfDeck' is of type Card[] array, and is responsible for storing all the Card Objects from the card class.
     * This array acts like the actual deck of cards.
     */
    private Card[] cardsOfDeck;
    /**
     * 'sizeOfDeck' is of type int, and is responsible for storing and keeping track of the number of cards in the deck.
     */
    private int sizeOfDeck;
    /**
     * 'maxRank' is of type int, and represents the maximum rank (number) in the deck of cards.
     */
    private int maxRank;
    /**
     * 'numberOfSuits' is of type int, and represents the number of suits a card can have in the deck.
     */
    private int numberOfSuits;

    /**
     * This constructor will create an instance of the 'DeckOfCards' class, and will take two parameters, 'maxRank', and
     * 'numberOfSuits' which are assigned to 'maxRank' and 'numberOfSuits' using the 'this' keyword. The size of the deck
     * is determined by the maximum rank, and the number of suits, and then a new array is initialized and created from
     * the 'cardsOfDeck' array, with a length of the decks size. This new array is created so that the instance
     * variable is not accessed externally, and only this new array can be accessed through methods. This new array then
     * uses a loop to put the Card Objects into the deck where the size is determined by the number of suits, and ranks
     * as specified in the assignment.
     *
     * @param maxRank, which is the maximum rank of card, in the deck of cards.
     * @param numberOfSuits, which is the number of possible suits, in the deck of cards.
     */
    public DeckOfCards(int maxRank, int numberOfSuits) {
        this.maxRank = maxRank;
        this.numberOfSuits = numberOfSuits;
        this.sizeOfDeck = maxRank * numberOfSuits;
        this.cardsOfDeck = new Card[sizeOfDeck];

        // Keeps track of the card objects index's for the new array containing the cards.
        int cardIndex = 0;
        // The assignment mentions that the constructor creates the combinations of card objects, and stores them in the
        // array which is why I have included the logic in the constructor. The outer for loop iterates through all
        // possible rank combinations for the card objects, where 'rankLoop' is the control variable, but also the
        // current cards rank. The inner for loop iterates through all possible suit combinations for the card objects,
        // where 'suitLoop' is the control variable, and represents the cards suit.
        for (int rankLoop = 0; rankLoop < maxRank; rankLoop++) {
            for (int suitLoop = 0; suitLoop < numberOfSuits; suitLoop++) {
                // A new card object is initialized and created with each combination of a rank, and suit, and is
                // then assigned into the 'cardsOfDeck' array at a different index controlled by the 'cardIndex'.
                cardsOfDeck[cardIndex] = new Card(rankLoop + 1, suitLoop + 1);
                // For each iteration of the loop, the cards index 'cardIndex' is incremented by 1.
                cardIndex++;
            }
        }
    }

    /**
     * This method is responsible for shuffling the deck of cards. The assignment says that the deck will need to be
     * shuffled repeatedly, randomly swapping pairs of cards in the array, which led me to this choice of shuffling.
     * I knew I needed a place to store a card, and then swap the placements to create the shuffle effect. Initially
     * I was doing a shuffle by just swapping the index's of two cards, but this was giving me an error when trying it
     * out because I was not getting a random index, so I used the instance of the random class. An instance of the
     * Random Class is declared and initialized to generate a random index of a card object in the deck. The for loop
     * iterates through the cards from the bottom (last card) to the top (first card), and uses a 'Fisher-Yates' style
     * structure to assign cards back and forth for the shuffle effect. This will allow for cards to be moved (shuffled)
     * around the deck randomly.
     */
    public void shuffleDeck() {
        // Instance of the random class is initialized.
        Random rand = new Random();
        // This for loop iterates through from the last card in the deck, to the first card.
        for (int index = cardsOfDeck.length - 1; index > 0; index--) {
            // 'randomCardPos' is declared and initialized to a random integer between 0, and the last card in the deck.
            // The 'index' represents where the card will be re-assigned to coming from the for loop.
            int randomCardPos = rand.nextInt(index + 1);
            // A new card object is initialized and assigned to the 'index'/control variable of the loop in the current
            // iteration. This is done so the card can be swapped back into this position later on.
            Card newCardPos = cardsOfDeck[index];
            // The card at the current 'index', is replaced with the card at the randomly chosen position/index
            // 'randomCardPos'.
            cardsOfDeck[index] = cardsOfDeck[randomCardPos];
            // The card at the randomly chosen index, is then re-assigned to the other cards original
            // index 'randomCardPos'. This makes for the initial index to be swapped with the random one, and then the
            // initial cards index is swapped back to the initial position.
            cardsOfDeck[randomCardPos] = newCardPos;
        }
    }

    /**
     * This 'getter' method is used to return the total number of cards in the deck. The total number of cards is
     * determined by the maximum rank, and the number of suits that are present.
     *
     * @return sizeOfDeck, which is the total number of cards in the deck.
     */
    public int getDeckSize() {
        return sizeOfDeck;
    }

    /**
     * This method will be used to return the value of the card with the largest (max) value in the deck of cards. It
     * iterates through each card in the deck starting at the second card (first index), and compares each one,
     * everytime a larger card is found, the 'maxCard' value will be reassigned. I used this logic because if the deck
     * was shuffled, then it is possible that the highest card could be scattered at a random spot in the deck.
     *
     * @return maxCard, which is the value of the card with the largest value in the deck.
     */
    public int maxCardValue() {
        // A variable 'maxCard' is assigned to the value of the card object at the 0th index/first position in the
        // 'cardsOfDeck' array. This is the card that will be continuously tested to see if there is a larger card.
        int maxCard = cardsOfDeck[0].getCardValue();
        // The for loop iterates through the 'cardsOfDeck' array, starting at 1 as the current card, (index 1/second card)
        // as the first card in the deck is the card being compared.
        for (int i = 1; i < cardsOfDeck.length; i++) {
            // The if statement checks if the value of 'maxCard' is less than the value of the card at the current index,
            // if it is, the value of 'maxCard' is re-assigned to the value of the card at the 'i'th index.
            if (maxCard < cardsOfDeck[i].getCardValue()) {
                maxCard = cardsOfDeck[i].getCardValue();
            }
        }
        // Maximum cards value is returned.
        return maxCard;
    }

    /**
     * This method is responsible for finding the card with the lowest value in the deck. It iterates through from the
     * last card, to the first card instead of the first to last. Everytime it finds a card that is smaller than the
     * previous card, this card is the new minimum value. It will keep doing this until it hits 0 (the first card of the
     * deck). I chose not to just return 1, because I felt what if there were no 'Aces'/1's in the deck, then 1 would be
     * an incorrect minimum value. I also used this logic similar to the max, to incorporate the chance that the minimum
     * card is at a random spot in the deck.
     *
     * @return minCard, the value of the card with the lowest value in the deck.
     */
    public int minCardValue() {
        // A variable 'minCard' is assigned to the value of the card object at the last position of the 'cardsOfDeck'
        // array. This card/value will be compared in the loop to see if it is the lowest value of card in the deck.
        int minCard = cardsOfDeck[cardsOfDeck.length - 1].getCardValue();
        // This for loop iterates through the 'cardsOfDeck' array from the last card, to the first card.
        for (int i = cardsOfDeck.length - 1; i >= 0; i--) {
            // The if statement compares the value of 'minCard' to the value of the card at the current 'i'th index using
            // the 'getCardValue' method, if the current 'minCard' value is greater than the value of the current card,
            // the value of 'minCard' is re-assigned to the current cards value.
            if (minCard > cardsOfDeck[i].getCardValue()) {
                minCard = cardsOfDeck[i].getCardValue();
            }
        }
        // The minimum cards value is returned.
        return minCard;
    }

    /**
     * This method is used to deal a certain number of cards from the deck. The assignment mentions placing the top 'n'
     * cards into an array, and the returning this array, which led me to believe that I would assign a certain number
     * of cards 'n' from the current array into the new array. This will be done by declaring and initializing
     * a new array, which will consist of the cards dealt, and then this new array will be returned to show the cards that
     * have been dealt. The method will loop through the cards from 0, up to the number of requested cards to be dealt
     * 'n', and one by one the cards are assigned into the index's (controlled by 'i') of the new array of dealt cards.
     * It will deal the 'top' cards as the method will start from 0, which technically means it is dealing from the first
     * /'top' cards.
     *
     * @param n, the number of cards requested to be dealt from the deck.
     * @return cardsDealt, which is the array of cards that have been assigned into the new array representing the cards
     *         dealt.
     */
    public Card[] dealTopCards(int n) {
        // A new array is declared, and then initialized to the card objects with a length of 'n'/up to the value of 'n'.
        Card[] cardsDealt;
        cardsDealt = new Card[n];
        // This for loop iterates through from 0 - 'n', where 'n' is the number of cards the user has requested to be
        // dealt. The loop starts at 0 as the cards are being dealt from the top of the deck.
        for (int i = 0; i < n; i++) {
            // For each iteration in the loop, the index of the card found in 'cardsOfDeck' is assigned to the index 'i'
            // of the new array 'cardsDealt' as this array contains the cards that have been dealt and the number
            // of cards dealt will be the number of iterations up to 'n'.
            cardsDealt[i] = cardsOfDeck[i];
        }
        // The size of the deck 'sizeOfDeck' is decremented by the value of 'n', as the cards that have been dealt are
        // no longer in the deck. This is to avoid issues with returning any cards.
        sizeOfDeck = sizeOfDeck - n;
        // The array 'cardsDealt' which holds the cards that have been dealt to the user are returned.
        return cardsDealt;
    }

    /**
     * This method is used to reset the size of the deck back to its original state, where its original state is the
     * number of cards in the deck before any cards have been dealt, or returned.
     * Uses the 'this' keyword to re-access and assign the class's private instance variable.
     */
    public void resetDeckSize() {
        this.sizeOfDeck = cardsOfDeck.length;
    }

    /**
     * This method is used to return any cards dealt back to the dealer (deck), from the user. The purpose is to add
     * extra functionality within the program, so the user can actually return their cards. The method also makes sure
     * that if the user returns cards, then the size of the deck does not exceed the actual deck size before cards were
     * dealt or returned.
     *
     * @param n, which is the number of cards the user intends to return back to the deck/dealer.
     */
    public void returnDealtCards(int n) {
        // A variable 'deckTotal' is initialized to the current size of the deck, added by the number of cards the user
        // would like to return. This is so the deck does not exceed the initial number of cards in the deck when cards
        // are returned.
        int deckTotal = sizeOfDeck + n;
        // A variable 'maxDeckSize' is initialized to the total number of cards that can be in the deck, which is
        // the initial size of the deck before deals, or returned cards.
        int maxDeckSize = maxRank * numberOfSuits;
        // The if statement checks if 'deckTotal' is less than, or equal to 'maxDeckSize', it makes sure that when cards
        // are returned, the deck size does not exceed the initial size of the deck.
        if (deckTotal <= maxDeckSize) {
            // If the condition evaluates to true, 'sizeOfDeck' is assigned to the value of 'deckTotal' making sure the
            // correct number of cards goes back into the deck.
            sizeOfDeck = deckTotal;
            // If the condition evaluates to false, the size of the deck is set back to its initial state, which is the
            // initial size of the deck.
        } else {
            sizeOfDeck = maxDeckSize;
        }
    }

    /**
     * This method represents a String representation/report which includes the size of the deck of cards, the maximum
     * and minimum card values in the deck, as well as the top card, which is the card at the 0th index as this represents
     * the first/top card in the deck. The method also checks for an empty deck, and returns a statement if so.
     *
     * @return a String, which is a report of the size of deck, highest card, lowest card, the maximum value, the
     * top card, and last card values in the deck of cards. If the deck is empty, it returns that the deck is empty.
     */
    @Override
    public String toString() {
        // If statement that checks if the deck is empty.
        if (sizeOfDeck == 0) {
            return "\nThe Deck is empty!\n";
        // If the deck is not empty, the else block executes.
        } else {
            // Returns String representation of the 'cardsOfDeck's attributes. Uses line breaks '\n' to organize the info.
            return "\nIn the Deck Of Cards, " + "\n" +
                    "the number of cards are: " + sizeOfDeck + "\n" +
                    "the highest card is: " + maxRank + ",\n" +
                    "the lowest card is: " + minCardValue() + ",\n" +
                    "the maximum card value is: " + maxCardValue() + " (Maximum Rank * Number Of Suits), \n" +
                    "the top card in the deck is: " + cardsOfDeck[0] + ",\n" +
                    "the last card in the deck is: " + cardsOfDeck[cardsOfDeck.length - 1] + ". \n";
        }
    }

    /**
     * This method is used to create a histogram which calculates how frequently different card values are dealt from the
     * deck. I tried a for-each/enhanced loop at the start of my implementation, but I continued to get errors, so I stuck
     * with what I knew best, a standard for loop. The method starts by declaring and then initializing an array with a
     * length of multiplying the maximum rank, number of suits, and number of cards requested to be dealt. The method
     * iterates through 100,000 times as requested in the assignment, and for each iteration, the deck is shuffled, and
     * cards are dealt. The variable 'totalHandValue' which is keeping track of the calculated values of each deal, is
     * increased by adding the rank, and suit of the card. The histogram arrays index is incremented by the value of the
     * hand value.
     *
     * @param numberOfCards, which is the number of cards that will be dealt from the deck 100,000 times.
     * @return histogram, which is a new array representing how often each total card/hand value is present after calculating.
     */
    public int[] toHistogram(int numberOfCards) {
        // This array is declared and initialized to store all the total possible values after the 'numberOfCards' has
        // been dealt.
        int[] histogram;
        histogram = new int[maxRank * numberOfCards * numberOfSuits];
        // 'totalHandValue' is declared, it is responsible for tracking each value of cards after being dealt.
        int totalHandValue;
        // This loop iterates 100,000 times, and in each iteration, the deck is shuffled, and a certain number of cards
        // are dealt from the deck, depending on the 'numberOfCards' variable.
        for (int i = 0; i < 100_000; i++) {
            // 'shuffleDeck' method is called upon for each iteration of the loop.
            shuffleDeck();
            // This array is declared, then initialized to store the cards that have been dealt by calling upon the
            // 'dealTopCards' method, where the number of top cards dealt is determined by the 'numberOfCards' variable.
            Card[] cardsDealt;
            cardsDealt = dealTopCards(numberOfCards);
            // 'totalHandValue' is now initialized to 0 before the loop.
            totalHandValue = 0;
            // This inner for loop iterates over every card that has been dealt in the new array.
            for (int j = 0; j < cardsDealt.length; j++) {
                // For each iteration, the cards rank, and suit are added to the current 'totalHandValue' using the
                // getter methods representing the sum of values.
                totalHandValue = totalHandValue + (cardsDealt[j].getRank() * cardsDealt[j].getSuit());
            }
            // The if statement checks that once the value of the card is calculated, that it fits in the length of the
            // histogram array.
            if (totalHandValue < histogram.length) {
                // If it does, the number of times the sum of values has been found is incremented by 1 at the specified
                // element of the array.
                histogram[totalHandValue]++;
            }
        }
        // The histogram array containing all possible values is returned.
        return histogram;
    }

    /**
     * This method will actually visually display the results of the histogram using asterisks, integer values, and the
     * value for each deal. The purpose of this method is to not only show a visual representation of the histogram, but
     * to scale the values down so that the histogram does not go on forever. The assignment states that this class is
     * one of the model classes, so this made me remove the print line statements I had initially, and replace them with
     * a return, so that the method adheres to the model class standards. Instead, the method will return a string
     * representation of the histogram based on the histogram array.
     *
     * @param histogram, which is the array of values determined by the 'toHistogram' method.
     * @return display, a string representation of the histogram.
     */
    public String displayScaledHistogram(int[] histogram) {
        // A variable 'maxLength' is declared and initialized to 0 as default. It will be responsible for storing the
        // maximum length the histogram will display depending on the maximum values. This ensures the length is limited,
        // but also accurately displays how often the values are found.
        int maxLength = 0;
        // A variable 'display' is declared and initialized to an empty string as default, the string will be built
        // through the loop depending on the values found after being scaled.
        String display= "";

        // This for loop will iterate through each value found in the 'histogram' array.
        for (int i = 0; i < histogram.length; i++) {
            // The if statement checks if the element found at the index('i') is larger than the 'maxLength'.
            if (histogram[i] > maxLength) {
                // If the value is larger, the 'maxLength' will be re-assigned to the value found at the 'i' index of
                // the histogram array.
                maxLength = histogram[i];
            }
        }
        // This for loop focuses on the visual addition to the string 'display'. The loop iterates through the 'histogram'
        // array.
        for (int i = 0; i < histogram.length; i++) {
            // This if statement checks if the value found at the 'i'th index of the array is greater than 0, as the
            // assignment states to not include 0 values. Elements that have a value of 0, will not be included.
            if (histogram[i] > 0) {
                // In order to scale the length of the histograms values down, a new variable 'starsLength' is declared
                // and initialized to the value found at the 'i'th index of the histogram array, multiplied by 50, and
                // divided by the value of 'maxLength'. This will represent a display of 50, or less asterisks.
                int starsLength = (histogram[i] * 50 / maxLength);
                // The variable 'display' is concatenated to the current value of 'display', and then concatenated with
                // the current value of 'i' in this iteration, and concatenates that with the value at the 'i' index of
                // the histogram array showing how often this value was found.
                display = display + i + ": " + histogram[i] + "   ";
                // This inner for loop iterates as long as 'j' is less than the 'starsLength' which is the scaled down
                // length. If it is, an asterisk is concatenated to the 'display' string showing the frequency.
                for (int j = 0; j < starsLength; j++) {
                    display = display + "*";
                }
                // The line break concatenated to 'display' is done so all asterisks don't display on the same line, and
                // instead show for each value.
                display = display + "\n";
            }
        }
        // The method returns the visual histogram assigned to the String 'display'.
        return display;
    }

    /**
     * This method is used to generate a random card from the deck of cards. I wanted to test out another usage of the
     * card object, and it ended up working how I wanted it to, so I kept it. It uses an instance of the random class to
     * first generate a random rank(number) which will be between 1 up the rank the user has entered, and for suits
     * it will be from 1 up the number of suits entered by the user. The random values are assigned to variables, and
     * then passed to a new card object which takes the random values as parameters.
     *
     * @param maxRank, which is the maximum rank of the card.
     * @param numberOfSuits, which is the number of possible suits.
     * @return Card, a new card object that has a random rank, and random suit.
     */
    public Card randomCardGenerator(int maxRank, int numberOfSuits) {
        // A new instance of the random class.
        Random randomNumber = new Random();
        // Variables 'randomRank' and 'randomSuit' are assigned to the rank and suit entered.
        int randomRank = randomNumber.nextInt(maxRank) + 1;
        int randomSuit = randomNumber.nextInt(numberOfSuits) + 1;
        // The method returns a new card object which has a randomly selected rank, and suit.
        return new Card(randomRank, randomSuit);
    }
}



