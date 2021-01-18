package model;

import gui.exercises.ExerciseLabelAndImage;
import gui.exercises.WorkoutsGui;
import model.workout.Workout;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Favourites implements Writable {
    private String name;
    private List<Workout> favourites;
    private List<ExerciseLabelAndImage> exercises;

    // makes new favourite list of workouts
    public Favourites(String name) {
        this.name = name;
        favourites = new ArrayList<>();
        exercises = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Workout> getFavourites() {
        return Collections.unmodifiableList(favourites);
    }

    public List<ExerciseLabelAndImage> getExercises() {
        return Collections.unmodifiableList(exercises);
    }

    public int getNumOfWorkouts() {
        return favourites.size();
    }

    // Modifies: this
    // Effects: adds a workout to the favourites list
    public void addExercise(ExerciseLabelAndImage exercise) {
        exercises.add(exercise);
    }

    // Modifies: this
    // Effects: adds a workout to the favourites list
    public void addFavourites(Workout workout) {
        favourites.add(workout);
    }

    public void removeFavourites(Workout workout) {
        favourites.remove(workout);
    }

    @Override
    public JSONObject toFav() {
        JSONObject fav = new JSONObject();
        fav.put("name", name);
        fav.put("My Favourite Workouts", workoutsToFav());
        return fav;
    }

    public JSONObject toFavExercise() {
        JSONObject fav = new JSONObject();
        fav.put("name", name);
        fav.put("My Favourite Exercises", toFavExercises());
        return fav;
    }


    private JSONArray toFavExercises() {
        JSONArray savedExercises = new JSONArray();

        for (ExerciseLabelAndImage e : WorkoutsGui.favourites.getExercises()) {
            savedExercises.put(e.toFav());
        }
        return savedExercises;
    }

    private JSONArray workoutsToFav() {
        JSONArray savedWorkouts = new JSONArray();

        for (Workout w : favourites) {
            savedWorkouts.put(w.toFav());
        }
        return savedWorkouts;
    }

}
