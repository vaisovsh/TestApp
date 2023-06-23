package uz.gita.exam2.model;

import java.util.ArrayList;
import java.util.List;

public class BookData {
    private String bookName;
    private String authorName;
    private String description;
    private List<BookData>books;

    public BookData(String bookName, String authorName, String description) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        books = new ArrayList<>();
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public void addBook(BookData book){
        books.add(book);
    }
}
