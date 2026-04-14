package com.example.notesapp.repository;

import com.example.notesapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends  JpaRepository<Note, Long>{
    List<Note> findByUserId(Long userId);
}


//@Entity → класс = таблица (энтити
//👉 Если Entity нужно сохранять в базе → нужен Repository