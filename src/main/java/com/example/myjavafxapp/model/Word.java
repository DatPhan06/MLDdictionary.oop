package com.example.myjavafxapp.model;


import java.util.Objects;

public class Word {
    private String wordTarget;
    private String wordSound;
    private String wordExplain;



    public Word(String wordTarget, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
    }

    public Word(String wordTarget, String wordExplain, String wordSound) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
        this.wordSound = wordSound;
    }

    public Word() {
        this.wordTarget = "";
        this.wordExplain = "";
        this.wordSound = "";
    }



    public String getWordTarget() {
        return wordTarget;
    }

    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    public String getWordSound() {
        return wordSound;
    }

    public void setWordSound(String wordSound) {
        this.wordSound = wordSound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(wordTarget, word.wordTarget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordTarget);
    }

    @Override
    public String toString() {
        return wordTarget + '\n' + wordSound + '\n' + wordExplain + '\n';
    }
}
