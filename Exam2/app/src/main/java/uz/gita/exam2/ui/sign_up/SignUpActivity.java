package uz.gita.exam2.ui.sign_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import uz.gita.exam2.R;
import uz.gita.exam2.ui.book_list.BoolList_activity;

public class SignUpActivity extends AppCompatActivity implements SignUpActivityContract.View {

    private SignUpActivityContract.Presenter presenter;
    private Button btnSubmit;
    EditText login;
    EditText password;
    EditText confirmPassword;
    String loginT, passwordT, confirmPasswordT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new SignUpPresenter(this);

        loadViews();
        clickSave();
    }

    void loadViews() {
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        btnSubmit = findViewById(R.id.btn_save);


        loginT = login.getText().toString();
        passwordT = password.getText().toString();
        confirmPasswordT = confirmPassword.getText().toString();
    }


    @Override
    public void clickSave() {
        btnSubmit.setOnClickListener(v -> {
            presenter.checkedUser(passwordT, confirmPasswordT, loginT);
            startActivity(new Intent(SignUpActivity.this, BoolList_activity.class));
        });
    }
}