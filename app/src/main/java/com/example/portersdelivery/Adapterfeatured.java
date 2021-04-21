package com.example.portersdelivery;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class Adapterfeatured extends RecyclerView.Adapter<Adapterfeatured.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass> featuredLocations;
    final private ListItemClickListener mOnClickListener;


    public Adapterfeatured(ArrayList<FeaturedHelperClass> featuredLocations, ListItemClickListener listener) {
        this.featuredLocations = featuredLocations;
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view, mOnClickListener);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);

        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.desc.setText(featuredHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }


    public interface ListItemClickListener {
        void onfeaturedListClick(int clickedItemIndex);
    }



    public static class FeaturedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView title, desc;
        private ListItemClickListener mOnClickListener;

        public FeaturedViewHolder(@NonNull View itemView, ListItemClickListener mOnClickListener) {
            super(itemView);
            this.mOnClickListener = mOnClickListener;
            itemView.setOnClickListener(this);

            //Hooks
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featured_desc);

        }


        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onfeaturedListClick(clickedPosition);
        }
    }


}
