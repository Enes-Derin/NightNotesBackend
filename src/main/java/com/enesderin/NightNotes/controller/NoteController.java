package com.enesderin.NightNotes.controller;

import com.enesderin.NightNotes.dto.NoteRequest;
import com.enesderin.NightNotes.dto.NoteResponse;

import java.util.List;

public interface NoteController {
    RootEntity<NoteResponse> getNote(Long id);
    RootEntity<List<NoteResponse>> getNotes();
    RootEntity<NoteResponse> addNote(NoteRequest noteRequest);
    RootEntity<NoteResponse> updateNote(Long id, NoteRequest noteRequest);
    RootEntity<String> deleteNote(Long id);
}
