package com.example.devflowmaster.controller;

import com.example.devflowmaster.dto.CreateNoteRequestDTO;
import com.example.devflowmaster.dto.UpdateNoteRequestDTO;
import com.example.devflowmaster.entity.Note;
import com.example.devflowmaster.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping("{id}")
    public ResponseEntity<Note> getById(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.getNoteById(id));
    }

    @PostMapping
    public void create(@RequestBody CreateNoteRequestDTO request) {
        noteService.createNote(request);
        ResponseEntity.ok();
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateNoteRequestDTO request) {
        noteService.updateNote(id, request);
        ResponseEntity.ok();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        noteService.deleteNote(id);
        ResponseEntity.ok();
    }
}
