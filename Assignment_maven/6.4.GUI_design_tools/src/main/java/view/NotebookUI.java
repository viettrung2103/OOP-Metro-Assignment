package view;

import controller.NotebookController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Note;
import model.NoteList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class NotebookUI extends Application {
    NotebookController controller;
    FXMLLoader fxmlLoader;
    GridPane noteGrid;
    int rowCounts, collumnCounts;

    @Override
    public void start(Stage stage) throws Exception {
        this.fxmlLoader = new FXMLLoader(getClass().getResource("/notebook_view.fxml"));
        Parent root = fxmlLoader.load();
        this.controller = fxmlLoader.getController();
        this.controller.setNoteUI(this);
        this.noteGrid = this.controller.getGridPane();
        this.rowCounts = this.noteGrid.getRowCount();
        this.collumnCounts = this.noteGrid.getColumnCount();
        System.out.println("got controller " + this.controller);

        stage.setScene(new Scene(root));
        stage.show();
    }


    public void updateNoteListView(ArrayList<Note> copiedNotes) {
//        HashMap<Integer, Note> notes = noteList.getNotes();
        this.updateGridSize(copiedNotes.size());
        this.noteGrid.getChildren().clear();
        try {
            for (int i = 0, row = 0; row < this.rowCounts; row++) {
                for (int collumn = 0; collumn < this.collumnCounts; collumn++, i++) {

                    Note note = copiedNotes.get(i);
                    this.renderNoteView(note, collumn, row);
//                    Label noteLabel = new Label(note.getTitle());
//                    //grid.add (node, collumn, row)
//                    this.noteGrid.add(noteLabel, collumn, row);
                }

            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("no more note");
        }
    }

    public void updateGridSize(int listSize) {
//        int EXTRAROW = 1;
        int gridSize = this.collumnCounts * this.rowCounts;
        if (listSize > (gridSize)) {

//            int neededRows = (int) Math.ceil((double)(listSize - gridSize) / this.collumnCounts);
//            this.noteGrid.addRow(EXTRAROW, new Text(""));
            // addRow() method first parameter is the idx row where we want to add the next row after it
//            System.out.println("Before adding row: columns = " + this.noteGrid.getColumnCount() + ", rows = " + this.noteGrid.getRowCount());
            this.noteGrid.addColumn(this.rowCounts - 1, new Text(""));
//            System.out.println("After adding row: columns = " + this.noteGrid.getColumnCount() + ", rows = " + this.noteGrid.getRowCount());
            int newCollumnCount = this.noteGrid.getColumnCount();
            int newRowCount = this.noteGrid.getRowCount();
            this.collumnCounts = newCollumnCount;
            this.rowCounts = newRowCount;

        }
    }

    public void renderNoteView(Note note, int column, int row) {
        Button noteBtn = new Button(note.getTitle());
        String title = note.getTitle();
        String content = note.getContent();
        String idStr = "" + note.getId();
        System.out.println("#" + idStr + " " + title + " - " + content);

        noteBtn.setOnAction(event -> {
            this.controller.getTitleInput().setText(title);
            this.controller.getContentInput().setText(content);
            this.controller.getIdLabel().setText(idStr);
            this.controller.getUpsertBtn().setText("Edit");
        });

        GridPane.setHalignment(noteBtn, HPos.CENTER);
        GridPane.setHalignment(noteBtn, HPos.CENTER);
        //grid.add (node, collumn, row)
        this.noteGrid.add(noteBtn, column, row);
    }

    public void updateView(Note note) {
        Label newNoteView = new Label(note.getTitle());
        System.out.println();
    }


}
