package com.archive.sukjulyo.hashtag.repository;

import com.archive.sukjulyo.hashtag.domain.Hashtag;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryHashtagRepository implements HashtagRepository {
    private static Map<Long, Hashtag> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Hashtag save(Hashtag hashtag) {
        hashtag.setId(++sequence);
        store.put(hashtag.getId(), hashtag);
        return hashtag;
    }

    @Override
    public Optional<Hashtag> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Hashtag> findByTag(String tag) {
        return store.values().stream()
                .filter(member -> member.getTag().equals(tag))
                .findAny();
    }

    @Override
    public List<Hashtag> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearstore() {
        store.clear();
    }
}
