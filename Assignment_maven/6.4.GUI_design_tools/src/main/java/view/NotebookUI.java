package view;

import controller.NotebookController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Note;
import model.NoteList;

import java.util.HashMap;
import java.util.Map;


public class NotebookUI extends Application {
    NotebookController controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/notebook_view.fxml"));
        Parent root = fxmlLoader.load();
        this.controller = fxmlLoader.getController();
        this.controller.setNoteUI(this);
        System.out.println("got controller " + this.controller);

        stage.setScene(new Scene(root));
        stage.show();
    }


    public void updateNoteListView(NoteList noteList) {
        HashMap<Integer, Note> notes = noteList.getNotes();

        for (Map.Entry<Integer, Note> note : notes.entrySet()) {
            System.out.println(note);
        }
    }

//    public void updateView(){
//
//        Label newNoteView = new Label()
//    }

}
