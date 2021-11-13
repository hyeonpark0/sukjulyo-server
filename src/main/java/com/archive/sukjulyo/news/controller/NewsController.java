package com.archive.sukjulyo.news.controller;

import com.archive.sukjulyo.news.dto.NewsCreateDTO;
import com.archive.sukjulyo.news.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/news")
@RequiredArgsConstructor
public class NewsController {
	private final NewsService newsService;

	@PostMapping()
	public ResponseEntity createNews(@RequestBody NewsCreateDTO dto) {
		return ResponseEntity.ok(newsService.createNews(dto));
	}

	@DeleteMapping()
	public ResponseEntity deleteNews (@RequestParam(required = false) Long id) {
		newsService.deleteClient(id);
		return ResponseEntity.ok().build();
	}
}