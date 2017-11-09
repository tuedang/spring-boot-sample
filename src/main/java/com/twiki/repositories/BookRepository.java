package com.twiki.repositories;

import com.twiki.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "books", path = "book")
public interface BookRepository extends PagingAndSortingRepository<Book, String>, SearchRepositoryCustom {

    Iterable<Book> findBooksByAuthor(@Param("author") String author);

    @Query("SELECT p FROM Book p WHERE p.title LIKE %:searchTerm%")
    List<Book> searchTitle(@Param("searchTerm") String searchTerm);
}
