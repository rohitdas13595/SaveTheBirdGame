package com.example.SaveTheBird;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity2 extends AppCompatActivity {

    private TextView textViewResultInfo,textViewMyScore,textViewHighestScore;
    private Button buttonAgain;
    private int score;

    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        textViewHighestScore=findViewById(R.id.textViewHighestScore);
        textViewMyScore=findViewById(R.id.textViewYourScore);
        textViewResultInfo=findViewById(R.id.textViewcongrats);
        buttonAgain=findViewById(R.id.buttonAgain);

        score= getIntent().getIntExtra("score",0);
        textViewMyScore.setText("Your Score: "+score);

        sharedPreferences=this.getSharedPreferences("score", Context.MODE_PRIVATE);
        int highestScore= sharedPreferences.getInt("highestScore",0);

        if(score >= 200){
            textViewResultInfo.setText("You won the Game");

            textViewHighestScore.setText("Highest Score : "+score);
            sharedPreferences.edit().putInt("highestScore",score).commit();

        }
        else if (score >= highestScore){
            textViewResultInfo.setText("Sorry, you lost the game");
            textViewHighestScore.setText("Highest Score : "+score);
            sharedPreferences.edit().putInt("highestScore :",score).commit();


        }
        else{
            textViewResultInfo.setText("Sorry, you lost the game");
            textViewHighestScore.setText("Highest Score :"+sharedPreferences.getInt("highestScore",0));
        }

        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ResultActivity2.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
    public void onBackPressed(){

        AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity2.this);
        builder.setTitle("Save The Bird ");
        builder.setMessage("Are you sure you want to quit the game?");
        builder.setCancelable(false);
        builder.setNegativeButton("Quit game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }
        });
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }
}