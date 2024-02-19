package com.example.HW_14_Spring;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Component
public class NoteRepository {

    private List<Note> notes = new ArrayList<>();

    public Note createNote(Note note) {
        note.setId(UUID.randomUUID());
        this.notes.add(note);
        return note;
    }

    public List<Note> findAllNotes() {
        return this.notes;
    }

    public void deleteById(UUID id) throws Exception {

        Note note = notes.stream()
                .filter(findNote -> (findNote.getId()==id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Note not found (-delete-)"));

            notes.remove(note);

    }

    public void updateNote(Note note) throws Exception {

        UUID idFindingNote = note.getId();

        Note noteFromList = notes.stream()
                .filter(findNote -> (findNote.getId()==idFindingNote))
                .findFirst()
                .orElseThrow((() -> new NullPointerException("Note not found (-update-)")));

            noteFromList.setTitle(note.getTitle());
            noteFromList.setContent(note.getContent());
    }


    public Note findById(UUID id) throws Exception {

        Note note = notes.stream()
                        .filter(findNote -> (findNote.getId()==id))
                        .findFirst()
                        .orElseThrow((() -> new NullPointerException("Note not found (-find-)")));

        return note;
    }
}
