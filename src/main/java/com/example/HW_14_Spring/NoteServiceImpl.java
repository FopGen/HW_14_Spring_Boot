package com.example.HW_14_Spring;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> listAll(){
        return noteRepository.findAllNotes();
    }

    @Override
    public Note add(Note note){
        return noteRepository.createNote(note);
    }

    @Override
    public void deleteById(UUID id) throws Exception {
        noteRepository.deleteById(id);
    }

    @Override
    public void update(Note note) throws Exception {
        noteRepository.updateNote(note);
    }

    @Override
    public Note getById(UUID id) throws Exception {
        return noteRepository.findById(id);
    }

    @PostConstruct
    public void init() throws Exception {
        Note n1 = new Note();
        n1.setTitle("Note #1");
        n1.setContent("This is note #1");
        add(n1);
        Note n2 = new Note();
        n2.setTitle("Note #2");
        n2.setContent("This is note #2");
        add(n2);

        System.out.println(noteRepository.findAllNotes());

        Note n3 = new Note();
        n3.setTitle("Note#3");
        n3.setContent("This is note #3");

        try{
            noteRepository.deleteById(UUID.randomUUID());
//            noteRepository.updateNote(n3);
//            System.out.println(noteRepository.findAllNotes());
//            System.out.println(noteRepository.findById(n2.getId()));

        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
