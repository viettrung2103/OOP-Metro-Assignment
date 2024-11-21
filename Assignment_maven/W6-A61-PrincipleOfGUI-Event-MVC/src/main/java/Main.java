import Controller.DictionaryController;
import Model.Dictionary;
import View.DictionaryView;

public class Main {
    public static void main(String[] args) {
//        Dictionary dictionary = new Dictionary();
//        DictionaryView ui = new DictionaryView();
//        DictionaryController controller = new DictionaryController(ui);
//        ui.setController(controller);
//        ui.init();
//
//        System.out.println("Starting");
//        ui.getController().add("One", "Yksi");
//        ui.getController().add("Two", "Kaksi");
//        ui.getController().add("Three", "Kolme");
//        ui.getController().displayAllWords();
//        System.out.println("start UI");


//        System.out.println(controller.translate("One"));
//        controller.displayAllWords();
        DictionaryView.launch(DictionaryView.class);
    }


}
