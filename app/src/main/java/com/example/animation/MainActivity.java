package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    imageView = (ImageView) findViewById(R.id.image);
                    animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideinup);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }finally {
                    imageView.startAnimation(animation);
                }
            }
        };
        thread.start();
        Thread thread1=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slideinup,R.anim.slideoutup);
                }
            }
        };
        thread1.start();
    }
}