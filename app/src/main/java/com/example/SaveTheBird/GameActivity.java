package com.example.SaveTheBird;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private ImageView bird,enemy1,enemy2,enemy3,coin1,coin2,right1,right2,right3;
    private TextView textViewScore,textViewStartInfo;
    private ConstraintLayout constraintLayout;

    private boolean touchControl=false;
    private boolean beginControl=false;

    private Runnable runnable;
    private Handler handler;
    private Runnable birdRunnable;
    private Handler birdHandler;



    //pos of the bird
    int birdX,enemy1x,enemy2x,enemy3x,coin1x,coin2x;
    int birdY,enemy1y,enemy2y,enemy3y,coin1y,coin2y;

    // screen width,h
    int screenWidth;
    int screenHeight;
    // remaining right
    int right=3;
    //
    int score= 0;




    @Override
    protected void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        bird =findViewById(R.id.imgvbird);
        enemy1=findViewById(R.id.imageViewEnemy1);
        enemy2=findViewById(R.id.imageViewEnemy2);
        enemy3=findViewById(R.id.imageViewEnemy3);
        coin1=findViewById(R.id.imageViewCoin);
        coin2=findViewById(R.id.imageViewCoin2);
        right1=findViewById(R.id.rightn1);
        right2=findViewById(R.id.rightn2);
        right3=findViewById(R.id.rightn3);
        textViewScore=findViewById(R.id.textViewScore);
        textViewStartInfo=findViewById(R.id.textViewStartinfo);
        constraintLayout=findViewById(R.id.constriantlayout);

        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                textViewStartInfo.setVisibility(View.INVISIBLE);


                if(! beginControl) {
                    beginControl=true;

                    screenWidth=(int) constraintLayout.getWidth();
                    screenHeight=(int) constraintLayout.getHeight();

                    birdX = (int) bird.getX();
                    birdY = (int) bird.getY();


                    handler= new Handler();
                    runnable= new Runnable() {
                        @Override
                        public void run() {
                            moveToBird();
                            enemyControl();
                            collisionControl();

                        }
                    };
                    handler.post(runnable);
                }

                else {
                    if(event.getAction() == MotionEvent.ACTION_DOWN)
                    {
                        touchControl=true;

                    }
                    if(event.getAction() == MotionEvent.ACTION_UP)
                    {
                        touchControl=false;
                    }

                }

                return true;
            }
        });




    }

    public void moveToBird(){
        if(touchControl){

            birdY = birdY -(screenHeight/50);
            if(score >=50 && score <100){
                birdY = birdY -(screenHeight/60);
            }
            if(score >=100 && score <150){
                birdY = birdY -(screenHeight/70);
            }
            if(score >=150 ){
                birdY = birdY -(screenHeight/80);
            }
        }
        else{
            birdY = birdY +(screenHeight/50);
        }
        if(birdY <=0){
            birdY =0;
        }
        if(birdY >= (screenHeight-bird.getHeight())){
            birdY =(screenHeight - bird.getHeight());
        }
        bird.setY(birdY);
    }
    public void enemyControl(){

        enemy1.setVisibility(View.VISIBLE);
        enemy2.setVisibility(View.VISIBLE);
        enemy3.setVisibility(View.VISIBLE);
        coin1.setVisibility(View.VISIBLE);
        coin2.setVisibility(View.VISIBLE);
        //enemy1

        enemy1x = enemy1x-(screenWidth /150);
        if(score >=50 && score <100){
            enemy1x = enemy1x-(screenWidth /145);
        }
        if(score >=100 && score <150){
            enemy1x = enemy1x-(screenWidth /140);
        }
        if(score >=150 ){
            enemy1x = enemy1x-(screenWidth /135);
        }

        if(enemy1x <0){
            enemy1x=screenWidth +200;
            enemy1y= (int) Math.floor(Math.random()* screenHeight);
            if(enemy1y <=0){
                enemy1y=0;
            }
            if(enemy1y >= (screenHeight-enemy1.getHeight())){
                enemy1y=(screenHeight - enemy1.getHeight());
            }
        }
        enemy1.setX(enemy1x);
        enemy1.setY(enemy1y);
        //enemy2
        enemy2x = enemy2x-(screenWidth /140);


        if(score >=50 && score <100){
            enemy2x = enemy2x-(screenWidth /135);
        }
        if(score >=100 && score <150){
            enemy2x = enemy2x-(screenWidth /130);
        }
        if(score >=150 ){
            enemy2x = enemy2x-(screenWidth /125);
        }

        if(enemy2x <0){
            enemy2x=screenWidth +200;
            enemy2y= (int) Math.floor(Math.random()* screenHeight);
            if(enemy2y <=0){
                enemy2y=0;
            }
            if(enemy2y >= (screenHeight-enemy2.getHeight())){
                enemy2y=(screenHeight - enemy2.getHeight());
            }
        }
        enemy2.setX(enemy2x);
        enemy2.setY(enemy2y);
        //enemy3
        enemy3x = enemy3x-(screenWidth /130);

        if(score >=50 && score <100){
            enemy3x = enemy3x-(screenWidth /125);
        }
        if(score >=100 && score <150){
            enemy3x = enemy3x-(screenWidth /120);
        }
        if(score >=150 ){
            enemy3x = enemy3x-(screenWidth /115);
        }

        if(enemy3x <0){
            enemy3x=screenWidth +200;
            enemy3y= (int) Math.floor(Math.random()* screenHeight);
            if(enemy3y <=0){
                enemy3y=0;
            }
            if(enemy3y >= (screenHeight-enemy3.getHeight())){
                enemy3y=(screenHeight - enemy3.getHeight());
            }
        }
        enemy3.setX(enemy3x);
        enemy3.setY(enemy3y);
        //coin1
        coin1x = coin1x-(screenWidth /100);

        if(coin1x <0){
            coin1x=screenWidth +200;
            coin1y= (int) Math.floor(Math.random()* screenHeight);
            if(coin1y <=0){
                coin1y=0;
            }
            if(coin1y >= (screenHeight-coin1.getHeight())){
                coin1y=(screenHeight - coin1.getHeight());
            }
        }
        coin1.setX(coin1x);
        coin1.setY(coin1y);
        //coin2
        coin2x = coin2x-(screenWidth /90);

        if(coin2x <0){
            coin2x=screenWidth +200;
            coin2y= (int) Math.floor(Math.random()* screenHeight);
            if(coin2y <=0){
                coin2y=0;
            }
            if(coin2y >= (screenHeight-coin2.getHeight())){
                coin2y=(screenHeight - coin2.getHeight());
            }
        }
        coin2.setX(coin2x);
        coin2.setY(coin2y);





    }
    public void collisionControl(){
        int centerEnemy1x=enemy1x+enemy1.getWidth()/2;
        int centerEnemy1y=enemy1y+enemy1.getHeight()/2;
        if( centerEnemy1x >= birdX
                && centerEnemy1x <= (birdX +bird.getWidth())
                && centerEnemy1y>= birdY
                && centerEnemy1y <= (birdY +bird.getHeight())
        )
        {
            enemy1x= screenWidth+200;
            right--;
        }
        //enemy2
        int centerEnemy2x=enemy2x+enemy2.getWidth()/2;
        int centerEnemy2y=enemy2y+enemy2.getHeight()/2;
        if( centerEnemy2x >= birdX
                && centerEnemy2x <= (birdX +bird.getWidth())
                && centerEnemy2y>= birdY
                && centerEnemy2y <= (birdY +bird.getHeight())
        )
        {
            enemy2x= screenWidth+200;
            right--;
        }
        //enemy3
        int centerEnemy3x=enemy3x+enemy3.getWidth()/2;
        int centerEnemy3y=enemy3y+enemy3.getHeight()/2;
        if( centerEnemy3x >= birdX
                && centerEnemy3x <= (birdX +bird.getWidth())
                && centerEnemy3y>= birdY
                && centerEnemy3y <= (birdY +bird.getHeight())
        )
        {
            enemy3x= screenWidth+200;
            right--;
        }
        //coin
        int centerCoin1X=coin1x+coin1.getWidth()/2;
        int centerCoin1Y=coin1y+coin1.getHeight()/2;
        if( centerCoin1X >= birdX
                && centerCoin1X <= (birdX +bird.getWidth())
                && centerCoin1Y>= birdY
                && centerCoin1Y <= (birdY +bird.getHeight())
        )
        {
            coin1x= screenWidth+200;
            score+=10;
            textViewScore.setText(""+score);
        }
        //coin2
        int centerCoin2X=coin2x+coin2.getWidth()/2;
        int centerCoin2Y=coin2y+coin2.getHeight()/2;
        if( centerCoin2X >= birdX
                && centerCoin2X <= (birdX +bird.getWidth())
                && centerCoin2Y>= birdY
                && centerCoin2Y <= (birdY +bird.getHeight())
        )
        {
            coin2x= screenWidth+200;
            score+=10;
            textViewScore.setText(""+score);
        }
        if(right>0 && score < 200){
            if(right == 2){
                right1.setImageResource(R.drawable.grey_heart);
            }
            if(right == 1){
                right2.setImageResource(R.drawable.grey_heart);
            }
            handler.postDelayed(runnable,20);
        }
        else if(score>=200){
            handler.removeCallbacks(runnable);
            constraintLayout.setEnabled(false);
            //textViewStartInfo.setVisibility(View.VISIBLE);
            //textViewStartInfo.setText("Congratulations. You won the game.");
            enemy1.setVisibility(View.INVISIBLE);
            enemy2.setVisibility(View.INVISIBLE);
            enemy3.setVisibility(View.INVISIBLE);
            coin1.setVisibility(View.INVISIBLE);
            coin2.setVisibility(View.INVISIBLE);

            Intent intent= new Intent(GameActivity.this,ResultActivity2.class);
            intent.putExtra("score",score);
            startActivity(intent);
            finish();
            /*

            birdHandler=new Handler();

            birdRunnable= new Runnable() {
                @Override
                public void run() {
                    birdX =birdX + (screenWidth/200);
                    bird.setX(birdX);
                    bird.setY(screenHeight /2f);
                    if (birdX <= screenWidth){
                        birdHandler.postDelayed(birdRunnable,10);
                    }
                    else{
                        birdHandler.removeCallbacks(birdRunnable);
                        Intent intent= new Intent(GameActivity.this,ResultActivity2.class);
                        intent.putExtra("score",score);
                        startActivity(intent);
                        finish();
                    }

                }
            };

                */


        }
        else if(right == 0){
            handler.removeCallbacks(runnable);
            right3.setImageResource(R.drawable.grey_heart);
            Intent intent= new Intent(GameActivity.this,ResultActivity2.class);
            intent.putExtra("score",score);
            startActivity(intent);
            finish();
        }


    }
}