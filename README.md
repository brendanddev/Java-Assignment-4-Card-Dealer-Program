# Java-Assignment-4-Card-Dealer-Program

This assignment focuses on  developing a program that simulates shuffling and dealing playing cards, ultimately generating a histogram of the results. The project involves creating two fundamental classes: one to represent individual playing cards and another to manage a deck of cards. This assignment emphasizes on the use of assosciation, encapsulation, and the expanding on fundamental concepts of logic in coding.

Starting with the Card class, it encapsulates the essential properties of a playing card: rank and suit. Each card's rank and suit are immutable, defined at the card's creation and cannot be altered after. This class is equipped with methods to retrieve and display the card's rank, suit, and value.

The DeckOfCards class, serves as the container for multiple Card objects, effectively representing a deck of playing cards. When instantiated, this class constructs an array of Card objects based on input parameters specifying the maximum rank and number of suits. Each unique combination of rank and suit corresponds to a distinct card within the deck. The class provides functionalities such as shuffling the deck, dealing cards to form hands, and computing statistics like the minimum and maximum card values within the deck.

Inside of the DeckOfCards class, is the method for generating and dissplaying the histogram. This method facilitates the repeated shuffling and dealing of cards to generate statistical data. Specifically, it accepts a parameter indicating the size of a hand and simulates this process 100,000 times. After each deal, it calculates the total value of the hand and records the frequency of each total in an array, forming a histogram of hand values. This histogram serves as a representation of the distribution of card combinations.

Finally, the main method acts as the user interface for the program. It prompts the user to input parameters such as the number of suits and maximum rank, creates the deck of cards accordingly, and displays it. Subsequently, it enters a loop offering options to shuffle once, deal a single hand, or perform 100,000 shuffles and deals. Based on the user's selection, the program outputs the result, either displaying the hand dealt or presenting the histogram of hand values.

This assignment was made for the Programming In Java course at Mohawk College, in which I received a 100%.
