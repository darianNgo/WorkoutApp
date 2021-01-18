// Citation: https://github.com/stleary/JSON-java.git

package persistence;

import gui.exercises.ExerciseLabelAndImage;
import model.Favourites;
import model.workout.Categories;
import model.workout.Workout;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonRead {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonRead(String source) {
        this.source = source;
    }

    // EFFECTS: reads favourites from file and returns it;
    // throws IOException if an error occurs
    public Favourites read() throws IOException {
        String favouritesData = readFile(source);
        JSONObject jsonObject = new JSONObject(favouritesData);
        return parseFavourites(jsonObject);
    }

    public Favourites readGui() throws IOException {
        String favouritesData = readFile(source);
        JSONObject jsonObject = new JSONObject(favouritesData);
        return parseExercises(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: finds favourites from JSON object and returns it
    private Favourites parseFavourites(JSONObject favourites) {
        String name = favourites.getString("name");
        Favourites f = new Favourites(name);
        addWorkouts(f, favourites);
        return f;
    }

    private Favourites parseExercises(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Favourites f = new Favourites(name);
        addExercises(f, jsonObject);
        return f;
    }


//    // EFFECTS: finds favourites from JSON object and returns it
//    private Map parseGuiFavourites(JSONObject favourites) {
//        String name = favourites.getString("name");
//        Map<String, ImageIcon> f = new HashMap<String, ImageIcon>();
//        addGuiExercises(f, favourites);
//        return f;
//    }
//
//    // MODIFIES: favourites
//    // EFFECTS: finds Workouts from JSON object and adds them to Favourites
//    private void addGuiExercises(Map f, JSONObject jsonObject) {
//        JSONArray savedWorkouts = jsonObject.getJSONArray("Saved Workouts");
//        for (Object w : savedWorkouts) {
//            JSONObject nextWorkout = (JSONObject) w;
//            addGuiExercise(f, nextWorkout);
//        }
//    }
//
//    // MODIFIES: favourites
//    // EFFECTS: finds Workout from JSON object and adds it to Favourites
//    private void addGuiExercise(Map f, JSONObject workoutObject) {
//        for (Map.Entry<String, ImageIcon> entry : SavedWorkoutsGui.favourites.entrySet()) {
//            String key = entry.getKey();
//            ImageIcon imageIcon = entry.getValue();
//            f.put(key, imageIcon);
//        }
//    }

    // MODIFIES: favourites
    // EFFECTS: finds Workouts from JSON object and adds them to Favourites
    private void addWorkouts(Favourites f, JSONObject jsonObject) {
        JSONArray savedWorkouts = jsonObject.getJSONArray("My Favourite Workouts");
        for (Object w : savedWorkouts) {
            JSONObject nextWorkout = (JSONObject) w;
            addWorkout(f, nextWorkout);
        }
    }


    // MODIFIES: favourites
    // EFFECTS: finds Workout from JSON object and adds it to Favourites
    private void addWorkout(Favourites f, JSONObject workoutObject) {
        String name = workoutObject.getString("name");
        Categories category = Categories.valueOf(workoutObject.getString("category"));
        Workout workout = new Workout(name, category);
        f.addFavourites(workout);
    }


    // MODIFIES: favourites
    // EFFECTS: finds Workout from JSON object and adds it to Favourites
    private void addExercise(Favourites f, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String exerciseImage = jsonObject.getString("Icon");
        ExerciseLabelAndImage exercise = new ExerciseLabelAndImage(name, exerciseImage);
        f.addExercise(exercise);
    }

    // MODIFIES: favourites
    // EFFECTS: finds Workouts from JSON object and adds them to Favourites
    private void addExercises(Favourites f, JSONObject jsonObject) {
        JSONArray savedWorkouts = jsonObject.getJSONArray("My Favourite Exercises");
        for (Object w : savedWorkouts) {
            JSONObject nextExercise = (JSONObject) w;
            addExercise(f, nextExercise);
        }
    }

}
