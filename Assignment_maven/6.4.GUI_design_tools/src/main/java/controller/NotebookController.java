package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.Note;
import model.NoteList;
import view.NotebookUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    @FXML
    private GridPane noteGrid;


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
        this.upsertBtn.setText("Add");
    }

    @FXML
    public void upsertNote() {
        System.out.println("Upsert button is pressed");
        String idStr = idLabel.getText();
        String title = titleInput.getText();
        String content = contentInput.getText();

        if (title.equals("") || content.equals("")) {
            this.displayErrorDialog();
            return;
        }

        this.noteList.addNote(idStr, title, content);
        ArrayList<Note> copiedList = this.noteList.copyList();
        startComputation(copiedList);
    }


    public NoteList getNoteList() {
        return this.noteList;
    }

    public void startComputation(ArrayList<Note> copiedList) {
        new Thread(() -> {
            try {

                Platform.runLater(() -> {
                            this.clearInputs();
                            noteUI.updateNoteListView(copiedList);
                        }
                );

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

    public GridPane getGridPane() {
        return this.noteGrid;
    }

//    public ArrayList<Note> cloneList() {
//        HashMap<Integer, Note> bufferList = new HashMap<>();
//        Note curNote = this.noteList.g
//    }

    public void displayErrorDialog() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Both title and content fields need to be filled");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isEmpty()) {
            System.out.println("Alert closed");
        } else if (result.get() == ButtonType.OK) {
            System.out.println("OK!");
        }
    }

}
