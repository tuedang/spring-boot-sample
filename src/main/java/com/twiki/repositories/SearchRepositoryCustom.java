package com.twiki.repositories;

import com.twiki.model.Book;

import java.util.List;

interface SearchRepositoryCustom {

    List<Book> searchFilter(String searchTerm);
}
