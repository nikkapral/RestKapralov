package com.example.nikkapral.server.controller;

import com.example.nikkapral.server.entity.Note;
import com.example.nikkapral.server.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class NoteController {
    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @PostMapping(value = "/notes")
    public ResponseEntity<?> create(@RequestBody Note note){
        noteService.create(note);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/notes")
    public ResponseEntity<List<Note>> findAll(){
        final List<Note> noteList = noteService.findAll();

        return noteList != null && !noteList.isEmpty()
                ? new ResponseEntity<>(noteList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/notes/{id}")
    public ResponseEntity<Note> find(@PathVariable(name="id") Long id){
        final Note note = noteService.find(id);

        return note != null
                ? new ResponseEntity<>(note, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/note")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id){
        noteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}