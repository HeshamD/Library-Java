package org.example.Entities;

import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Loans {
    private Books book;
    private Members member;
    private LocalDate due_date;
    private LocalDate returned_date;
    private float late_fee;
}
