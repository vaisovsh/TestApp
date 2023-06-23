package uz.gita.exam2.ui.login;

public interface LoginContract {
    interface Model{
        boolean hasUser(String login);
        String getUserAnswer(String login);

    }
    interface Presenter{
        boolean checkUser(String login, String password);
    }
    interface View{
        void load();
        void clickSubmit();
        void displayIfWrong();
        void clickCreateAccaunt();
    }
}
