package com.archive.sukjulyo.hashtag.service;

import com.archive.sukjulyo.hashtag.domain.Hashtag;
import com.archive.sukjulyo.hashtag.repository.HashtagRepository;
import com.archive.sukjulyo.hashtag.repository.MemoryHashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class HashtagService {
    private final HashtagRepository hashtagRepository;

    @Autowired
    public HashtagService(HashtagRepository hashtagRepository) {
        this.hashtagRepository = hashtagRepository;
    }

    public Long join(Hashtag hashtag) {
        validateDuplicateHashtag(hashtag);
        hashtagRepository.save(hashtag);
        return hashtag.getId();
    }

    private void validateDuplicateHashtag(Hashtag hashtag) {
        hashtagRepository.findByTag(hashtag.getTag())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 해시태그입니다.");
                });
    }

    public List<Hashtag> findHashtags() {
        return hashtagRepository.findAll();
    }

    public Optional<Hashtag> findOne(Long hashtagId) {
        return hashtagRepository.findById(hashtagId);
    }
}
