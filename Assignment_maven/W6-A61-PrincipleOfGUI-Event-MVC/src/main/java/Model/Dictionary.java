package Model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private HashMap<String, Word> wordList;

    public Dictionary() {
        this.wordList = new HashMap<>();
    }

    public boolean isEmpty() {
        return this.wordList.isEmpty();
    }

    public void addWord(String name, String translation) {
        Word newWord = new Word(name, translation);
        this.wordList.put(name.toLowerCase(), newWord);
    }

    public boolean isExist(String name) {
        return this.wordList.containsKey(name.toLowerCase());
    }

    public HashMap<String, Word> getDictionary() {
        return this.wordList;
    }

    public Word search(String name) {
        return this.wordList.get(name.toLowerCase());
    }

    public void print() {
        for (Map.Entry<String, Word> entry : this.wordList.entrySet()) {
            String keyword = entry.getKey();
            Word word = entry.getValue();
            System.out.println(word);
        }
    }

}
