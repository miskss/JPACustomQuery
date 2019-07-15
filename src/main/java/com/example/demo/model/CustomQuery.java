package com.example.demo.model;

import java.time.Instant;

/**
 * @author peter
 * create: 2019-07-02 11:26
 **/
public interface CustomQuery {
    Long getId();

    String getName();

    String getNick();

    String getSex();

    String getAge();

    Instant getTime();

    Boolean getEnable();

    default String getString(){
        return "getId=" + getId()+";" +
                "getName=" + getName() +
                "; getNick=" + getNick()+
                "; getSex=" + getSex()+
                ";getAge= " + getAge() +
                ";getTime=" + getTime() +
                ";getEnable = "+ getEnable();
    }
}
