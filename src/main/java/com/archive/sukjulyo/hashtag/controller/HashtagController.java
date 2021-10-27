package com.archive.sukjulyo.hashtag.controller;

import com.archive.sukjulyo.hashtag.domain.Hashtag;
import com.archive.sukjulyo.hashtag.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HashtagController {
    private final HashtagService hashtagService;

    @Autowired
    public HashtagController(HashtagService hashtagService) {
        this.hashtagService = hashtagService;
    }

//    @GetMapping("/hashtags")
//    public List<Hashtag> getAllHashtag() {
//        return this.hashtagService.findHashtags();
//    }
//
//    @RequestMapping(value = "/hashtag/1", method = RequestMethod.GET)
//    public long createHashtag(@PathVariable String tag) {
//        return hashtagService.join(new Hashtag(tag, 1));
//    }
}
