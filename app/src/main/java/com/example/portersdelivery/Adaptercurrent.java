package com.example.portersdelivery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class Adaptercurrent extends RecyclerView.Adapter<Adaptercurrent.MostViewedViewHolder> {

    ArrayList<MostViewedHelperClass> mostViewedLocations;
    final private ListItemClickListener cmOnClickListener;


    public Adaptercurrent(ArrayList<MostViewedHelperClass> mostViewedLocations, ListItemClickListener listener) {
        this.mostViewedLocations = mostViewedLocations;
        cmOnClickListener = listener;
    }

    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.current_item, parent, false);
        MostViewedViewHolder mostViewedViewHolder = new MostViewedViewHolder(view, cmOnClickListener);
        return mostViewedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {
        MostViewedHelperClass helperClass = mostViewedLocations.get(position);

        holder.imageView.setImageResource(helperClass.getImageView());
        holder.textView.setText(helperClass.getTextView());
        holder.textView2.setText(helperClass.getTextView2());
    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public interface ListItemClickListener {
        void oncurrentListClick(int currentclickedItemIndex);
    }


    public static class MostViewedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView, textView2;
        private ListItemClickListener cmOnClickListener;


        public MostViewedViewHolder(@NonNull View itemView, ListItemClickListener cmOnClickListener) {
            super(itemView);
            this.cmOnClickListener = cmOnClickListener;
            itemView.setOnClickListener(this);

            imageView = itemView.findViewById(R.id.mv_image);
            textView = itemView.findViewById(R.id.mv_title);
            textView2 = itemView.findViewById(R.id.mv_desc);

        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            cmOnClickListener.oncurrentListClick(clickedPosition);

        }
    }
}


