package org.boot.builder;

import org.boot.entity.AuthorEntity;
import org.boot.entity.BookEntity;
import org.boot.model.AuthorModel;
import org.boot.model.BookModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BookBuilder {
    public List<BookModel> getBookModel(List<BookEntity> be) {
        List<BookModel> bm = new ArrayList<>();
        be.forEach(b ->
                bm.add((BookModel.builder()
                        .name(b.getBookName())
                        .bookId(b.getBookId())
                        .authors(getAuthorModel(b.getAuthorEntity()))
                        .build())
                ));
        return bm;
    }

    private List<AuthorModel> getAuthorModel(List<AuthorEntity> ae) {
        List<AuthorModel> am = new ArrayList<>();
        ae.forEach(a ->
                am.add(AuthorModel.builder()
                        .name(a.getName())
                        .build())
        );
        return am;
    }

    public BookEntity buildBookEntity(BookModel bookModel) {
        return BookEntity.builder()
                .bookId(bookModel.getBookId())
                .bookName(bookModel.getName())
                .createDate(new Date())
                .modifiedDate(new Date())
                .authorEntity(getAuthorEntity(bookModel.getAuthors()))
                .build();
    }

    private List<AuthorEntity> getAuthorEntity(List<AuthorModel> authors) {
        List<AuthorEntity> ae = new ArrayList<>();
        authors.forEach(a ->
                ae.add(AuthorEntity.builder()
                        .name(a.getName())
                        .build())
        );
        return ae;
    }
}
