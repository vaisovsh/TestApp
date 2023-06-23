package uz.gita.testappmy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.HashMap;

import uz.gita.testappmy.controller.AppController;

public class Result extends AppCompatActivity {


    private LinearLayout container;
    private AppController control;
    private AppCompatButton mainbtn;
    private AppCompatButton refreshbtn;
    private AppCompatTextView trueAns;
    private AppCompatTextView wrongAns;
    private AppCompatTextView skipAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        control = AppController.getInstance();
        loadView();


        refreshbtn.setOnClickListener(view -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            refresh();
            finish();
        });

        mainbtn.setOnClickListener(view -> {
            Intent intent = new Intent(this,Start.class);
                startActivity(intent);
                refresh();
        });

        trueAns.setText(String.valueOf(control.getCorrectCount()));
        wrongAns.setText(String.valueOf(control.getWrongCount()));
        skipAns.setText(String.valueOf(control.getSkipCount()));


        for (int i = 0; i < control.getMAX_COUNT(); i++) {

            View view = LayoutInflater.from(this).inflate(R.layout.itemman, null);


            AppCompatButton btnAns = view.findViewById(R.id.btnItem);

            btnAns.setText("Question" + (i+1));
            if (control.ans.get(i) != null) {
                if (Boolean.TRUE.equals(control.ans.get(i))) btnAns.setBackgroundResource(R.color.true_ans);
                else btnAns.setBackgroundResource(R.color.red);
            } else btnAns.setBackgroundResource(R.color.skip_color);

            container.addView(view);
        }
    }

    private void loadView() {

        mainbtn = findViewById(R.id.main);
        refreshbtn = findViewById(R.id.refresh);
        container = findViewById(R.id.container);
        trueAns = findViewById(R.id.correctAns);
        wrongAns = findViewById(R.id.wrongAns);
        skipAns = findViewById(R.id.skipAns);

    }
    private void refresh(){
        control.setCurrentPos(0);
        control.setCorrectCount(0);
        control.setWrongCount(0);
        control.ans = new HashMap<>();
    }

    @Override
    public void onBackPressed() {
        refresh();
        super.onBackPressed();
    }
}