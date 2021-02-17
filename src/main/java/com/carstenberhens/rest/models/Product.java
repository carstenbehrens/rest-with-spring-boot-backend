package com.carstenberhens.rest.models;

import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Validated
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Title is mandatory")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Column(name = "description")
    private String description;

    public Product() {
    }

    public Product(String title, String name, String description) {
        this.title = title;
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
