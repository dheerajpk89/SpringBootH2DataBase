package org.boot.repo;

import org.boot.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Serializable> {
    List<BookEntity> findByBookId(String bookId);
}
