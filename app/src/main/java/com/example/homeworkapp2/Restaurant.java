package com.example.homeworkapp2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Restaurant {

    private String Name;
    private double Rating;
    private String Location;
    private String Cuisine;
    private String AverageCost;

    public Restaurant () {
    }

        public Restaurant(String Name, double Rating, String Location, String Cuisine, String AverageCost) {
            this.Name = Name;
            this.Rating = Rating;
            this.Location = Location;
            this.Cuisine = Cuisine;
            this.AverageCost = AverageCost;

    }
    //Created getters and setters for in order to get the attributes in my detail activity and adapter to set them to textviews.
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCuisine() {
        return Cuisine;
    }

    public void setCuisine(String cuisine) {
        Cuisine = cuisine;
    }

    public String getAverageCost() {
        return AverageCost;
    }

    public void setAverageCost(String averageCost) {
        AverageCost = averageCost;
    }

    public static ArrayList<Restaurant> getRestaurants() {
    //Creating the restaurant entries using an arraylist. All data is retrieved from:
    // zomato. 2020. Trending This Week. [online] Available at: <https://www.zomato.com/sydney/top-restaurants> [Accessed 25 March 2020].
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant("Barzaari", 3.9, "Marrickville", "Middle Eastern", "A$80 for two people (approx.) Without alcohol"));
        restaurants.add(new Restaurant("Mia & Co.", 3.6, "CBD", "Cafe Food", "A$20 for two people (approx.) Without alcohol"));
        restaurants.add(new Restaurant("Don Peppino’s", 3.7, "Paddington", "Italian", "A$25 for two people (approx.) Without alcohol"));
        restaurants.add(new Restaurant("Open Circus", 3.6, "Mosman", "Cafe Food", "A$45 for two people (approx.)"));
        restaurants.add(new Restaurant("Espresso 96", 3.9, "Concord", "Café", "A$35 for two people (approx.)"));
        restaurants.add(new Restaurant("Annata", 4.0, "Crows Nest", "Bar", "A$120 for two people (approx.) Without alcohol"));
        restaurants.add(new Restaurant("The Rook", 4.0, "CBD", "Bar", "A$80 for two people (approx.) with alcohol"));
        restaurants.add(new Restaurant("Ippuku", 3.7, "CBD", "Japanese", "A$40 for two people (approx.)"));
        restaurants.add(new Restaurant("Sugar Rae's", 3.7, "Sutherland", "Cafe Food", "A$25 for two people (approx.)"));
        restaurants.add(new Restaurant("Kittyhawk", 4.0, "CBD", "Bar Food", "A$60 for two people (approx.) with alcohol"));


        return restaurants;

    }

    public static LinkedList<Restaurant> CreateRestaurants (LinkedList<Restaurant> restaurants) {

        ArrayList<Restaurant> myRestaurant = getRestaurants();
        restaurants.addAll(myRestaurant);

        return restaurants;

    }

    public static Restaurant searchRestaurants(String name) {
        //creating a restaurant arraylist in order to access the names
        ArrayList<Restaurant> myRestaurants = getRestaurants();
        //instantiate another restaurant object in order to use later
        Restaurant myRestaurant = myRestaurants.get(0);


        //according to the name, the appropriate restaurant is fetched from the arraylist using the get command and the restaurant's index e.g. 0,1,2...

        if(name.equals("Mia & Co.")) {

            myRestaurant = myRestaurants.get(1);
        }


        if(name.equals("Don Peppino’s")) {

            myRestaurant = myRestaurants.get(2);
        }

        if(name.equals("Open Circus")) {

            myRestaurant = myRestaurants.get(3);
        }

        if(name.equals("Espresso 96")) {

            myRestaurant = myRestaurants.get(4);
        }

        if(name.equals("Annata")) {

            myRestaurant = myRestaurants.get(5);
        }


        if(name.equals("The Rook")) {

            myRestaurant = myRestaurants.get(6);
        }

        if(name.equals("Ippuku")) {

            myRestaurant = myRestaurants.get(7);
        }

        if(name.equals("Sugar Rae's")) {

            myRestaurant = myRestaurants.get(8);
        }

        if(name.equals("Kittyhawk")) {

            myRestaurant = myRestaurants.get(9);
        }

        return myRestaurant;
    }

    public String toString() {
        return  Name;
    }
}
