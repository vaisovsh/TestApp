package uz.gita.exam2.ui.book_list;

import uz.gita.exam2.model.UserData;

public class BookListModel implements BookListContract.Model{
    
    @Override
    public boolean haveBook(String key) {
        return false;
    }
}
