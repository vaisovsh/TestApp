package uz.gita.exam2.ui.sign_up;

import uz.gita.exam2.model.UserData;
import uz.gita.exam2.repository.UserRepository;

public class SignUpModel implements SignUpActivityContract.Model{
    private UserRepository repository;

    public SignUpModel() {
        repository = UserRepository.getInstance();
    }

    @Override
    public void addUserToPref(String login, String password) {
        repository.saveUsers(login, password);
    }
}
