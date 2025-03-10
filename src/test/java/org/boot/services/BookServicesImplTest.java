package org.boot.services;

import org.boot.builder.BookBuilder;
import org.boot.entity.AuthorEntity;
import org.boot.entity.BookEntity;
import org.boot.model.AuthorModel;
import org.boot.model.BookModel;
import org.boot.repo.BookRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServicesImplTest {
    @InjectMocks
    private BookServicesImpl bookServicesImpl;
    @Mock
    private BookRepo bookRepo;
    @Spy
    private BookBuilder bookBuilder;

    @Test
    public void testgetAllBooks() {
        when(bookRepo.findAll()).thenReturn(getBookEntityList());
        List<BookModel> bm = bookServicesImpl.getAllBooks();
        verify(bookRepo, times(1)).findAll();
        verify(bookBuilder, times(1)).getBookModel(any());

        assertThat(bm).isNotNull();
        assertThat(bm.get(0).getBookId()).isEqualTo("bookId");
        assertThat(bm.get(0).getName()).isEqualTo("bookName");
        assertThat(bm.get(0).getAuthors().get(0).getName()).isEqualTo("name");

    }

    @Test
    public void testgetBookById() {
        when(bookRepo.findByBookId(any())).thenReturn(getBookEntityList());
        List<BookModel> bm = bookServicesImpl.getBookById(any());
        verify(bookRepo, times(1)).findByBookId(any());
        verify(bookBuilder, times(1)).getBookModel(any());

        assertThat(bm).isNotNull();
        assertThat(bm.get(0).getBookId()).isEqualTo("bookId");
        assertThat(bm.get(0).getName()).isEqualTo("bookName");
        assertThat(bm.get(0).getAuthors().get(0).getName()).isEqualTo("name");

    }

    @Test
    public void testcreateBook() {

        bookServicesImpl.createBook(getBookModel());

        verify(bookBuilder, times(1)).buildBookEntity(any());
    }

    private BookEntity getBookEntity() {
        return BookEntity.builder()
                .id(1)
                .bookName("bookName")
                .modifiedDate(new Date())
                .createDate(new Date())
                .bookId("bookId")
                .authorEntity(List.of(AuthorEntity.builder()
                        .id(1)
                        .name("name")
                        .build()))
                .build();
    }

    private BookModel getBookModel() {
        return BookModel.builder().name("name").bookId("bookId").authors(List.of(AuthorModel.builder().name("aname").build())).build();
    }

    private List<BookEntity> getBookEntityList() {
        return List.of(getBookEntity());
    }
}
