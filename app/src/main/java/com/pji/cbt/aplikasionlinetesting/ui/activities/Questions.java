package com.pji.cbt.aplikasionlinetesting.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import cbt.pji.cbt.aplikasionlinetesting.R;


public class Questions extends AppCompatActivity{
    private questionn quest = new questionn();
    private TextView soal;
    private TextView Sore;
    private RadioButton a;
    private RadioButton b;
    private  RadioButton c;
    private RadioButton d;

    private String answer;
    private int Score=0;
    private int qtNumber=0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

       // Sore =(TextView)findViewById(R.id.txtscore);
        soal =(TextView) findViewById(R.id.test);
        a=(RadioButton) findViewById(R.id.radioButton1);
        b=(RadioButton) findViewById(R.id.radioButton2);
        c=(RadioButton) findViewById(R.id.radioButton3);
        d=(RadioButton) findViewById(R.id.radioButton4);

        updateQuestion();
        updateScore(Score);
    }

    private void updateQuestion() {
        if (qtNumber < quest.getLength()) {
            soal.setText(quest.getQuestion(qtNumber));
            a.setText(quest.getChoice(qtNumber, 1));
            b.setText(quest.getChoice(qtNumber, 2));
            c.setText(quest.getChoice(qtNumber, 3));
            d.setText(quest.getChoice(qtNumber, 4));
            answer = quest.getCorrectAnswer(qtNumber);
            qtNumber++;
        } else {
            Toast.makeText(Questions.this, "it was the last question", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(Questions.this, HigestActivity.class);
//            intent.putExtra("score", Score);
//            startActivity(intent);
        }

    }
    private void updateScore(int point)
    {
        Sore.setText(""+Score+"/"+quest.getLength());
    }

    public void onClick(View view) {
        Button ans = (Button) view;
        if (ans.getText() == answer) {
            Score = Score + 1;
            Toast.makeText(Questions.this, "Correct", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(Questions.this, "wrong", Toast.LENGTH_SHORT).show();
            updateScore(Score);
            updateQuestion();
    }
}
