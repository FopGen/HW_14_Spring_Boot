package com.example.controller;

import com.example.service.dto.NoteDto;
import com.example.service.exception.NoteNotFoundException;
import com.example.service.services.NoteService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;
@Validated
@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired private NoteService noteService;
    @GetMapping("/list")
    public ModelAndView getListNote(){
        ModelAndView result = new ModelAndView("note/list");
        result.addObject("notes", noteService.listAll());
        return result;
    }
    @PostMapping("/delete")
    public ModelAndView deleteNote(UUID id) throws NoteNotFoundException {
        ModelAndView result = new ModelAndView();
        noteService.deleteById(id);
        return getListNote();
    }
    @GetMapping("/edit")
    public ModelAndView editNote(@NotNull @RequestParam(value = "id") UUID id) throws NoteNotFoundException {
        ModelAndView result = new ModelAndView("note/update");
        result.addObject("note", noteService.getById(id));
        return result;
    }
    @PostMapping("/update")
    public ModelAndView updateNote(@NotNull @RequestParam(value = "id") UUID id,
                                   @RequestParam(value = "title") String title,
                                   @RequestParam(value = "content") String content) throws NoteNotFoundException {
        NoteDto dto = new NoteDto();
        dto.setId(id);
        dto.setTitle(title);
        dto.setContent(content);
        noteService.update(dto);
        return getListNote();
    }
}
