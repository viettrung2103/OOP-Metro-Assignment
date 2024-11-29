package model;

import java.util.HashMap;

public class NoteList {
    public HashMap<Integer, Note> notes;

    public NoteList() {
        this.notes = new HashMap<>();
    }


//    public void addNote(String title, String content) {
//        Note newNote = new Note(title, content);
//        int id = newNote.getId();
//        System.out.println(newNote + "is added.");
//        this.notes.put(id, newNote);
//    }


    public void addNote(String idStr, String title, String content) {
        Note newNote;
        int id;
        if (!idStr.equals("")) {
            id = Integer.getInteger(idStr);
            newNote = new Note(Integer.getInteger(idStr), title, content);
            System.out.println("Adding new note " + newNote);
        } else {

            newNote = new Note(title, content);
            id = newNote.getId();
            System.out.println("Editing not" + newNote);
        }
        System.out.println(newNote);
        this.notes.put(id, newNote);
    }

    private boolean isNoteExist(int id) {
        return this.notes.containsKey(id);
    }

    public Note getNoteInfo(int id) {
        if (this.notes.containsKey(id)) {
            Note foundNote = this.notes.get(id);
            System.out.println(foundNote);
            return this.notes.get(foundNote);
        }
        System.out.println("Note not found! Cannot retrieve info");
        return null;
    }

    public HashMap<Integer, Note> getNotes() {
        return this.notes;
    }

    public Note removeNote(Note note) {
        int noteId = note.getId();
        if (this.isNoteExist(noteId)) {
            System.out.println(note + "is removed");
            return this.notes.remove(noteId);
        }
        System.out.println("Note not found! Cannot remove");
        return null;
    }
}
