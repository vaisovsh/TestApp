package uz.gita.testappmy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

public class Start extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        findViewById(R.id.btnRecord).setOnClickListener(v->{
            Intent intentm = new Intent(this,AboutActivity.class);
            startActivity(intentm);
        });
        findViewById(R.id.exitbtn).setOnClickListener(v-> finishAffinity());
        findViewById(R.id.btnstart).setOnClickListener(view -> {
            Intent intentm = new Intent(this,MainActivity.class);
            startActivity(intentm);
        });
    }


}