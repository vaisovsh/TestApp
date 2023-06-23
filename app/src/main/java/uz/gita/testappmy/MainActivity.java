package uz.gita.testappmy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uz.gita.testappmy.controller.AppController;
import uz.gita.testappmy.model.TestData;

public class MainActivity extends AppCompatActivity {

    private List<RadioButton> radios;
    private CountDownTimer downTimer;
    private AppCompatTextView questionText;
    private AppCompatTextView currentPos;
    private AppController controller;
    private AppCompatButton btnSkip;
    private AppCompatButton btnnNext;
    Chronometer chronometr;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = AppController.getInstance();
        pref = this.getSharedPreferences("recordm", Context.MODE_PRIVATE);



         downTimer = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                chronometr.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                chronometr.setText("Finish!");
                Intent intent = new Intent(MainActivity.this,Result.class);
                startActivity(intent);
                finish();
//                refresh();
            }
        }.start();

        loadViews();
        describeTestData(controller.getNextTextData());

        btnSkip.setOnClickListener(view -> checkData());

        for (int i = 0; i < radios.size(); i++) {
            radios.get(i).setOnCheckedChangeListener((CompoundButton compoundButton, boolean b)-> {
                    if (!b) return;
                    clearOldSelect();
                    compoundButton.setChecked(true);
                    stateNextButton(true);}
            );
        }

    }

    private void loadViews() {


        questionText = findViewById(R.id.id_question);
        currentPos = findViewById(R.id.id_queationPos);

        radios = new ArrayList<>(4);
        radios.add(findViewById(R.id.radio1));
        radios.add(findViewById(R.id.radio2));
        radios.add(findViewById(R.id.radio3));
        radios.add(findViewById(R.id.radio4));

        chronometr = findViewById(R.id.chronometr);

//        variants = new ArrayList<>(4);
//        variants.add(findViewById(R.id.id_variant1));
//        variants.add(findViewById(R.id.id_variant2));
//        variants.add(findViewById(R.id.id_variant3));
//        variants.add(findViewById(R.id.id_variant4));

        btnSkip = findViewById(R.id.id_skip);
        btnnNext = findViewById(R.id.id_next);


    }

    private void clearOldSelect(){
        for (int i = 0; i < radios.size(); i++) {
            radios.get(i).setChecked(false);
        }
    }


    private void describeTestData(TestData data){
        currentPos.setText(controller.getCurrentPos()+"/"+controller.getMAX_COUNT());
        questionText.setText(data.getQuestion());
        radios.get(0).setText(data.getVariant1());
        radios.get(1).setText(data.getVariant2());
        radios.get(2).setText(data.getVariant3());
        radios.get(3).setText(data.getVariant4());
        clearOldSelect();
    }

    private void checkData(){
        if (controller.islastQuestion()){
            describeTestData(controller.getNextTextData());
            btnnNext.setEnabled(false);

            if (pref.getInt("max",0)<controller.getCorrectCount()){
                pref.edit().putInt("max",controller.getCorrectCount()).apply();
            }
        }else {
            downTimer.cancel();
            Intent intent = new Intent(this,Result.class);
            startActivity(intent);
            controller.setCurrentPos(0);
            finish();
        }
    }
    private void stateNextButton(boolean bool){
        btnnNext.setEnabled(bool);
        btnnNext.setOnClickListener(v->{
            controller.testCheck(getUserAnswer());
            checkData();
        });



    }
    private String getUserAnswer(){
        int pos = 0;
        for (int i = 0; i < radios.size(); i++) {
            if (radios.get(i).isChecked()){
                pos = i;
            }
        }

        return radios.get(pos).getText().toString();

    }
    private void refresh(){
        controller.setCurrentPos(0);
        controller.setCorrectCount(0);
        controller.setWrongCount(0);
        controller.ans = new HashMap<>();
    }

    @Override
    public void onBackPressed() {
        refresh();
        super.onBackPressed();
        downTimer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView txtRecord = findViewById(R.id.txtrecord);
        Log.d("TTT", "onResume:"+ pref.getInt("max",0));
        txtRecord.setText(String.valueOf(pref.getInt("max",0)));
    }
}