package com.example.demo.entity;

import com.example.demo.repository.table.BookTable;
import com.example.demo.repository.table.PublisherTable;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Publisher {
    @NotNull
    private final Long id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String address;

    public PublisherTable toPublisherTable() {
        return new PublisherTable(this.id, this.name, this.address);
    }
}
