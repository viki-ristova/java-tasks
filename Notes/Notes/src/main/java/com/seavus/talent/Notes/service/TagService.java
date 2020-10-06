package com.seavus.talent.Notes.service;

import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.repository.NoteRepository;
import com.seavus.talent.Notes.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TagService {

    private TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag createTag(String name) {
        Tag tag = new Tag(name);
        tagRepository.save(tag);
        return tag;
    }

    public List<Tag> findTagsByUserId(Long userId) {
        return tagRepository.findAllByUserId(userId);
    }

    public Optional<Tag> updateTag(Long tagId, Tag tag) {
        return tagRepository.findAll().stream()
                .filter(t -> t.getId().equals(tagId))
                .peek(t -> t.setName(tag.getName()))
                .findFirst();
    }

    public void deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
    }
}
