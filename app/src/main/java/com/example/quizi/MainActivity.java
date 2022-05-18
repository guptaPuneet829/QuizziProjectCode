package com.example.quizi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String selectLevel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout level1 = findViewById(R.id.l1);
        final LinearLayout level2 = findViewById(R.id.l2);
        final LinearLayout level3 = findViewById(R.id.l3);
        final LinearLayout level4 = findViewById(R.id.l4);
        final LinearLayout level5 = findViewById(R.id.l5);
        final LinearLayout level6 = findViewById(R.id.l6);

        final Button startBtn = findViewById(R.id.startQuiz);

        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectLevel = "level1";

                level1.setBackgroundResource(R.drawable.round_back_white_stroke10);
                level2.setBackgroundResource(R.drawable.round_back_white10);
                level3.setBackgroundResource(R.drawable.round_back_white10);
                level4.setBackgroundResource(R.drawable.round_back_white10);
                level5.setBackgroundResource(R.drawable.round_back_white10);
                level6.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectLevel= "level2";

                level2.setBackgroundResource(R.drawable.round_back_white_stroke10);
                level1.setBackgroundResource(R.drawable.round_back_white10);
                level3.setBackgroundResource(R.drawable.round_back_white10);
                level4.setBackgroundResource(R.drawable.round_back_white10);
                level5.setBackgroundResource(R.drawable.round_back_white10);
                level6.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectLevel = "level3";

                level3.setBackgroundResource(R.drawable.round_back_white_stroke10);
                level2.setBackgroundResource(R.drawable.round_back_white10);
                level1.setBackgroundResource(R.drawable.round_back_white10);
                level4.setBackgroundResource(R.drawable.round_back_white10);
                level5.setBackgroundResource(R.drawable.round_back_white10);
                level6.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectLevel = "level4";

                level4.setBackgroundResource(R.drawable.round_back_white_stroke10);
                level2.setBackgroundResource(R.drawable.round_back_white10);
                level3.setBackgroundResource(R.drawable.round_back_white10);
                level1.setBackgroundResource(R.drawable.round_back_white10);
                level5.setBackgroundResource(R.drawable.round_back_white10);
                level6.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectLevel = "level5";

                level5.setBackgroundResource(R.drawable.round_back_white_stroke10);
                level2.setBackgroundResource(R.drawable.round_back_white10);
                level3.setBackgroundResource(R.drawable.round_back_white10);
                level4.setBackgroundResource(R.drawable.round_back_white10);
                level1.setBackgroundResource(R.drawable.round_back_white10);
                level6.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectLevel = "level6";

                level6.setBackgroundResource(R.drawable.round_back_white_stroke10);
                level2.setBackgroundResource(R.drawable.round_back_white10);
                level3.setBackgroundResource(R.drawable.round_back_white10);
                level4.setBackgroundResource(R.drawable.round_back_white10);
                level5.setBackgroundResource(R.drawable.round_back_white10);
                level1.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectLevel.isEmpty()){
                    Toast.makeText(MainActivity.this,"Select The Level First",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,QuizActivity.class);
                    intent.putExtra("selectedLevel",selectLevel);
                    startActivity(intent);
                }
            }
        });
    }
}