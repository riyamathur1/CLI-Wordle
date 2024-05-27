# CLI-Wordle

A Java-based console Wordle game.

## Requirements

Ensure you have a Java runtime environment installed on your computer to run the game.

## Word List

The game uses a list of 5-letter English words from a file named `words.txt`. Ensure this file is in the same directory as the program. Each line of the file should contain a single 5-letter word.

## Game Rules

1. **Introduction**: The game starts by displaying an introduction and providing information about the mystery word, which is a 5-letter English word.
2. **Guessing**: You have 6 chances to guess the correct word. After each guess, the program will provide feedback to help you narrow down your choices.
   - Enter your guess as a 5-letter word, without punctuation or spaces.
   - If your guess is invalid (not 5 letters or containing non-alphabetic characters), you will be prompted to guess again.
3. **Feedback**: 
   - Correct letters in the correct position will be revealed.
   - Correct letters in the wrong position will be enclosed in square brackets.
   - Letters that are not part of the word will be represented by underscores.
4. **Winning or Losing**:
   - If you correctly guess the word within 6 attempts, you win the game.
   - If you exhaust all 6 attempts without guessing the word, you lose.
5. **Playing Again**: After the game ends (win or lose), you can run the program again to play another round with a new random word.

## Program Structure

The program consists of two classes: `WordList` and `Wordle`.

- **WordList**: Reads words from `words.txt` and provides a method to get a random 5-letter word.
- **Wordle**: Implements the game logic, interaction, and feedback.
