package com.twiki.repositories;

import com.twiki.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements SearchRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> searchFilter(String searchTerm) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Book> bookRoot = criteriaQuery.from(Book.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.like(bookRoot.get("title"), "%" + searchTerm + "%"));
        criteriaQuery
                .select(bookRoot)
                .where(predicates.toArray(new Predicate[]{}));

        return em.createQuery(criteriaQuery).getResultList();
    }
}
