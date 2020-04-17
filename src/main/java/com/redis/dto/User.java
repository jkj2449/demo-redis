package com.redis.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@ToString
@Setter
@Getter
public class User implements Serializable {
    private String id;
    private String name;
    private Integer age;

    @Builder
    public User(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
