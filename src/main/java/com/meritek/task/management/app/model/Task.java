package com.meritek.task.management.app.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    //Default status is TODO
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskEnum status = TaskEnum.TODO;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "taskAuthor", joinColumns = @JoinColumn(name = "taskID"), inverseJoinColumns = @JoinColumn(name = "authorID"))
    private List<Author> authors = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
