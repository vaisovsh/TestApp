package uz.gita.exam2.ui.login;

import uz.gita.exam2.repository.UserRepository;

public class LoginModel implements LoginContract.Model{
    UserRepository repository;
    @Override
    public boolean hasUser(String login) {
        return repository.hasUser(login);
    }

    @Override
    public String getUserAnswer(String login) {
        return repository.getUSerPassword(login);
    }

    public LoginModel() {
        repository = UserRepository.getInstance();
    }
}
