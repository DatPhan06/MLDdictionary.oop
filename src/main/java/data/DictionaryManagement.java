package data;

import java.util.Scanner;

class DictionaryManagement {
    private final Dictionary dictionary;

    public DictionaryManagement() {
        dictionary = new Dictionary();
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void insertFromCommandLine() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < n; i++) {
            System.out.print("Enter word in English: ");
            String word_target = scanner.nextLine();

            System.out.print("Enter Vietnamese meaning: ");
            String word_explain = scanner.nextLine();

            Word word = new Word(word_target, word_explain);
            dictionary.addWord(word);
        }
    }
}
