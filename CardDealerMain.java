package assignmentFour_000879513;

import java.util.Scanner;

/**
 * This class is the view/main class for the Card Dealing Program. This class is where the user will actually interact
 * with the program, and depending on what the user wants to do, methods will be called from the model classes for the
 * interaction with an emphasis on the use of arrays as specified by the assignment. This class will consist of no logic
 * for the methods, instead it will mainly consist of input validation logic, a menu for the user to interact with, and
 * arrays to show the user their cards, or a visual representation of their cards.
 *
 * @author BRENDAN DILEO, 000879513
 */

public class CardDealerMain {
    /**
     * Main method that launches and runs the app/program.
     *
     * @param args, unused.
     */
    public static void main(String[] args) {

        // Creates an instance of the scanner class/object for taking input from the user via the keyboard.
        Scanner sc = new Scanner(System.in);

        // Prompts user that they are entering the program.
        System.out.println("Welcome to the Card Dealer Program!");
        System.out.println("After entering a number of suits, and the maximum rank, you'll be able to access the " +
                "main menu!");

        // Asks for the number of suits, and saves the value into the variable 'suits'.
        System.out.println("Enter the number of suits: (Typically between 1 - 4) ");
        int suits = sc.nextInt();

        // Asks for the maximum rank (number), and saves value into the variable 'ranks'.
        System.out.println("Enter the maximum rank: (Typically between 1 - 13) ");
        int ranks = sc.nextInt();

        // Uses a while loop to make sure the input is not 0, or less.
        // If it is, the user will be prompted again, and again until the input is valid (greater than 0).
        while (ranks <= 0 || suits <= 0) {
            System.out.println("The suits and ranks need to be more than 0! Try again!");

            System.out.println("Enter the number of suits: ");
            suits = sc.nextInt();

            System.out.println("Enter the maximum rank: ");
            ranks = sc.nextInt();
        }

            // Creates an instance of the 'DeckOfCards' object from the 'DeckOfCards' class. The maximum rank and number
            // of suits are determined by what the user has entered.
            DeckOfCards deckOne = new DeckOfCards(ranks, suits);

            // This line prints the 'deckOne' object's attributes, which calls upon the 'toString' method in the
            // 'DeckOfCards' class, which calls upon the 'toString' method in the cards class through association.
            System.out.println(deckOne);
            System.out.println(); // This line is for clarity
            // The variable 'userChoice' is declared but not yet initialized. It will be used as the variable for the
            // switch case.
            int userChoice;
            // The variable 'numOfUsersCards' is used to keep track of the number of cards the user has.
            int numOfUsersCards = 0;

            // Program enters a Do-While loop for the menu of options.
            do {
                // Prompts the user with options of what each choice will do, the users input is then saved into
                // 'userChoice' variable using the scanner to control the switch case.
                System.out.println("Choose what you want to do next!");
                System.out.println("Press '1' to shuffle!");
                System.out.println("Press '2' to deal!");
                System.out.println("Press '3' to return the cards dealt!");
                System.out.println("Press '4' to deal 100,000 times!");
                System.out.println("Press '5' to deal a random card from the deck, and make an attempt at guessing the card!");
                System.out.println("Press '6' to quit!");
                userChoice = sc.nextInt();

                // Enters a switch-case to execute specified case and methods given the users choice.
                switch (userChoice) {
                    case 1:
                        // Case 1 is the option to shuffle the deck, if the user has chosen this, the 'shuffleDeck'
                        // method is called upon, and the shuffled deck object is printed to the user.

                        // This if statement checks if the size of the deck is 0, and if it is, the user is prompted with
                        // a message that they have to return their cards or exit the program. The break statement exits
                        // this case and goes back to the menu.
                        if (deckOne.getDeckSize() == 0) {
                            System.out.println("No more cards are left in the deck! Return your cards or exit the program!");
                            break;
                        }

                        System.out.println("**** Shuffling the deck! ****");
                        deckOne.shuffleDeck();
                        System.out.println(deckOne);
                        break;
                    case 2:
                        // Case 2 is the option to deal a certain number of cards, where the number of cards is chosen
                        // by the user. The 'dealTopCards' method is called upon to deal the user the number of cards
                        // they have chosen.

                        // This if statement checks if the size of the deck is 0, and if it is, the user is prompted with
                        // a message that they have to return their cards or exit the program. The break statement exits
                        // this case and goes back to the menu.
                        if (deckOne.getDeckSize() == 0) {
                            System.out.println("No more cards are left in the deck! Return your cards or exit the program!");
                            break;
                        }

                        System.out.println("How many cards would you like dealt?");
                        int dealtCards = sc.nextInt();
                        // This loop validates the input, so if the user has tried to deal more cards than are in the
                        // deck, they are continuously prompted until the input is valid.
                        while (dealtCards > deckOne.getDeckSize() || dealtCards <= 0) {
                            if (dealtCards <= 0) {
                                System.out.println("Sorry, we cannot deal 0 cards! Try again!");
                            } else if (dealtCards > deckOne.getDeckSize()) {
                                System.out.println("Not enough Cards in the deck! Try again!");
                            }
                            System.out.println("How many cards would you like dealt?");
                            dealtCards = sc.nextInt();
                        }
                        // An array is initialized and declared taking the number of cards dealt which the user has
                        // specified, using the 'dealTopCards' method. This is so the program can display the user the
                        // cards that have been dealt.
                        Card[] userCards;
                        userCards = deckOne.dealTopCards(dealtCards);

                        // This for loop will iterate over each card in the 'userCards' array, which consists of the
                        // cards dealt when calling upon the 'dealCardsMethod'. For each card in this array, it will be
                        // printed to the user to act as the cards actually being dealt.
                        System.out.println("*** DEALING " + dealtCards + " CARDS ****");
                        for (int i = 0; i < userCards.length; i++) {
                            System.out.println(userCards[i]);
                        }
                        // When the user is dealt cards, the variable 'numOfUserCards' holding the number of cards the
                        // user has is incremented by the number of cards dealt.
                        numOfUsersCards = numOfUsersCards + dealtCards;
                        System.out.println(deckOne);
                        break;
                    case 3:
                        // Case 3 gives the user an option to return any cards they have in hand/have been dealt. This
                        // case does not use an array, but will still print the number of cards that they have returned.

                        // This if statement checks if the user has no cards, and if they don't, the user is prompted with
                        // a message that they have no cards.
                        if (numOfUsersCards == 0) {
                            System.out.println("You do not have any cards!");
                        // The else statement will execute if the user has more than 0 cards.
                        } else {
                            System.out.println("Current Deck Size: " + deckOne.getDeckSize());
                            System.out.println("You currently have: " + numOfUsersCards + " in your hand.");
                            System.out.println("How many cards would you like to return?");
                            int cardsReturned = sc.nextInt();

                            // The while loop will check if the user has returned no cards, or if they try to return
                            // more cards than they have.
                            while (cardsReturned <= 0 || cardsReturned > numOfUsersCards) {
                                // The if statement specifies what the user has tried to do, in this case they have
                                // tried to return 0, or less cards, and if they try to do this an error message will
                                // print.
                                if (cardsReturned <= 0) {
                                    System.out.println("Sorry, you cannot return 0 or less Cards! Try again!");
                                // The else if statement specifies that the user has tried to return more cards than
                                // what they actually have, and if they try to do this, an error message will be printed.
                                } else if (cardsReturned > numOfUsersCards) {
                                    System.out.println("You cannot return " + cardsReturned + " when you only have " +
                                            numOfUsersCards + " in hand! Try again!");
                                }
                                // If the while loops condition is true, meaning the user is returning 0 cards or less,
                                // or more than they have, they will be asked again until they enter a valid input.
                                System.out.println("How many cards would you like to return?");
                                cardsReturned = sc.nextInt();
                            }

                            // The 'returnDealtCards' method is called upon, which takes the number of cards the user
                            // wants to return as a parameter.
                            deckOne.returnDealtCards(cardsReturned);
                            // The number of cards the user has will be deducted from the cards they returned, so if
                            // they had 5, and returned 4, they would still have 1 card.
                            numOfUsersCards = numOfUsersCards - cardsReturned;
                            System.out.println("**** CARDS RETURNED ****");
                            System.out.println("Current Deck Size: " + deckOne.getDeckSize() + "\n");
                        }
                        break;
                    case 4:
                        // Case 4 is the option to deal the number of cards 100,000 times, and it is displayed in a Histogram
                        // format. The user chooses the number of cards they want dealt, and once validated, the Histogram
                        // is displayed to them.

                        // This if statement checks if the size of the deck is 0, and if it is, the user is prompted with
                        // a message that they have to return their cards or exit the program. The break statement exits
                        // this case and goes back to the menu.
                        if (deckOne.getDeckSize() == 0) {
                            System.out.println("No more cards are left in the deck! Return your cards or exit the program!");
                            break;
                        }
                        System.out.println("How many cards would you like dealt 100,000 times?");
                        int cardsToDeal = sc.nextInt();
                        // This while loop makes sure that the user has not chosen more cards to deal, than in the deck
                        // to avoid any errors.
                        while (cardsToDeal > deckOne.getDeckSize()) {
                            System.out.println("Not enough Cards in the deck! Try again!");
                            System.out.println("How many cards would you like dealt 100,000 times?");
                            cardsToDeal = sc.nextInt();
                        }
                        // This array is declared then initialized to store the card object values by calling upon the
                        // 'toHistogram' array which takes the number of cards the user wants dealt 100,000 times as a
                        // parameter.
                        int[] cards;
                        cards = deckOne.toHistogram(cardsToDeal);

                        // A new string variable 'histogramDisplay' is declared and initialized which stores the actual
                        // visual representation of the histogram, by calling upon the 'displayScaledHistogram' method
                        // taking the 'cards' array, which is the values of the cards that have been dealt 100,000 times.
                        // The display is then printed to the user.
                        String histogramDisplay = deckOne.displayScaledHistogram(cards);
                        System.out.println("**** DISPLAYING HISTOGRAM ****");
                        System.out.println(histogramDisplay);
                        // Once the histogram has been displayed, the 'resetDeckSize' method is called upon as I was
                        // getting issues with shuffling after calling upon the histogram method.
                        deckOne.resetDeckSize();
                        break;
                    case 5:
                        // Case 5 is the option to let the user guess a random card that has been generated from the deck
                        // given the maximum rank number, and number of suits they have entered. This case was not specified
                        // by the assignment, but I thought it would be a cool addition, to experiment with more
                        // functionality.

                        // This if statement checks if the size of the deck is 0, and if it is, the user is prompted with
                        // a message that they have to return their cards or exit the program. The break statement exits
                        // this case and goes back to the menu.
                        if (deckOne.getDeckSize() == 0) {
                            System.out.println("No more cards are left in the deck! Return your cards or exit the program!");
                            break;
                        }

                        // The user is then re-prompted to enter the number of suits, and the max rank they would like
                        // the deck to have.
                        System.out.println("Enter the number of suits: ");
                        int newSuits = sc.nextInt();
                        System.out.println("Enter the maximum rank: ");
                        int newRanks = sc.nextInt();

                        // This while loop makes sure the user has not entered a value that is less than 0, or equal to
                        // 0 for the new rank and suit values. This will validate like the initial while loop right at
                        // the start.
                        while (newRanks <= 0 || newSuits <= 0) {
                            System.out.println("Sorry, the suits and ranks need to be more than 0! Try again!");
                            System.out.println("Enter the number of suits: ");
                            newSuits = sc.nextInt();
                            System.out.println("Enter the maximum rank: ");
                            newRanks = sc.nextInt();
                        }
                        // A card object is declared and initialized, this time taking the maximum rank, and number of
                        // suits that the user has just entered as parameters. The random card is generated by calling
                        // upon the 'randomCardGenerator' method, and passing the new number of ranks, and suits entered
                        // by the user as parameters. The random card is saved into the 'randomCard' variable.
                        System.out.println("**** GENERATING RANDOM CARD ****");
                        Card randomCard;
                        randomCard = deckOne.randomCardGenerator(newRanks, newSuits);

                        // After the random card is created, the user is prompted to guess the rank and suit of the card.
                        // Their guesses are saved into new variables to compare.
                        System.out.println("Enter your guess: ");
                        System.out.println("Enter the cards rank (number) from '1 - " + newRanks + "': ");
                        int rankGuess = sc.nextInt();
                        System.out.println("Enter the cards suit from '1 - " + newSuits + "': ");
                        int suitGuess = sc.nextInt();

                        // This if statement validates the users guess by calling upon the 'getRank', and 'getSuit'
                        // methods. If the statement validates to true, the user is prompted with a message, and if the
                        // condition evaluates to false, the user is prompted with another message, both showing the user
                        // the card that was generated at random, and whether or not their guess was correct.
                        if (rankGuess == randomCard.getRank() && suitGuess == randomCard.getSuit()) {
                            System.out.println("Wow! You guessed it! The card was " + randomCard + "!");
                        } else {
                            System.out.println("Incorrect! The card was " + randomCard + " Feel free to try again!");
                        }
                        break;
                    case 6:
                        // Case 6 is only responsible for printing a message when the user has chosen to exit the program.
                        System.out.println(" **** EXITING CARD DEALING SOFTWARE **** ");
                        System.out.println("Have a good day!");
                        break;
                    default:
                        // The default case/option is for when the user has entered an option beyond 1 - 5, and if they
                        // do a message is shown telling them their choice was not one of the options.
                        System.out.println("That was not an option!");
                }
                // The Do-While loop continues as long as the user does not choose 5, and if they do, the loop exits as
                // this is what they have chosen to do.
            } while (userChoice != 6);
        }
}
