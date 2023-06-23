package uz.gita.exam2.ui.sign_up;

import android.content.Context;
import android.widget.Toast;

public class SignUpPresenter implements SignUpActivityContract.Presenter{
    SignUpActivityContract.Model model;
    SignUpActivityContract.View view;

    public SignUpPresenter(SignUpActivityContract.View view) {
        this.view = view;
        model = new SignUpModel();
    }


    @Override
    public void checkedUser(String pass1, String pass2, String login) {
        if (pass1.equals(pass2)) {
            model.addUserToPref(login, pass1);
            Toast.makeText((Context) view, "Togri", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void addUser(String login, String password) {
        model.addUserToPref(login, password);
    }
}
