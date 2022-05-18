package com.example.quizi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        final AppCompatButton startNewBtn = findViewById(R.id.newQuizBtn);
        final TextView correctAnswer = findViewById(R.id.correctAns);
        final TextView incorrectAnswer = findViewById(R.id.incorrectAns);

        final int getCorrectAns = getIntent().getIntExtra("Correct",0);
        final int getIncorrectAns = getIntent().getIntExtra("Incorrect",0);

        correctAnswer.setText(String.valueOf(getCorrectAns));
        incorrectAnswer.setText(String.valueOf(getIncorrectAns));

        startNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResult.this,MainActivity.class));
                finish();
            }
        });
    }

    public void onBackPressed(){
        startActivity(new Intent(QuizResult.this,MainActivity.class));
        finish();
    }
}