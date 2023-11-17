package com.example.myjavafxapp.model;

public class Word {
    private final String word_target;    // từ vựng tiếng Anh
    private String word_explain;   // giải nghĩa tiếng Việt

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

    public void setWordExplain(String word_explain) {
        this.word_explain = word_explain;
    }
}