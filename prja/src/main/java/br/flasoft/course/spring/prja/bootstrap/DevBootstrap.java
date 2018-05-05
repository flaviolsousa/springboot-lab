package br.flasoft.course.spring.prja.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.flasoft.course.spring.prja.model.Author;
import br.flasoft.course.spring.prja.model.Book;
import br.flasoft.course.spring.prja.model.Publisher;
import br.flasoft.course.spring.prja.repositories.AuthorRepository;
import br.flasoft.course.spring.prja.repositories.BookRepository;
import br.flasoft.course.spring.prja.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData() {
		Publisher publisher = new Publisher();
		publisher.setName("Foo");
		
		publisherRepository.save(publisher);
		
		Author flavio = new Author("Flavio", "Sousa");
		Book ddd = new Book("Domain Driven Design", "1234", publisher);
		flavio.getBooks().add(ddd);
		ddd.getAuthors().add(flavio);

		authorRepository.save(flavio);
		bookRepository.save(ddd);

		Author jana = new Author("Janaina", "Correia");
		Book noEJB = new Book("J2EE Development without EJB", "4321", publisher);
		jana.getBooks().add(noEJB);
		noEJB.getAuthors().add(jana);

		authorRepository.save(jana);
		bookRepository.save(noEJB);

	}

}
