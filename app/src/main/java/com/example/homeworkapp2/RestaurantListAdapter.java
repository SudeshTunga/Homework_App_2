package com.example.homeworkapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {

    //Created Restaurant linked list just like in main activity in order to store all of the restaurant objects.
    private final LinkedList<Restaurant> rList;
    //inflaterr to inflate all objects
    private LayoutInflater mInflater;
    //setting global onrestaurant listenrer in order to use this interface to allow for clicks
    //clicks send you to detail activity with appropriate restaurant details
    private OnRestaurantListener mOnRestaurantListener;

//making sure that the viewholder implements an onclick listerner in order to allow for the clicks
   static class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView Name;
        public final TextView Location;
        public final TextView Cuisine;
        public final TextView Rating;
        public final ImageView DiningImage;
        final RestaurantListAdapter mAdapter;
        OnRestaurantListener onRestaurantListener;

//Contains adapter and onRestaurant listner interface to allow for clicks
        public RestaurantViewHolder(@NonNull View itemView, RestaurantListAdapter mAdapter, OnRestaurantListener onRestaurantListener) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            Location = itemView.findViewById(R.id.Location);
            Cuisine = itemView.findViewById(R.id.Cuisine);
            Rating = itemView.findViewById(R.id.Rating);
            DiningImage = (ImageView) itemView.findViewById(R.id.DiningImage);
            this.onRestaurantListener = onRestaurantListener;

            this.mAdapter = mAdapter;
            //setting click to be used
            itemView.setOnClickListener(this);

        }

        //method for clicks- getting the adapter position to be passed onto the main activity with the onrestaurantlistenr.
        //Can then send intent of name using a method to convert position to name.
        //this can be used to open the appropriate page in detail activity with the right restaurant details
       @Override
       public void onClick(View v) {

           int position = getAdapterPosition();
            onRestaurantListener.onRestaurantClick(position);
       }
   }
//the interface itself which implements my clicking function, accounting for a position
    public interface OnRestaurantListener {

        void onRestaurantClick(int position);
    }
//contructor where I set the onRestaurant listener to listen for clicks with each object
    public RestaurantListAdapter(Context context, LinkedList<Restaurant> rList, OnRestaurantListener onRestaurantListener) {

        mInflater = LayoutInflater.from(context);
        this.rList = rList;
        this.mOnRestaurantListener = onRestaurantListener;
    }

    @NonNull
    @Override
    public RestaurantListAdapter.RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.dining_list,
                parent, false);

        return new RestaurantViewHolder(mItemView, this, mOnRestaurantListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantListAdapter.RestaurantViewHolder holder, int position) {

        Restaurant mCurrent = rList.get(position);
        holder.Name.setText(mCurrent.getName());
        holder.Rating.setText((double) mCurrent.getRating() + "");
        holder.Location.setText(mCurrent.getLocation());
        holder.Cuisine.setText(mCurrent.getLocation());
//Create a variable name with the restaurant name in it
//this allows me to check which restaurant is currently in the holder and subsequently set the appropriate image for it through using if statements.
        String name = mCurrent.getName();

        if(name.equals("Barzaari")) {

            holder.DiningImage.setImageResource(R.drawable.barzaari);
        }

        if(name.equals("Mia & Co.")) {

            holder.DiningImage.setImageResource(R.drawable.mia);
        }


        if(name.equals("Don Peppino’s")) {

            holder.DiningImage.setImageResource(R.drawable.don_peppinos);
        }

        if(name.equals("Open Circus")) {

            holder.DiningImage.setImageResource(R.drawable.open_circus);
        }

        if(name.equals("Espresso 96")) {

            holder.DiningImage.setImageResource(R.drawable.espresso_96);
        }

        if(name.equals("Annata")) {

            holder.DiningImage.setImageResource(R.drawable.annata);
        }


        if(name.equals("The Rook")) {

            holder.DiningImage.setImageResource(R.drawable.the_rook);
        }

        if(name.equals("Ippuku")) {

            holder.DiningImage.setImageResource(R.drawable.ippuku);
        }

        if(name.equals("Sugar Rae's")) {

            holder.DiningImage.setImageResource(R.drawable.sugar_raes);
        }

        if(name.equals("Kittyhawk")) {

            holder.DiningImage.setImageResource(R.drawable.kittyhawk);
        }


    }

    @Override
    public int getItemCount() {
        return rList.size();
    }
}
