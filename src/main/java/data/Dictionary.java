package data;

import java.util.ArrayList;

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
