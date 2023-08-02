package org.pk.cas.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
TextView blink_text_View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        blink_text_View =findViewById(R.id.textView);

        /*Blink Animation for the News Image */
        Animation animation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.blink_animation);
        blink_text_View.startAnimation(animation);

        /*new Handler code mean Few time Splash this Screen and before
        * next Activity */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();
            }
        },4000);
    }
}