package com.redis.dto;

import lombok.*;

@NoArgsConstructor
@ToString
@Setter
@Getter
public class User {
    private String name;
    private Integer age;

    @Builder
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
