package com.example.homeworkapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.LinkedList;

//Main features of this app:
    //- Recycler view utilising an adapter in order to show 10 restaurants along with important details such as location, name, cuisine and rating.
    //- Images of restaurants displayed in both main and detail activity.
        //- Done through using if statements checking the restaurant name, and choosing the appropriate image to be displayed as a result.
        //- Done both in recycler view and detail activity.
    //- Detail activity opens when you click on the restaurant to display further details such as average cost.
        //- Utilises intent and Array List position (which is converted into a restaurant name) in order to get appropriate restaurant to be displayed in detail activity.
        //- Parts of the detail activity are set to the attributes of the appropriate restaurant.
        //- Utilising an interface and on click listener inside the adapter in order to switch pages
            //- Added an interface to the constructor of the adapter to allow for the click to register
            //- Interface instantiated from main activity with the interface referenced.
//- Main technical implementations include:
    //- intents
    //- recycler view and adapter
    //- resource image files
    //- Multiple different font implementations for better, cleaner and more consistent aesthetic.

//the interface in implemented by the main activity in order to use the interface in my adapter.
// This allows me to use the on click listener in the adapter in order to switch to the detail activity.
public class MainActivity extends AppCompatActivity implements RestaurantListAdapter.OnRestaurantListener {
    public static final String EXTRA_MESSAGE = "com.example.cryptobag.MESSAGE";
    private final LinkedList<Restaurant> rList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private RestaurantListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinkedList<Restaurant> myrestaurants = Restaurant.CreateRestaurants(rList);


        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);

        // Connect the adapter with the RecyclerView and send all information about clicks to the adapter.
        // Allows for communication between adapter and recylerrview in terrms of clicks.
        mAdapter = new RestaurantListAdapter(this, rList, this);
        Log.d("main activity", "listenerset");

        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);

        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));





    }
//Here is the click method which uses the position, converts it to the restaurant name and then sends an intent to the detail activity to switch to the appropriate page.
    //method run from adapter whenever object is clicked.
    @Override
    public void onRestaurantClick(int position) {

        Log.d("main activity", "I got clicked!");
        Intent intent = new Intent(this, DetailActivity.class);
        String message = getName(position);
        Log.d("main activity", "Message:" + message);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    public String getName (int position) {

        //this method allows me to get the restaurant names based on the position of a user's cursor.
        //this allows me to pass an intent to Detail Activity in order to fill in it's details with the clicked restaurant object.
        String name = "";

        if (position == 0) {

            name = "Barzaari";

        }

        else if (position == 1) {

            name = "Mia & Co.";
        }

        else if (position == 2) {

            name = "Don Peppino’s";
        }

        else if (position == 3) {

            name = "Open Circus";
        }

        else if (position == 4) {

            name = "Espresso 96";
        }

        else if (position == 5) {
            name = "Annata";

        }

        else if (position == 6) {

            name = "The Rook";
        }

        else if (position == 7) {
            name = "Ippuku";

        }

        else if (position == 8) {

            name = "Sugar Rae's";
        }

        else if (position == 9) {

            name = "Kittyhawk";
        }

        return name;

    }



}
