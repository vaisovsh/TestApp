package uz.gita.puzzle15;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textScore;
    private Chronometer textTime;
    private Button[][] items;
    private List<Integer> numbers;
    private Coordinate emptySpace;
    private int score;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    MediaPlayer player;
    boolean isNottiming;
    TextView textWinScore;
    Intent intent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_any);
        loadView();
        loadData();
        dataToView();
    }

    private void loadView() {
        isNottiming = true;
        player = MediaPlayer.create(this, R.raw.musicmy);
        textWinScore = findViewById(R.id.win_score);
        textScore = findViewById(R.id.text_score);
        textTime = findViewById(R.id.time_view);
        findViewById(R.id.btn_finish).setOnClickListener(v -> finish());
        findViewById(R.id.btn_restart).setOnClickListener(v -> restart());
        final ViewGroup group = findViewById(R.id.containerRel);
        final int count = group.getChildCount();
        items = new Button[4][4];
        preferences = this.getSharedPreferences("puzzle", Context.MODE_PRIVATE);
//        preferences = getSharedPreferences("score",MODE_PRIVATE);
//        editor = preferences.edit();
        for (int i = 0; i < count; i++) {
            final View view = group.getChildAt(i);
            final Button button = (Button) view;
            final int y = i / 4;
            final int x = i % 4;
            button.setOnClickListener(v -> onItemClick(button, x, y));
            items[y][x] = button;
        }
        emptySpace = new Coordinate(3, 3);
    }

    private void loadData() {
        numbers = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            numbers.add(i);
        }
    }

    private void dataToView() {
        score = 0;

        textWinScore.setText(String.valueOf(preferences.getInt("score", 0)));
        textScore.setText(String.valueOf(score));

//        Collections.shuffle(numbers);
        items[emptySpace.y][emptySpace.x].setBackgroundResource(R.color.black);
        emptySpace.x = 3;
        emptySpace.y = 3;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                final int index = 4 * i + j;
                if (index < 15) {
                    int number = numbers.get(index);
                    items[i][j].setText(String.valueOf(number));
                } else {
                    items[i][j].setText("");
                    items[i][j].setBackgroundResource(R.color.color_item_empty);
                }
            }
        }
    }

    private void restart() {
        dataToView();
//        preferences.edit().putInt("score",0).apply();
        isNottiming = true;
        textScore.setText("0");
        textTime.stop();
        textTime.setText("00:00");
    }

    private void onItemClick(Button button, int x, int y) {


        final int dx = Math.abs(emptySpace.x - x);
        final int dy = Math.abs(emptySpace.y - y);
        if (dx + dy == 1) {
            textScore.setText(String.valueOf(++score));
            player.start();
            final String text = button.getText().toString();
            button.setText("");
            button.setBackgroundResource(R.color.color_item_empty);

            final Button temp = items[emptySpace.y][emptySpace.x];
            temp.setText(text);
            temp.setBackgroundResource(R.color.black);

            emptySpace.x = x;
            emptySpace.y = y;

            if (isNottiming) {
                textTime.setBase(SystemClock.elapsedRealtime());
                textTime.start();
                isNottiming = false;
            }

            if (isWin()) {
                Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show();
                isNottiming = false;
                preferences.edit().putInt("score", score).apply();
                textWinScore.setText(String.valueOf(preferences.getInt("score", 0)));
//                intent.putExtra("extraScore",preferences.getInt("score",-1));
                intent.putExtra("extraScore", score);
//                Bundle bundle = new Bundle();
//                bundle.putInt("extraScore",score);
//                intent.putExtras(bundle);
                intent = new Intent(MainActivity.this, MainActivity2.class);

                restart();
                startActivity(intent);
            }
        }
    }

    private boolean isWin() {
        if (emptySpace.x != 3 || emptySpace.y != 3) return false;
        for (int i = 0; i < 15; i++) {
            final int y = i / 4;
            final int x = i % 4;
            final String text = items[y][x].getText().toString();
            if (!text.equals(String.valueOf(i + 1))) return false;
        }

        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
