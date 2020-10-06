package com.seavus.talent.Notes.repository;

import com.seavus.talent.Notes.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findAllByUserId(long userId);
}
