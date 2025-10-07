package com.example.devflowmaster.service;

import com.example.devflowmaster.adapter.NoteAdapter;
import com.example.devflowmaster.dto.CreateNoteRequestDTO;
import com.example.devflowmaster.dto.UpdateNoteRequestDTO;
import com.example.devflowmaster.entity.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final Map<Long, Note> notes = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public List<Note> getAllNotes() {
        return new ArrayList<>(notes.values());
    }

    @Override
    public Note getNoteById(Long id) {
        Note note = notes.get(id);
        if (Objects.isNull(note)) {
            throw new RuntimeException("record not found");
        }
        return note;
    }

    @Override
    public void createNote(CreateNoteRequestDTO request) {
        Long id = idCounter.getAndIncrement();
        notes.put(id, NoteAdapter.adapt(id, request));
    }

    @Override
    public void updateNote(Long id, UpdateNoteRequestDTO updateRequest) {
        Note existing = notes.get(id);
        if (Objects.isNull(existing)) {
            throw new RuntimeException("record not found");
        }
        NoteAdapter.adapt(existing, updateRequest);
    }

    @Override
    public boolean deleteNote(Long id) {
        return notes.remove(id) != null;
    }
}
