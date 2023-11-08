package data;

// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class DictionaryCommandLine {
    private final DictionaryManagement dictionaryManagement;

    public DictionaryCommandLine() {
        dictionaryManagement = new DictionaryManagement();
    }

    public void showAllWords() {
        ArrayList<Word> words = dictionaryManagement.getDictionary().getAllWords();
        words.sort(Comparator.comparing(Word::getWordTarget));

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

