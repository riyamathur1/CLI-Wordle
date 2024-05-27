
import java.util.Scanner;
import java.io.File;
import java.util.Random;

class WordList {
    private String[] words;
    private int wordCount;

    public void readFromFile() {
        File file = new File("words.txt");
        try (Scanner input = new Scanner(file)) {
            wordCount = 0;
            // Count the number of words in the file
            while (input.hasNextLine()) {
                input.nextLine();
                wordCount++;
            }
            words = new String[wordCount];
            int arrayCounter = 0;

            // Read the file content again using a new Scanner instance
            try (Scanner fileScanner = new Scanner(file)) {
                // Store each word in the words array
                while (fileScanner.hasNextLine()) {
                    String word = fileScanner.nextLine();
                    words[arrayCounter] = word;
                    arrayCounter++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public String getRandomWord() {
        Random random = new Random();
        String word = "";
        // Generate a random word from the words array
        do {
            int index = random.nextInt(words.length);
            word = words[index];
        } while (word.length() != 5);
        return word;
    }
}

class Wordle {
    private static final int WORD_LENGTH = 5;
    private static final int MAX_GUESSES = 6;

    public void startGame() {
        System.out.println("\nWelcome to Wordle!");
        System.out.println("The mystery word is a 5-letter English word.");
        System.out.println("You have 6 chances to guess it.\n");
    }

    public void playGame(String word) {
        Scanner input = new Scanner(System.in);
        int guesses = 1;
        String[] progress = new String[WORD_LENGTH];
        // Initialize the progress array with underscores
        for (int i = 0; i < WORD_LENGTH; i++) {
            progress[i] = "_";
        }

        while (guesses <= MAX_GUESSES) {
            System.out.print("guess " + guesses + ": ");
            String guess = input.nextLine().toLowerCase().trim();

            while (!isValidGuess(guess)) {
                System.out.println("Invalid guess. Please enter a 5-letter word without punctuation.");
                System.out.print("guess " + guesses + ": ");
                guess = input.nextLine().toLowerCase().trim();
            }

            // Update the progress array based on the guess
            updateProgress(word, progress, guess);
            // Print the current progress
            printProgress(progress);

            if (isWordGuessed(word, progress)) {
                System.out.println("Congrats! You guessed it!");
                return;
            }

            guesses++;
        }

        System.out.println("Sorry! Better luck next time!");
        System.out.println("The word was " + word + ".");
    }

    private boolean isValidGuess(String guess) {
        // Validate the format of the guess
        return guess.matches("[a-zA-Z]{5}");
    }

    private boolean isWordGuessed(String word, String[] progress) {
        // Check if the progress array matches the word
        return String.join("", progress).equals(word);
    }

    private void updateProgress(String word, String[] progress, String guess) {
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (word.charAt(i) == guess.charAt(i)) {
                // The guessed letter is in the correct location
                progress[i] = String.valueOf(guess.charAt(i));
            } else if (word.contains(String.valueOf(guess.charAt(i)))) {
                // The guessed letter is present in the word but in the wrong location
                progress[i] = "[" + guess.charAt(i) + "]";
            } else {
                // The guessed letter is not present in the word
                progress[i] = "_";
            }
        }
    }

    private void printProgress(String[] progress) {
        // Print the current progress with each element separated by a space
        for (String letter : progress) {
            System.out.print(letter + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        WordList wordList = new WordList();
        // Read words from the file
        wordList.readFromFile();
        // Get a random word from the WordList
        String word = wordList.getRandomWord();
        Wordle game = new Wordle();
        game.startGame();
        // Start the game with the random word
        game.playGame(word);
    }
}


