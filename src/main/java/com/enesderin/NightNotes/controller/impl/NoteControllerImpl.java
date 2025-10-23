package com.enesderin.NightNotes.controller.impl;

import com.enesderin.NightNotes.controller.NoteController;
import com.enesderin.NightNotes.controller.RootEntity;
import com.enesderin.NightNotes.dto.NoteRequest;
import com.enesderin.NightNotes.dto.NoteResponse;
import com.enesderin.NightNotes.service.NoteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/note")
@AllArgsConstructor
public class NoteControllerImpl extends RootEntity implements NoteController {
    private NoteService noteService;

    @GetMapping("/{id}")
    @Override
    public RootEntity<NoteResponse> getNote(@PathVariable Long id) {
        return ok(noteService.getNote(id));
    }

    @GetMapping
    @Override
    public RootEntity<List<NoteResponse>> getNotes() {
        return ok(noteService.getNotes());
    }

    @PostMapping
    @Override
    public RootEntity<NoteResponse> addNote(@Valid @RequestBody NoteRequest noteRequest) {
        return ok(noteService.addNote(noteRequest));
    }

    @PutMapping("/update/{id}")
    @Override
    public RootEntity<NoteResponse> updateNote(@PathVariable Long id,@Valid @RequestBody NoteRequest noteRequest) {
        return ok(noteService.updateNote(id, noteRequest));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public RootEntity<String> deleteNote(@PathVariable Long id) {
        return ok(noteService.deleteNote(id));
    }
}
