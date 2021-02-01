package com.example.smartbin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splashScreen extends AppCompatActivity {

    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Animation slideLeft = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_left);
        Animation slideRigt = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_right);
        ImageView icon = findViewById(R.id.icon);
        TextView name = findViewById(R.id.textView);

        icon.setAnimation(slideLeft);
        name.setAnimation(slideRigt);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser!=null){
            new Handler().postDelayed(new  Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(splashScreen.this, MainActivity.class));
                    finish();
                }
            }, 1500);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(splashScreen.this, login.class));
                    finish();
                }
            }, 1500);
        }

    }
}