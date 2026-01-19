package com.urlshortener.service;

import com.urlshortener.model.Url;

public interface UrlService {

    Url shortenUrl(String originalUrl);

    Url getOriginalUrl(String shortUrl);
}
