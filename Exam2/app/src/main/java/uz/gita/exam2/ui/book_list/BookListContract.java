package uz.gita.exam2.ui.book_list;

public interface BookListContract {
    interface Model{
        boolean haveBook(String key);
    }
    interface Presenter{
        void loadBooks();
        void describeView();
    }
    interface View{
        void controlView();
    }
}
