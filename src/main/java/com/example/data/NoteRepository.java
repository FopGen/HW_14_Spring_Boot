package com.example.data;

import com.example.service.dto.NoteDto;
import com.example.service.exception.NoteNotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Component
public class NoteRepository {

    private List<NoteDto> noteDtos = new ArrayList<>();

    public NoteDto createNote(NoteDto noteDto) {
        noteDto.setId(UUID.randomUUID());
        this.noteDtos.add(noteDto);
        return noteDto;
    }

    public List<NoteDto> findAllNotes() {
        return this.noteDtos;
    }

    public void deleteById(UUID id){

        this.noteDtos.stream()
        .filter(findNoteDto -> (findNoteDto.getId()==id))
        .findFirst()
        .ifPresent(noteDtos::remove);

    }

    public void updateNote(NoteDto noteDto) throws NoteNotFoundException {
        UUID idFindingNote = noteDto.getId();

        NoteDto noteDtoFromList = noteDtos.stream()
                .filter(findNoteDto -> (findNoteDto.getId().equals(idFindingNote)))
                .findFirst()
                .orElseThrow((() -> new NoteNotFoundException(idFindingNote)));

            noteDtoFromList.setTitle(noteDto.getTitle());
            noteDtoFromList.setContent(noteDto.getContent());
    }


    public NoteDto findById(UUID id) throws NoteNotFoundException {

        NoteDto noteDto = noteDtos.stream()
                        .filter(findNoteDto -> (findNoteDto.getId().equals(id)))
                        .findFirst()
                        .orElseThrow((() -> new NoteNotFoundException(id)));

        return noteDto;
    }
}
