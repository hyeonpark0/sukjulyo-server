package com.archive.sukjulyo.hashtag.repository;

import com.archive.sukjulyo.hashtag.domain.Hashtag;

import java.util.List;
import java.util.Optional;

public interface HashtagRepository {
    Hashtag save(Hashtag hashtag);
    Optional<Hashtag> findById(Long id);
    Optional<Hashtag> findByTag(String tag);
    List<Hashtag> findAll();
}
