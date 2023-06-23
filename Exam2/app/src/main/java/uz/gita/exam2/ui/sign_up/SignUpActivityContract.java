package uz.gita.exam2.ui.sign_up;

public interface SignUpActivityContract {
    interface Model{
        void addUserToPref(String login, String password);
    }
    interface Presenter{
        void checkedUser(String pass1, String pass2, String login);
        void addUser(String login, String password);
    }
    interface View{
        void clickSave();
    }
}
