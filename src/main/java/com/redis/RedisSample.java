package com.redis;

import com.redis.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisSample implements ApplicationRunner {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = User.builder()
                .name("테스터")
                .age(13)
                .build();

        ValueOperations<String, Object> vop = redisTemplate.opsForValue();
        vop.set("test2", user);
        User result = (User) vop.get("test2");
        System.out.println(result.toString());

        vop.set("test1", "test1Value");
        String result2 = (String) vop.get("test1");
        System.out.println(result2);
    }
}
