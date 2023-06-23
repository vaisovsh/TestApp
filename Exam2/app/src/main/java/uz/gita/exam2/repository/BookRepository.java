package uz.gita.exam2.repository;

import java.util.ArrayList;
import java.util.List;

import uz.gita.exam2.model.BookData;

public class BookRepository {
    List<BookData> books;
    private static BookRepository repository;

    private BookRepository() {
        books = new ArrayList<>();
    }

    public static BookRepository getInstance() {
        if (repository == null)
            repository = new BookRepository();
        return repository;
    }
}
