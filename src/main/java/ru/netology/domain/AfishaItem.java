package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class AfishaItem{
    public int id;
    private String filmName;
    private String filmGenre;
}
