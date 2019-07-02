package com.example.demo.entity;

import com.example.demo.InstantConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author peter
 * date: 2019-07-02 11:19
 **/
@Entity
@Data
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String nickName;

    private String gender;

    private Integer age;

    @Convert(converter = InstantConverter.class)
    private Instant createTime;


    public TestEntity(String username, String nickName, String gender, Integer age) {
        this.username = username;
        this.nickName = nickName;
        this.gender = gender;
        this.age = age;
        this.createTime = Instant.now();
    }
}


