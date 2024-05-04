package com.HpyerTest.Application.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "contents")
    private String contents;
}
