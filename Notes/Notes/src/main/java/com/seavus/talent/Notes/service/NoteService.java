package com.seavus.talent.Notes.service;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.repository.NoteRepository;
import com.seavus.talent.Notes.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(String title, String content) {
        Note note = new Note(title, content);
        noteRepository.save(note);
        return note;
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findNotes() {
        return noteRepository.findAll();
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public Optional<Note> updateNote(Long id, Note note) {
        return noteRepository.findAll().stream()
                .filter(n -> n.getId().equals(id))
                .peek(n -> n.setTitle(note.getTitle()))
                .peek(n -> n.setContent(note.getContent()))
                .findFirst();
    }

   /* public List<Note> findNotesByTagId(Long tagId) {
        return noteRepository.findNotesByTagId();
    }
*/

}
