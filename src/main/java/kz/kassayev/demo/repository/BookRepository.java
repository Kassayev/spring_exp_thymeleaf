package kz.kassayev.demo.repository;

import kz.kassayev.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
