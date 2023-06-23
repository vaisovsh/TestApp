package uz.gita.exam2.ui.read_book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import uz.gita.exam2.R;

public class BookRead_activity extends AppCompatActivity implements ReadBookContract.View{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_read);
    }


}