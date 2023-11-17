package data;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    private final Dictionary dictionary;

    public DictionaryManagement() {
        dictionary = new Dictionary();
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    // Hàm thêm từ mới từ commandline
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

    // Hàm xóa từ
    public boolean removeWord(String wordToRemove) {
        ArrayList<Word> words = dictionary.getAllWords();

        for (Word word : words) {
            if (word.getWordTarget().equalsIgnoreCase(wordToRemove)) {
                words.remove(word);
                return true;
            }
        }

        return false; // Trả về false nếu từ không tìm thấy
    }

    // Hàm cập nhật từ
    public boolean updateWord(String wordToUpdate, String newDefinition) {
        ArrayList<Word> words = dictionary.getAllWords();

        for (Word word : words) {
            if (word.getWordTarget().equalsIgnoreCase(wordToUpdate)) {
                word.setWordExplain(newDefinition);
                return true;
            }
        }

        return false; // Trả về false nếu từ không tìm thấy
    }

    // Hàm tra từ
    public Word dictionaryLookup(String wordToLookup) {
        ArrayList<Word> words = dictionary.getAllWords();

        for (Word word : words) {
            if (word.getWordTarget().equalsIgnoreCase(wordToLookup)) {
                return word; // Trả về đối tượng Word nếu từ được tìm thấy
            }
        }

        return null; // Trả về null nếu từ không tìm thấy
    }

    // Hàm tìm kiếm từ
    public ArrayList<Word> searchWords(String prefix) {
        ArrayList<Word> words = dictionary.getAllWords();
        ArrayList<Word> matchingWords = new ArrayList<>();

        for (Word word : words) {
            if (word.getWordTarget().startsWith(prefix)) {
                matchingWords.add(word);
            }
        }
        return matchingWords;
    }

    // Hàm nhập từ tệp
    public void insertFromFile(String filePath) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t"); // Giả sử từ và nghĩa được phân tách bằng dấu tab
                if (parts.length == 2) {
                    Word word = new Word(parts[0], parts[1]);
                    dictionary.addWord(word);
                }
            }
            System.out.println("Import successful!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    // Hàm xuất ra tệp
    public void dictionaryExportToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            ArrayList<Word> words = dictionary.getAllWords();
            for (Word word : words) {
                writer.println(word.getWordTarget() + "\t" + word.getWordExplain());
            }
            System.out.println("Export successful!");
        } catch (FileNotFoundException e) {
            System.out.println("Error exporting to file.");
        }

    }
}
