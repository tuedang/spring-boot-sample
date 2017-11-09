package com.twiki.repositories;

import com.twiki.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {

    Iterable<Book> findBooksByAuthor(@Param("author") String author);
}
