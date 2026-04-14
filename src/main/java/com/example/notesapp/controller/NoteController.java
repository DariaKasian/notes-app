package com.example.notesapp.controller;

import com.example.notesapp.model.Note;
import com.example.notesapp.repository.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Класс — это API (принимает и отдаёт HTTP-запросы)
@RestController
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/notes")
    public List<Note> getallNotes() {
        return  noteRepository.findAll();
    }

    @PostMapping("/notes")
    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
    }
}
