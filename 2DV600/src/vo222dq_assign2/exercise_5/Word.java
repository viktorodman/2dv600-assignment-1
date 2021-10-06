/** 
 * Date: 2021-10-06
 * File Name: Word.java
 * Author: Viktor Ödman
 */

package vo222dq_assign2.exercise_5;

/**
 * Represents a Word
 */
public class Word implements Comparable<Word> {
    private String word;

    /**
     * Creates a new Word instance
     * @param str The word that the word class will store
     */
    public Word(String str) {
        this.word = str;
    }

    /**
     * Creates a string representation of the Word instance
     * @return a string representation of the Word instance
     */
    public String toString() {
        return word;
    }

    /**
     * Creates a hashCode of the instance
     * @return a hashCode of the instance
     */
    @Override
    public int hashCode() {
        return this.word.toLowerCase().hashCode();
    }

    /**
     * Checks if the passed object is equal to the calling instance
     * @return True if the objects are equal otherwise false 
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Word) {
            Word tempWord = (Word)other;
            if (this.hashCode() == tempWord.hashCode()) return true;
            /* if (this.word.equalsIgnoreCase(tempWord.word)) return true; */
        } 
        return false;
    }

    /**
     * Compares the passed Word instance to the calling instance
     * @return The lexicographical equality of the words.
     */
    @Override
    public int compareTo(Word o) {
        return this.word.compareToIgnoreCase(o.word);
    }
}
