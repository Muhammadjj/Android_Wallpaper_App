package org.pk.cas.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class FullImageActivity extends AppCompatActivity {
    ImageView imageView;
    AppCompatButton apply_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage);

        apply_btn = findViewById(R.id.apply_Wallpaper_Btn);
        imageView = findViewById(R.id.full_screen_images);

        /*Click image and show the big images set of background Wallpaper*/
        Glide.with(this).load(getIntent().getStringExtra("ShowFullImages")).into(imageView);


        /*Click apply_btn set the Background image */
        apply_btn.setOnClickListener(v -> {
            Toast.makeText(this, "Apply This Background!", Toast.LENGTH_SHORT).show();
            Bitmap bitmap =((BitmapDrawable)imageView.getDrawable()).getBitmap();
            WallpaperManager manager =WallpaperManager.getInstance(this);

            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error :"+e.getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
    }
}