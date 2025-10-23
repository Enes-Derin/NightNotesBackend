package com.enesderin.NightNotes.service.impl;

import com.enesderin.NightNotes.dto.NoteRequest;
import com.enesderin.NightNotes.dto.NoteResponse;
import com.enesderin.NightNotes.exception.BaseException;
import com.enesderin.NightNotes.exception.ErrorMessage;
import com.enesderin.NightNotes.exception.MessageType;
import com.enesderin.NightNotes.exception.handler.Exception;
import com.enesderin.NightNotes.exception.handler.GlobalExceptionHandler;
import com.enesderin.NightNotes.model.Note;
import com.enesderin.NightNotes.repository.NoteRepository;
import com.enesderin.NightNotes.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    @Override
    public NoteResponse getNote(Long id) {
        Optional<Note> optionalNote = this.noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            NoteResponse noteResponse = new NoteResponse();
            BeanUtils.copyProperties(note, noteResponse);
            return noteResponse;
        }
throw new BaseException(new ErrorMessage(MessageType.NOTE_NOT_FOUND,""));
    }

    @Override
    public List<NoteResponse> getNotes() {
        List<Note> noteList = this.noteRepository.findAll();
        List<NoteResponse> noteResponseList = new ArrayList<>();
        for (Note note : noteList) {
            NoteResponse noteResponse = new NoteResponse();
            BeanUtils.copyProperties(note, noteResponse);
            noteResponseList.add(noteResponse);
        }
        return noteResponseList;
    }

    @Override
    public NoteResponse addNote(NoteRequest noteRequest) {
        Note note = new Note();
        BeanUtils.copyProperties(noteRequest, note);
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        Note noteSaved = this.noteRepository.save(note);
        NoteResponse noteResponse = new NoteResponse();
        BeanUtils.copyProperties(noteSaved, noteResponse);
        return noteResponse;
    }

    @Override
    public NoteResponse updateNote(Long id, NoteRequest noteRequest) {
        Optional<Note> optionalNote = this.noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            BeanUtils.copyProperties(noteRequest, note);
            note.setUpdatedAt(LocalDateTime.now());
            Note noteSaved = this.noteRepository.save(note);
            NoteResponse noteResponse = new NoteResponse();
            BeanUtils.copyProperties(noteSaved, noteResponse);
            return noteResponse;
        }
        throw new BaseException(new ErrorMessage(MessageType.NOTE_NOT_FOUND,""));
    }

    @Override
    public String deleteNote(Long id) {
        this.noteRepository.deleteById(id);
        return "Deleted Note";
    }
}
