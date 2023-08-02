package org.pk.cas.wallpaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class WallpaperRecyclerViewAdapter extends RecyclerView.Adapter<WallpaperRecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<String> list;

    public WallpaperRecyclerViewAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wallpaper_item_recycler_view_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.AnimateWallpaper(holder.itemView);
        
        Glide.with(context)
                .load(list.get(position))
                .into(holder.imageView);


        holder.imageView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FullImageActivity.class);
            intent.putExtra("ShowFullImages",list.get(position));
            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_recycler_view_image);
        }

        private void AnimateWallpaper(View viewtoAnimate){
            Animation slide_in_left = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewtoAnimate.startAnimation(slide_in_left);
        }
    }
}
