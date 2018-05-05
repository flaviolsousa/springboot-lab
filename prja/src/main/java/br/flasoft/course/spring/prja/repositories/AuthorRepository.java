package br.flasoft.course.spring.prja.repositories;

import org.springframework.data.repository.CrudRepository;

import br.flasoft.course.spring.prja.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
