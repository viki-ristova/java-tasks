package com.seavus.talent.Notes.api;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.service.NoteService;
import com.seavus.talent.Notes.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {
    private NoteService noteService;
    private TagService tagService;

    @Autowired
    public NoteController(NoteService noteService, TagService tagService) {
        this.noteService = noteService;
        this.tagService = tagService;
    }

    public static class CreateNoteRequest {
        public String title;
        public String content;
    }

    @PostMapping("/api/notes")
    public Note createNote(@RequestBody CreateNoteRequest request) {
        return noteService.createNote(request.title, request.content);
    }

    @GetMapping("/api/notes/{id}")
    public Note findNote(@PathVariable Long id) {
        return noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/api/notes")
    public List<Note> findNotes() {
        return noteService.findNotes();
    }

    @DeleteMapping("/api/notes/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }
    @PutMapping("/api/notes/{id}")
    public Optional<Note> updateNote(@RequestBody Note note, @PathVariable Long id){
        return noteService.updateNote(id, note);

    }
   /* @GetMapping("/api/notes/tags/{tagId}")
    public List<Note> findNotesByTagId(@PathVariable Long tagId){
        return noteService.findNotesByTagId(tagId);
    }
*/
    public static class CreateTagRequest {
        public String name;
    }

    @PostMapping("/api/notes/tags")   //drugata opcija e da ostane /api/notes
    public Tag createTag(@RequestBody CreateTagRequest request) {
        return tagService.createTag(request.name);
    }

    @GetMapping("/api/notes/tags")
    public List<Tag> findTags(@PathVariable Long userId)
    {
        return tagService.findTagsByUserId(userId);
    }

    @PutMapping("/api/notes/tags/{tagId}")
    public Optional<Tag> updateTag(@RequestBody Tag tag, @PathVariable Long tagId){
        return tagService.updateTag(tagId, tag);

    }
    @DeleteMapping("/api/notes/tags/{tagId}")
    public void deleteTag(@PathVariable Long tagId){
        tagService.deleteTag(tagId);
    }

}
