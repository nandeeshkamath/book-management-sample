package com.example.demo.repository;

import com.example.demo.repository.table.BookTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookTable, Long> {
}
