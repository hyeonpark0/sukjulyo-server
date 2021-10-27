package com.archive.sukjulyo.hashtag.repository;

import com.archive.sukjulyo.hashtag.domain.Hashtag;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryHashtagRepositoryTest {
    MemoryHashtagRepository repository = new MemoryHashtagRepository();

    @AfterEach
    public void afterEach() {
        repository.clearstore();
    }

    @Test
    public void save() {
        Hashtag hashtag = new Hashtag("spring", 1);
        repository.save(hashtag);

        Hashtag result = repository.findById(hashtag.getId()).get();
        assertThat(result).isEqualTo(hashtag);
    }

    @Test
    public void findByName() {
        Hashtag hashtag1 = new Hashtag("spring1", 1);
        repository.save(hashtag1);

        Hashtag hashtag2 = new Hashtag("spring2", 2);
        repository.save(hashtag2);

        Hashtag result = repository.findByTag("spring1").get();

        assertThat(result).isEqualTo(hashtag1);
    }

    @Test
    public void findAll() {
        Hashtag hashtag1 = new Hashtag("spring1", 1);
        repository.save(hashtag1);

        Hashtag hashtag2 = new Hashtag("spring2", 2);
        repository.save(hashtag2);

        List<Hashtag> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
