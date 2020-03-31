package com.example.homeworkapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class DetailActivity extends AppCompatActivity {
//create all my variables for a restaurant
    private TextView Name;
    private TextView Rating;
    private TextView Cuisine;
    private TextView Location;
    private TextView AverageCost;
    private ImageView DiningImage;
    //creating a linked list to fill in with all my restaurants
    private final LinkedList<Restaurant> Restaurants = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//assigning all variables to my textviews.
        Name = findViewById(R.id.Name);
        Rating = findViewById(R.id.Rating);
        Cuisine = findViewById(R.id.Cuisine);
        Location = findViewById(R.id.Location);
        AverageCost = findViewById(R.id.AverageCost);
        DiningImage = (ImageView) findViewById(R.id.DiningImage);
//getting intent from main activity to get name.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //using the message (name) to get the appropriate restaurant object.
        final Restaurant restaurant = Restaurant.searchRestaurants(message);

        Log.d("detail activity", "restaurant  = " + restaurant);
//setting the restaurant object details to textviews using getters.
        Name.setText(restaurant.getName());
        Log.d("detail activity", "name  = " + restaurant.getName());
        Rating.setText(Double.toString(restaurant.getRating()));
        Log.d("detail activity", "rating  = " + Double.toString(restaurant.getRating()));

        Cuisine.setText(restaurant.getCuisine());

        Log.d("detail activity", "cuisine  = " + restaurant.getCuisine());

        AverageCost.setText(restaurant.getAverageCost());

        Log.d("detail activity", "average cost  = " + restaurant.getAverageCost());

        Log.d("detail activity", "Location  = " + restaurant.getLocation());

        Location.setText(restaurant.getLocation());
//Create a variable name with the restaurant name in it
//this allows me to check which restaurant was chosen and subsequently set the appropriate image for it through using if statements.

        String name = restaurant.getName();

        if(name.equals("Barzaari")) {

            DiningImage.setImageResource(R.drawable.barzaari);
        }

        if(name.equals("Mia & Co.")) {

            DiningImage.setImageResource(R.drawable.mia);
        }


        if(name.equals("Don Peppino’s")) {

            DiningImage.setImageResource(R.drawable.don_peppinos);
        }

        if(name.equals("Open Circus")) {

            DiningImage.setImageResource(R.drawable.open_circus);
        }

        if(name.equals("Espresso 96")) {

            DiningImage.setImageResource(R.drawable.espresso_96);
        }

        if(name.equals("Annata")) {

            DiningImage.setImageResource(R.drawable.annata);
        }


        if(name.equals("The Rook")) {

            DiningImage.setImageResource(R.drawable.the_rook);
        }

        if(name.equals("Ippuku")) {

            DiningImage.setImageResource(R.drawable.ippuku);
        }

        if(name.equals("Sugar Rae's")) {

            DiningImage.setImageResource(R.drawable.sugar_raes);
        }

        if(name.equals("Kittyhawk")) {

            DiningImage.setImageResource(R.drawable.kittyhawk);
        }












    }
}
