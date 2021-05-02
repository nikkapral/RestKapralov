package com.example.nikkapral.server.service;

import com.example.nikkapral.server.entity.Note;
import com.example.nikkapral.server.entity.Order;
import com.example.nikkapral.server.repository.NoteRepository;
import com.example.nikkapral.server.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public void create(Note note){
        noteRepository.save(note);
    }

    public List<Note> findAll(){
        return noteRepository.findAll();
    }

    public Note find(Long id){ return noteRepository.getOne(id); }

    public void delete(Long id){ noteRepository.deleteById(id); }
}
