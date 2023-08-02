package org.pk.cas.wallpaper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.pk.cas.fragments.AnimalFragment;
import org.pk.cas.fragments.MultipleFragment;
import org.pk.cas.fragments.NaturalFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_Navigation);


        getSupportFragmentManager().beginTransaction().replace(R.id.container_Layout, new MultipleFragment()).commit();


        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int data = item.getItemId();
                switch (data) {
                    case R.id.multiple_fragment:
                        Toast.makeText(MainActivity.this, "Multiple Wallpaper", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_Layout, new MultipleFragment()).commit();
                        break;
                    case R.id.eagle_fragment:
                        Toast.makeText(MainActivity.this, "Animal Wallpaper", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_Layout, new AnimalFragment()).commit();
                        break;
                    case R.id.natural_fragment:
                        Toast.makeText(MainActivity.this, "Natural Wallpaper", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_Layout, new NaturalFragment()).commit();
                        break;
                }
                return true;
            }
        });

    }
}