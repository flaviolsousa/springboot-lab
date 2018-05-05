package br.flasoft.course.spring.prja.repositories;

import org.springframework.data.repository.CrudRepository;

import br.flasoft.course.spring.prja.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
