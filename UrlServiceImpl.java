package com.urlshortener.service;

import com.urlshortener.model.Url;
import com.urlshortener.repository.UrlRepository;
import com.urlshortener.util.Base62Encoder;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Url shortenUrl(String originalUrl) {
        Url url = new Url();
        url.setOriginalUrl(originalUrl);

        url = urlRepository.save(url);

        String shortCode = Base62Encoder.encode(url.getId());
        url.setShortUrl(shortCode);

        return urlRepository.save(url);
    }

    @Override
    public Url getOriginalUrl(String shortUrl) {
        Url url = urlRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        url.setClickCount(url.getClickCount() + 1);
        urlRepository.save(url);

        return url;
    }
}
