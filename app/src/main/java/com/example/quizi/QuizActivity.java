package com.example.quizi;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView questions;
    private TextView question;

    private AppCompatButton option1,option2,option3,option4;

    private AppCompatButton nextBtn;

    private Timer quizTimer;

    private int currentPositionQuestion = 0;
    private String selectedOptionByUser = "";

    private int minutes = 5;
    private int seconds = 0;

    private List<quizzQuestions> questionslists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView backBtn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectLevelNumber = findViewById(R.id.levelNumber);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextBtn = findViewById(R.id.nextBtn);

        final String getSelectedLevelNumber = getIntent().getStringExtra("selectedLevel");

        selectLevelNumber.setText(getSelectedLevelNumber);

        questionslists = questionBank.getQuestions(getSelectedLevelNumber);


        startTimer(timer);

        questions.setText((currentPositionQuestion+1) + "/"+questionslists.size());
        question.setText(questionslists.get(0).getQuestion());
        option1.setText(questionslists.get(0).getOption1());
        option2.setText(questionslists.get(0).getOption2());
        option3.setText(questionslists.get(0).getOption3());
        option4.setText(questionslists.get(0).getOption4());



        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();

                    option1.setBackgroundResource(R.drawable.round_back_red10);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionslists.get(currentPositionQuestion).setUserSelectAns(selectedOptionByUser);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option2.getText().toString();

                    option2.setBackgroundResource(R.drawable.round_back_red10);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionslists.get(currentPositionQuestion).setUserSelectAns(selectedOptionByUser);
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option3.getText().toString();

                    option3.setBackgroundResource(R.drawable.round_back_red10);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionslists.get(currentPositionQuestion).setUserSelectAns(selectedOptionByUser);
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option4.getText().toString();

                    option4.setBackgroundResource(R.drawable.round_back_red10);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionslists.get(currentPositionQuestion).setUserSelectAns(selectedOptionByUser);
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()){
                    Toast.makeText(QuizActivity.this,"Please Select an Option",Toast.LENGTH_SHORT).show();
                }
                else{
                    changeNextQuestion();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    private void changeNextQuestion(){
        currentPositionQuestion++;
        if((currentPositionQuestion+1) == questionslists.size()){
            nextBtn.setText("Submit Quiz");
        }

        if((currentPositionQuestion) < questionslists.size()){
            selectedOptionByUser = "";

            option1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            questions.setText((currentPositionQuestion+1) + "/" +questionslists.size());
            question.setText(questionslists.get(currentPositionQuestion).getQuestion());
            option1.setText(questionslists.get(currentPositionQuestion).getOption1());
            option2.setText(questionslists.get(currentPositionQuestion).getOption2());
            option3.setText(questionslists.get(currentPositionQuestion).getOption3());
            option4.setText(questionslists.get(currentPositionQuestion).getOption4());

        }
        else{
            Intent intent = new Intent(QuizActivity.this,QuizResult.class);
            intent.putExtra("Correct",getCorrectAns());
            intent.putExtra("Incorrect",getIncorrectAns());
            startActivity(intent);
            finish();
        }
    }
    private void startTimer(TextView timerTextView){
        quizTimer = new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if(seconds == 0 && minutes >= 1){
                    minutes--;
                    seconds = 59;
                }

                else if(seconds == 0 && minutes == 0){
                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(QuizActivity.this,"Time Over",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuizActivity.this,QuizResult.class);
                    intent.putExtra("Correct",getCorrectAns());
                    intent.putExtra("Incorrect",getIncorrectAns());
                    startActivity(intent);
                    finish();
                }

                else{
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMin = String.valueOf(minutes);
                        String finalSec = String.valueOf(seconds);

                        if(finalMin.length() == 1){
                            finalMin = "0" + finalMin;
                        }
                        if(finalSec.length() == 1){
                            finalSec = "0" + finalSec;
                        }

                        timerTextView.setText(finalMin + ":" + finalSec);
                    }
                });
            }
        },1000,1000);
    }

    private int getCorrectAns(){
        int correctAns = 0;
        for(int i=0;i<questionslists.size();i++){
            final String getUserSelectAns =  questionslists.get(i).getUserSelectAns();
            final String getAns = questionslists.get(i).getAns();

            if(getUserSelectAns.equals((getAns))){
                correctAns++;
            }
        }
        return correctAns;
    }

    private int getIncorrectAns(){
        int correctAns = 0;
        for(int i=0;i<questionslists.size();i++){
            final String getUserSelectAns =  questionslists.get(i).getUserSelectAns();
            final String getAns = questionslists.get(i).getAns();

            if(!getUserSelectAns.equals((getAns))){
                correctAns++;
            }
        }
        return correctAns;
    }

    public void onBackPressed(){
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this,MainActivity.class));
        finish();
    }

    private void revealAnswer(){
        final String getAns = questionslists.get(currentPositionQuestion).getAns();

        if(option1.getText().toString().equals((getAns))){
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }
        else if(option2.getText().toString().equals((getAns))){
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        }
        else if(option3.getText().toString().equals((getAns))){
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        }
        else if(option4.getText().toString().equals((getAns))) {
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }
    }
}