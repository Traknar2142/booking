package com.prime.booking.service;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import com.prime.booking.annotations.CustomSpan;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TokenService {
    private final RedisTemplate<String, String> redisTemplate;

    @CustomSpan
    public void saveToken(String username, String token) {
        redisTemplate.opsForValue().set(username, token, Duration.ofHours(1));
    }

    @CustomSpan
    public String getToken(String username) {
        return redisTemplate.opsForValue().get(username);
    }

    @CustomSpan
    public void deleteToken(String username) {
        redisTemplate.delete(username);
    }
}
