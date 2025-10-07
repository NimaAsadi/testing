package com.example.devflowmaster.service;

import com.example.devflowmaster.dto.CreateNoteRequestDTO;
import com.example.devflowmaster.dto.UpdateNoteRequestDTO;
import com.example.devflowmaster.entity.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();

    Note getNoteById(Long id);

    void createNote(CreateNoteRequestDTO request);

    void updateNote(Long id, UpdateNoteRequestDTO updateRequest);

    boolean deleteNote(Long id);
}
