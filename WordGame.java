import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WordGame {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        int wordCount = countWords("words.txt");

        String[] words = readWords("words.txt", wordCount);

        String gameWord = getGameWord(words);

        System.out.println(gameWord);

        char[] letters = gameWord.toCharArray();

        Character[] letters2 = new Character[letters.length];
        for (int i = 0; i < letters.length; i++) {
            letters2[i] = letters[i];
        }

        Collections.shuffle(Arrays.asList(letters2));

        System.out.println();
        for (int i = 0; i < letters2.length; i++) {
            System.out.print(letters2[i] + " ");
        }
        System.out.println();
    }

    /**
     * Count words in file
     * @param filename
     * @return the count of the words:
     * @throws FileNotFoundException
     */
    public static int countWords(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner fileIn = new Scanner(f);

        int count = 0;

        while (fileIn.hasNext()) {
            fileIn.next();
            count++;
        }

        fileIn.close();

        return count;
    }

    /**
     *
     * @param filename
     * @param wordCount
     * @return the array of the Strings
     * @throws FileNotFoundException
     */
    public static String[] readWords(String filename, int wordCount) throws FileNotFoundException {
        File f = new File(filename);
        Scanner fileIn = new Scanner(f);

        String[] words = new String[wordCount];

        int count = 0;

        while (fileIn.hasNext()) {
            words[count] = fileIn.next();
            count++;
        }

        fileIn.close();

        return words;
    }

    /**
     *
     * @param words
     * @return the gameWords
     */
    public static String getGameWord(String[] words) {

        Collections.shuffle(Arrays.asList(words));

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 7) {
                if (checkUniqueLetters(words[i])) {
                    return words[i];
                }
            }
        }

        return ""; // There are no 7 unique letter words
    }

    /**
     *
     * @param word
     * @return boolean if uniqueLetters matches:
     */
    public static boolean checkUniqueLetters(String word) {
        char[] letters = word.toCharArray();
        boolean[] seen = new boolean[26]; // To track seen letters

        for (char letter : letters) {
            int index = Character.toLowerCase(letter) - 'a'; // Normalize to lowercase
            if (index < 0 || index >= 26 || seen[index]) {
                return false; // Not a valid letter or already seen
            }
            seen[index] = true; // Mark letter as seen
        }

        return true; // All letters are unique
    }
}
