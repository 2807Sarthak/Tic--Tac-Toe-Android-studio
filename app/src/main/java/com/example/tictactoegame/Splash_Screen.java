package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Splash_Screen extends AppCompatActivity {

    Handler hand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        Thread thread = new Thread(){
            public void run()
            {
                try {
                   sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(Splash_Screen.this,MainActivity.class);
                    startActivity(intent);
                      finish();
                }
            }
        };
        thread.start();
    }
}