package org.boot.rest;

import org.boot.model.AuthorModel;
import org.boot.model.BookModel;
import org.boot.services.BookServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServicesControllerTest {

    @InjectMocks
    private BookServicesController controler;

    @Mock
    private BookServices bookServices;

    @Test
    public void testgetAllBooks() {
        when(bookServices.getAllBooks()).thenReturn(getBookModel());

        List<BookModel> bList = controler.getAllBooks();

        verify(bookServices, times(1)).getAllBooks();

        assertThat(bList).isNotNull();
        assertThat(bList.get(0).getBookId()).isEqualTo("bookId");
        assertThat(bList.get(0).getName()).isEqualTo("name");
    }

    @Test
    public void testgetBookById() {
        when(bookServices.getBookById(any())).thenReturn(getBookModel());

        List<BookModel> bList = controler.getBookById(any());

        verify(bookServices, times(1)).getBookById(any());

        assertThat(bList).isNotNull();
        assertThat(bList.get(0).getBookId()).isEqualTo("bookId");
        assertThat(bList.get(0).getName()).isEqualTo("name");
    }

    @Test
    public void testcreateBook() {

        controler.createBook(any());

        verify(bookServices, times(1)).createBook(any());

    }

    private List<BookModel> getBookModel() {
        return List.of(BookModel.builder().name("name").bookId("bookId").authors(List.of(AuthorModel.builder().name("aname").build())).build());
    }
}
