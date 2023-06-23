package uz.gita.exam2.ui.book_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import uz.gita.exam2.R;

public class BoolList_activity extends AppCompatActivity implements BookListContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bool_list);
    }

    @Override
    public void controlView() {

    }
}