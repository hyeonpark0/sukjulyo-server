package com.archive.sukjulyo.hashtag.service;

import com.archive.sukjulyo.hashtag.domain.Hashtag;
import com.archive.sukjulyo.hashtag.repository.MemoryHashtagRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class HashtagServiceTest {
    HashtagService hashtagService;
    MemoryHashtagRepository hashtagRepository;

    @BeforeEach
    public void beforeEach() {
        hashtagRepository = new MemoryHashtagRepository();
        hashtagService = new HashtagService(hashtagRepository);
    }

    @AfterEach
    public void afterEach() {
        hashtagRepository.clearstore();
    }

    @Test
    public void saveHashtag() throws Exception {
        Hashtag hashtag = new Hashtag("hello", 1);

        Long saveId = hashtagService.join(hashtag);

        Hashtag findHashtag = hashtagRepository.findById(saveId).get();
        assertEquals(hashtag.getTag(), findHashtag.getTag());
    }

    @Test
    public void DuplicateHashtagException() throws Exception {
        Hashtag hashtag1 = new Hashtag("spring", 1);
        Hashtag hashtag2 = new Hashtag("spring", 1);

        hashtagService.join(hashtag1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> hashtagService.join(hashtag2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 해시태그입니다.");
    }
}
