package kz.kassayev.demo.bootstrap;

import kz.kassayev.demo.model.Author;
import kz.kassayev.demo.model.Book;
import kz.kassayev.demo.model.Publisher;
import kz.kassayev.demo.repository.AuthorRepository;
import kz.kassayev.demo.repository.BookRepository;
import kz.kassayev.demo.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDate();
    }

    private void initDate(){

        Publisher publisher = new Publisher("Atamura","Almaty");
        publisherRepository.save(publisher);

        Author serzhan = new Author("Serzhan","Kassayev");
        Book gof = new Book("Design Patterns", "70707", publisher);
        serzhan.getBooks().add(gof);
        gof.getAuthors().add(serzhan);

        authorRepository.save(serzhan);
        bookRepository.save(gof);

        Author alibi = new Author("Alibi","Toigan");
        Book design = new Book("All about UI/UX","60606",publisher);
        alibi.getBooks().add(design);
        design.getAuthors().add(alibi);

        authorRepository.save(alibi);
        bookRepository.save(design);
    }

}
