package com.example.service.services;

import com.example.service.dto.NoteDto;
import com.example.data.NoteRepository;
import com.example.service.exception.NoteNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<NoteDto> listAll(){
        return noteRepository.findAllNotes();
    }

    @Override
    public NoteDto add(NoteDto noteDto){
        return noteRepository.createNote(noteDto);
    }

    @Override
    public void deleteById(UUID id) throws NoteNotFoundException {
        noteRepository.deleteById(id);
    }

    @Override
    public void update(NoteDto noteDto) throws NoteNotFoundException {
        if(Objects.isNull(noteDto.getId())){
            throw new NoteNotFoundException(noteDto.getId());
        }
        noteRepository.updateNote(noteDto);
    }

    @Override
    public NoteDto getById(UUID id) throws NoteNotFoundException {
        return noteRepository.findById(id);
    }

    @PostConstruct
    public void init() throws Exception {
        NoteDto n1 = new NoteDto();
        n1.setTitle("Note #1");
        n1.setContent("This is note #1");
        add(n1);
        NoteDto n2 = new NoteDto();
        n2.setTitle("Note #2");
        n2.setContent("This is note #2");
        add(n2);
//
//        System.out.println(noteRepository.findAllNotes());
//
//        Note n3 = new Note();
//        n3.setTitle("Note#3");
//        n3.setContent("This is note #3");

//        try{
//            noteRepository.deleteById(UUID.randomUUID());//Exception
//            noteRepository.updateNote(n3);
//            System.out.println(noteRepository.findAllNotes());
//            System.out.println(noteRepository.findById(n2.getId()));

//        }catch (NullPointerException e){
//            System.out.println(e.getMessage());
//        }
    }
}
