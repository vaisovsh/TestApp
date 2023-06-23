package uz.gita.exam2.ui.login;

import uz.gita.exam2.repository.UserRepository;

public class LoginPresenter implements LoginContract.Presenter{
    private LoginContract.View view;
    private UserRepository repository;
    private LoginContract.Model model;
    @Override
    public boolean checkUser(String login, String password) {
        return false;
    }

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        repository = UserRepository.getInstance();
        model = new LoginModel();
    }
}
