package org.boot.services;

import org.boot.model.BookModel;

import java.util.List;

public interface BookServices {

    List<BookModel> getAllBooks();

    List<BookModel> getBookById(String bookId);

    void createBook(BookModel bookModel);
}
