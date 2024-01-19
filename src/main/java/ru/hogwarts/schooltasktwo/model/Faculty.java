package ru.hogwarts.schooltasktwo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
@Data
@NoArgsConstructor
@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private String color;

}
