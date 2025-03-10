package org.boot.services;

import org.boot.builder.BookBuilder;
import org.boot.entity.BookEntity;
import org.boot.model.BookModel;
import org.boot.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServicesImpl implements BookServices {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private BookBuilder bookBuilder;

    @Override
    public List<BookModel> getAllBooks() {
        List<BookEntity> be = bookRepo.findAll();
        return bookBuilder.getBookModel(be);
    }

    @Override
    public List<BookModel> getBookById(String bookId) {
        List<BookEntity> be = bookRepo.findByBookId(bookId);
        return bookBuilder.getBookModel(be);
    }

    @Override
    public void createBook(BookModel bookModel) {
        bookRepo.save(bookBuilder.buildBookEntity(bookModel));
    }

}
