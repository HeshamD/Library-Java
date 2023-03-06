package org.example.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Books {
    private String title;
    private String author;
    private String ISBN;
    private int num_copies;

}
