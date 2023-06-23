package uz.gita.puzzle15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intm = getIntent();
        int num=intm.getIntExtra("extraScore",-1);
        TextView textwinLast=findViewById(R.id.win_any);
        textwinLast.setText(String.valueOf(num));
    }
}