package data;

// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Word {
    private final String word_target;    // từ vựng tiếng Anh
    private final String word_explain;   // giải nghĩa tiếng Việt

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public String getWordTarget() {
        return word_target;
    }

    public String getWordExplain() {
        return word_explain;
    }
}

class Dictionary {
    private final ArrayList<Word> words;

    public Dictionary() {
        words = new ArrayList<>();
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public ArrayList<Word> getAllWords() {
        return words;
    }
}

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

class DictionaryCommandLine {
    private final DictionaryManagement dictionaryManagement;

    public DictionaryCommandLine() {
        dictionaryManagement = new DictionaryManagement();
    }

    public void showAllWords() {
        ArrayList<Word> words = dictionaryManagement.getDictionary().getAllWords();
        Collections.sort(words, (word1, word2) -> word1.getWordTarget().compareTo(word2.getWordTarget()));

        System.out.println("No | English | Vietnamese");
        for (int i = 0; i < words.size(); i++) {
            Word word = words.get(i);
            System.out.println((i + 1) + " | " + word.getWordTarget() + " | " + word.getWordExplain());
        }
    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandLine();
        showAllWords();
    }

    public static void main(String[] args) {
        DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine();
        dictionaryCommandLine.dictionaryBasic();
    }
}

