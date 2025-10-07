package com.example.devflowmaster.adapter;

import com.example.devflowmaster.dto.CreateNoteRequestDTO;
import com.example.devflowmaster.dto.UpdateNoteRequestDTO;
import com.example.devflowmaster.entity.Note;

public final class NoteAdapter {

    private NoteAdapter() {
        throw new RuntimeException();
    }

    public static Note adapt(Long id, CreateNoteRequestDTO request) {
        return new Note(id, request.title(), request.content());
    }

    public static void adapt(Note note, UpdateNoteRequestDTO updateNoteRequestDTO) {
        note.setTitle(updateNoteRequestDTO.title());
        note.setContent(updateNoteRequestDTO.content());
    }
}
