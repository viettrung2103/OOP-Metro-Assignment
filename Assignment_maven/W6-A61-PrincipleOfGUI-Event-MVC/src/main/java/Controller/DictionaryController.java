package Controller;

import Model.Dictionary;
import Model.Word;
import View.DictionaryView;

public class DictionaryController {
    private Dictionary dictionary = new Dictionary();
    private DictionaryView ui;

    public DictionaryController(DictionaryView ui) {
//        this.dictionary =  new Dictionary();
        this.ui = ui;
    }

    public void add(String name, String translation) {
        if (this.isExist(name)) {
            System.out.println("\"" + name + "\" is already exist in the dictionary.");
        }
        System.out.println("\""+name+"\" with translation \""+translation+"\" is added to the dictionary");
        this.dictionary.addWord(name, translation);

    }

    public boolean isExist(String name) {
        return this.dictionary.isExist(name);
    }

    public String translate(String name) {
        Word foundWord = this.dictionary.search(name);
        if (foundWord == null) {
            return "There is no translation for \"" + name+"\"";
        }
        return "The translation for \"" + name + "\" is \"" + foundWord.getTranslation() + "\"";
    }




    public void displayAllWords() {
        if (this.dictionary.isEmpty()) {
            System.out.println("The dictionary is empty");
        }
        System.out.println("The word list is");
        this.dictionary.print();
    }
}
