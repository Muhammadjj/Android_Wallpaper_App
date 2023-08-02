package org.pk.cas.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.pk.cas.wallpaper.R;
import org.pk.cas.wallpaper.WallpaperRecyclerViewAdapter;

import java.util.ArrayList;


public class MultipleFragment extends Fragment {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<String> data;
    WallpaperRecyclerViewAdapter adapter;
    DatabaseReference reference;

    public MultipleFragment() {

        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_multiple, container, false);

        recyclerView = view.findViewById(R.id.multiple_recycler_View);
        progressBar = view.findViewById(R.id.multiple_progress_Bar);

        reference = FirebaseDatabase.getInstance().getReference().child("WallpaperImages");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data = new ArrayList<>();
                for (DataSnapshot snap : snapshot.getChildren()) {
                    String value = snap.getValue().toString();
                    data.add(value);
                }
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                adapter = new WallpaperRecyclerViewAdapter(getContext(), data);
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error :" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}