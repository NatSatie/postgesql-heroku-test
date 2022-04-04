package com.example.postgesqlherokutest.model;

import com.example.postgesqlherokutest.enums.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="editors")
public class Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="editor_name")
    private String editor_name;

    public Editor(String editor_name ) {
        this.editor_name = editor_name;
    }
}
