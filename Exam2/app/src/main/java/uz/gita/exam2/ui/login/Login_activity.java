package uz.gita.exam2.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import uz.gita.exam2.R;
import uz.gita.exam2.repository.UserRepository;
import uz.gita.exam2.ui.book_list.BoolList_activity;
import uz.gita.exam2.ui.sign_up.SignUpActivity;

public class Login_activity extends AppCompatActivity implements LoginContract.View{

    LoginContract.Presenter presenter;
    TextView create;
    Button button;
    EditText editText;
    EditText editText2;

    String string1;
    String string2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        load();
        clickSubmit();
        clickCreateAccaunt();
    }
    @Override
    public void load() {
        presenter = new LoginPresenter(this);
        create = findViewById(R.id.create);
        button = findViewById(R.id.btn_submit);

        editText = findViewById(R.id.edit_1);
        editText2 = findViewById(R.id.edit_2);

        string1 = editText.getText().toString();
        string2 = editText2.getText().toString();
    }

    @Override
    public void clickSubmit() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenter.checkUser(string1, string2)){
                    startActivity(new Intent(Login_activity.this, BoolList_activity.class));
                }
                else {
                    displayIfWrong();
                }
            }
        });
    }

    @Override
    public void displayIfWrong() {
        Toast.makeText(this, "Password is incorrect", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void clickCreateAccaunt(){
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_activity.this, SignUpActivity.class));
            }
        });
    }
}