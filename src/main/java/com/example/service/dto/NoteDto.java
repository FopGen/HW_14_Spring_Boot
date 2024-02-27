package com.example.service.dto;

import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class NoteDto {
    private UUID id;
    private String title;
    private String content;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "+++++ " + title + ", " + content + ", id= " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteDto noteDto = (NoteDto) o;
        return Objects.equals(id, noteDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
