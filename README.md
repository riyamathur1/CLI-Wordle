# CLI-Wordle
Java-based console wordle game


Requirements: This program is written in Java, so make sure you have a Java runtime environment installed on your computer to run the game.

Word List: The game uses a list of 5-letter English words from a file named words.txt. Make sure to create this file in the same directory as the program. Each line of the file should contain a single 5-letter word.

Game Rules:

The game will display the introduction and provide information about the mystery word, which is a 5-letter English word. You have a total of 6 chances to guess the correct word. After each guess, the program will provide feedback to help you narrow down your choices.

Guessing Words:

Enter your guess as a 5-letter word, without punctuation or spaces. If your guess is not valid (not 5 letters or containing non-alphabetic characters), you will be prompted to guess again.

Feedback:

The game will display your progress after each guess.

Correct letters in the correct position will be revealed.
Correct letters in the wrong position will be enclosed in square brackets.
Letters that are not part of the word will be represented by underscores.
Winning or Losing:

If you correctly guess the word within 6 attempts, you win the game.
If you exhaust all 6 attempts without guessing the word, you lose.
Playing Again:

After the game ends (win or lose), you can run the program again to play another round with a new random word.
Program Structure:

The program consists of two classes: WordList and Wordle.

WordList: Reads words from words.txt and provides a method to get a random 5-letter word.
Wordle: Implements the game logic, interaction, and feedback.
