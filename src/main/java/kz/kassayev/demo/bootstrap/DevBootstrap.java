package kz.kassayev.demo.bootstrap;

import kz.kassayev.demo.model.Author;
import kz.kassayev.demo.model.Book;
import kz.kassayev.demo.repository.AuthorRepository;
import kz.kassayev.demo.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDate();
    }

    private void initDate(){
        Author serzhan = new Author("Serzhan","Kassayev");
        Book gof = new Book("Design Patterns", "70707", "Atamura");
        serzhan.getBooks().add(gof);
        gof.getAuthors().add(serzhan);

        authorRepository.save(serzhan);
        bookRepository.save(gof);

        Author alibi = new Author("Alibi","Toigan");
        Book design = new Book("All about UI/UX","60606","Astana kitap");
        alibi.getBooks().add(design);
        design.getAuthors().add(alibi);

        authorRepository.save(alibi);
        bookRepository.save(design);
    }

}
