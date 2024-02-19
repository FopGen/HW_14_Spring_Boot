package com.example.HW_14_Spring;

import java.util.List;
import java.util.UUID;

public interface NoteService {
     List<Note> listAll();

     Note add(Note note);

     void deleteById(UUID id) throws Exception;

     void update(Note note) throws Exception;

     Note getById(UUID id) throws Exception;

}
