package com.example.service.services;

import com.example.service.dto.NoteDto;
import com.example.service.exception.NoteNotFoundException;

import java.util.List;
import java.util.UUID;

public interface NoteService {
     List<NoteDto> listAll();

     NoteDto add(NoteDto noteDto);

     void deleteById(UUID id) throws NoteNotFoundException;

     void update(NoteDto noteDto) throws NoteNotFoundException;

     NoteDto getById(UUID id) throws NoteNotFoundException;

}
