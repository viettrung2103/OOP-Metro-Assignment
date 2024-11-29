package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Note;
import model.NoteList;
import view.NotebookUI;


public class NotebookController {
    private NoteList noteList;
    private NotebookUI noteUI;

    @FXML
    private TextArea titleInput;

    @FXML
    private TextField contentInput;

    @FXML
    private Button newBtn, upsertBtn;

    @FXML
    private Label idLabel, noteId1, noteId2;


    // does not have UI as input for contrustrctor
    public NotebookController() {

        this.noteList = new NoteList();
    }

    @FXML
    public void clearInputs() {
        System.out.println("clear input");
        this.titleInput.setText("");
        this.contentInput.setText("");
        this.idLabel.setText("");
    }

    @FXML
    public void upsertNote() {
        System.out.println("Upsert button is pressed");
        String idStr = idLabel.getText();
        String title = titleInput.getText();
        String content = contentInput.getText();
        startComputation(idStr, title, content);
    }


    public NoteList getNoteList() {
        return this.noteList;
    }

    public void startComputation(String idStr, String title, String content) {
        new Thread(() -> {
            try {
                // update model
                this.noteList.addNote(idStr, title, content);
                //update view
                Platform.runLater(() -> {
                            this.clearInputs();
                            noteUI.updateNoteListView(this.noteList);
                        }
                );
                // sleep
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).

                start();
    }

    public void setNoteUI(NotebookUI noteUI) {
        this.noteUI = noteUI;
    }

}
