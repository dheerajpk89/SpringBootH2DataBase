package org.boot.rest;

import org.boot.model.BookModel;
import org.boot.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookServicesController {
    @Autowired
    private BookServices bookServices;

    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
    public List<BookModel> getAllBooks() {
        return bookServices.getAllBooks();
    }

    @RequestMapping(value = "/searchByBookId", method = RequestMethod.GET)
    public List<BookModel> getBookById(@RequestParam(required = true) String bookId) {
        return bookServices.getBookById(bookId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createBook(@RequestBody BookModel bookModel) {
        bookServices.createBook(bookModel);
    }
}
