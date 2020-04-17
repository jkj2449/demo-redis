package com.redis.controller;

import com.redis.config.CacheKey;
import com.redis.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CacheController {

    @Cacheable(value = CacheKey.USER, key = "#id", unless = "#result == null", cacheManager = "cacheManager")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable String id) {
        return getUser(id, "Cacheable 테스트");
    }

    @CachePut(value = CacheKey.USER, key = "#user.id", cacheManager = "cacheManager")
    @PutMapping("/user")
    public User update(@RequestBody User user) {
        return user;
    }

    @CacheEvict(value = CacheKey.USER, key = "#id", cacheManager = "cacheManager")
    @DeleteMapping("/user/{id}")
    public void deletePostByID(@PathVariable String id) {
        log.info("delete id {}", id);
    }

    private User getUser(String id, String name) {
        return User.builder()
                .id(id)
                .name(name)
                .age(20)
                .build();
    }
}
