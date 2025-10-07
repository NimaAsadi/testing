package com.example.devflowmaster.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Note {
    private Long id;
    private String title;
    private String content;
}
