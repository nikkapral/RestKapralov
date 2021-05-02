package com.example.nikkapral.server.repository;

import com.example.nikkapral.server.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {
}
