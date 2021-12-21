package com.example.demo.entity;


import com.example.demo.repository.table.BookTable;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Year;

@Data
public class Book {
    @NotNull
    private final long id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String author;
    @NotNull
    private final Year publishedYear;
    @NotNull
    @Valid
    private final Publisher publisher;
    @Min(0)
    @NotNull
    private final Integer cost;

    public BookTable toBookTable() {
        return new BookTable(this.id, this.name, this.author, this.publishedYear, this.cost);
    }
}
