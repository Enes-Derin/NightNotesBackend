package com.enesderin.NightNotes.service;

import com.enesderin.NightNotes.dto.NoteRequest;
import com.enesderin.NightNotes.dto.NoteResponse;

import java.util.List;

public interface NoteService {
    NoteResponse getNote(Long id);
    List<NoteResponse> getNotes();
    NoteResponse addNote(NoteRequest noteRequest);
    NoteResponse updateNote(Long id, NoteRequest noteRequest);
    String deleteNote(Long id);
}
