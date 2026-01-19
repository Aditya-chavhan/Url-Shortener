package com.urlshortener.controller;

import com.urlshortener.model.Url;
import com.urlshortener.service.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    // Create Short URL
    @PostMapping("/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody Map<String, String> request) {
        Url url = urlService.shortenUrl(request.get("url"));

        return ResponseEntity.ok(Map.of(
                "originalUrl", url.getOriginalUrl(),
                "shortUrl", "http://localhost:8080/" + url.getShortUrl()
        ));
    }

    // Redirect
    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> redirect(@PathVariable String shortUrl) {
        Url url = urlService.getOriginalUrl(shortUrl);
        return ResponseEntity.status(302)
                .location(URI.create(url.getOriginalUrl()))
                .build();
    }
}
