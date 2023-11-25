package com.example.myjavafxapp.util;

import com.example.myjavafxapp.model.Dictionary;
import com.example.myjavafxapp.model.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    private static Dictionary dictionary = new Dictionary();

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

            System.out.print("Enter sound in English: ");
            String word_sound = scanner.nextLine();

            System.out.print("Enter Vietnamese meaning: ");
            String word_explain = scanner.nextLine();

            Word word = new Word(word_target, word_explain, word_sound);
            dictionary.addWord(word);
        }
    }

    // Hàm xóa từ
    public static boolean removeWord(String wordToRemove) {
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
    public static boolean updateWord(String wordToUpdate, String newWordSound, String newDefinition) {
        ArrayList<Word> words = dictionary.getAllWords();

        for (Word word : words) {
            if (word.getWordTarget().equalsIgnoreCase(wordToUpdate)) {
                word.setWordSound(newWordSound);
                word.setWordExplain(newDefinition);
                return true;
            }
        }

        return false; // Trả về false nếu từ không tìm thấy
    }

    // Hàm thêm từ
    public static boolean addWord(String wordToAdd, String newWordSound, String newDefinition) {
        ArrayList<Word> words = dictionary.getAllWords();
        for (Word word : words)
            if (word.getWordTarget().equalsIgnoreCase(wordToAdd)) {
                return false;
            }
        Word word = new Word(wordToAdd, newDefinition, newWordSound);
        words.add(word);
        return true;

    }

    // Hàm tra từ
    public static Word dictionaryLookup(String wordToLookup) {
        ArrayList<Word> words = dictionary.getAllWords();

        for (Word word : words) {
            if (word.getWordTarget().equalsIgnoreCase(wordToLookup)) {
                return word; // Trả về đối tượng Word nếu từ được tìm thấy
            }
        }

        return null; // Trả về null nếu từ không tìm thấy
    }

    // Hàm tìm kiếm từ
    public static ArrayList<Word> searchWords(String prefix) {
        ArrayList<Word> words = dictionary.getAllWords();
        ArrayList<Word> matchingWords = new ArrayList<>();

        for (Word word : words) {
            if (word.getWordTarget().startsWith(prefix)) {
                matchingWords.add(word);
            }
        }
        return matchingWords;
    }

    public static void insertFromFile(String path) {

        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String textFromFile = new String(encoded, Charset.defaultCharset());
        String[] words = textFromFile.split("@");
        for (String word : words) {
            String[] result = word.split("\r?\n", 2);
            if (result.length > 1) {
                String wordExplain = new String();
                String wordTarget = new String();
                String wordSound = new String();
                if (result[0].contains("/")) {
                    String firstMeaning = result[0].substring(0, result[0].indexOf("/"));
                    String lastSoundMeaning = result[0].substring(result[0].indexOf("/"), result[0].length());
                    wordTarget = firstMeaning;
                    wordSound = lastSoundMeaning;
                } else {
                    wordTarget = result[0];
                    wordSound = "";
                }
                wordExplain = result[1];
                dictionary.addWord(new Word(wordTarget.trim(), wordExplain.trim(), wordSound.trim()));
            }
        }
    }

     // Hàm nhập từ tệp
    public void insertFromFile1(String filePath) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t\t"); // Giả sử từ và nghĩa được phân tách bằng 2 dấu tab
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


//     // Hàm nhập từ tệp
//    public void insertFromFile(String filePath) {
//        try (Scanner fileScanner = new Scanner(new File(filePath))) {
//            while (fileScanner.hasNextLine()) {
//                String line = fileScanner.nextLine();
//                String[] parts = line.split("\t\t"); // Giả sử từ và nghĩa được phân tách bằng 2 dấu tab
//                if (parts.length == 2) {
//                    Word word = new Word(parts[0], parts[1]);
//                    dictionary.addWord(word);
//                }
//            }
//            System.out.println("Import successful!");
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//        }
//    }


    public static void exportToFile(String path) {
        StringBuilder content = new StringBuilder();
        ArrayList<Word> words = dictionary.getAllWords();
        for (Word word : words) {
            String wordTarget = word.getWordTarget();
            String wordExplain = word.getWordExplain();
            String wordSound = word.getWordSound();

            // Append "@" to separate wordTarget and wordExplain
            content.append("@");

            // Append wordTarget
            content.append(wordTarget).append(" ");

            // If wordSound is not empty
            if (!wordSound.isEmpty()) {
                content.append(wordSound).append("\n");
            }

            // Append wordExplain
            content.append(wordExplain);

            // Append newline to separate entries
            content.append("\n");
        }

        // Convert StringBuilder to byte array and write to file
        try {
            Files.delete(Paths.get(path));
            Files.writeString(Paths.get(path), content.toString(), Charset.defaultCharset());
            System.out.println("Export successful!");
        } catch (IOException e) {
            throw new RuntimeException("Error exporting to file: " + e.getMessage(), e);
        }
    }



//    // Hàm xuất ra tệp
//    public void dictionaryExportToFile(String filePath) {
//        try (PrintWriter writer = new PrintWriter(filePath)) {
//            ArrayList<Word> words = dictionary.getAllWords();
//            for (Word word : words) {
//                writer.println(word.getWordTarget() + "\t" + word.getWordExplain());
//            }
//            System.out.println("Export successful!");
//        } catch (FileNotFoundException e) {
//            System.out.println("Error exporting to file.");
//        }
//
//    }
}
