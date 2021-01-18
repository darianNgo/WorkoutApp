// Citation: https://github.com/stleary/JSON-java.git

package model.workout;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// A workout, its name, and the category of muscle group
public class Workout implements Writable {
    private List<DurationExercise> warmups;
    private final List<Exercise> userExercises;
    private final List<Exercise> chestExercises;
    private final List<Exercise> shoulderExercises;
    private final List<Exercise> armExercises;
    private final List<Exercise> backExercises;
    private final List<Exercise> abdominalExercises;
    private final List<Exercise> legExercises;
    private final List<Exercise> enduranceExercises;
    private final List<DurationExercise> recoveryExercises;
    private final String workoutName;
    private Categories category;

    // Effects: makes a new workout, its name, and category
    public Workout(String workoutName, Categories category) {
        this.workoutName = workoutName;
        this.category = category;
        chestExercises = new ArrayList<>();
        shoulderExercises = new ArrayList<>();
        armExercises = new ArrayList<>();
        backExercises = new ArrayList<>();
        abdominalExercises = new ArrayList<>();
        legExercises = new ArrayList<>();
        enduranceExercises = new ArrayList<Exercise>();
        recoveryExercises = new ArrayList<>();
        userExercises = new ArrayList<>();
    }

    public String getName() {
        return workoutName;
    }

    public Categories getCategory() {
        return category;
    }

    @Override
    public JSONObject toFav() {
        JSONObject fav = new JSONObject();
        fav.put("name", workoutName);
        fav.put("category", category);
        return fav;
    }

    //getters
    public List<DurationExercise> getWarmups() {
        return warmups;
    }

    public List<Exercise> getUserExercises() {
        return userExercises;
    }

    public List<Exercise> getChestExercises() {
        return chestExercises;
    }

    public List<Exercise> getShoulderExercises() {
        return shoulderExercises;
    }

    public List<Exercise> getArmExercises() {
        return armExercises;
    }

    public List<Exercise> getBackExercises() {
        return backExercises;
    }

    public List<Exercise> getAbdominalExercises() {
        return abdominalExercises;
    }

    public List<Exercise> getLegExercises() {
        return legExercises;
    }

    public List<Exercise> getEnduranceExercises() {
        return enduranceExercises;
    }

    public List<DurationExercise> getRecoveryExercises() {
        return recoveryExercises;
    }

    // adders and removers

    public void addUserExercise(Exercise userExercise) {
        userExercises.add(userExercise);
    }

    public void removeUserExercise(Exercise userExercise) {
        userExercises.remove(userExercise);
    }

    public void addChestExercise(Exercise chestExercise) {
        chestExercises.add(chestExercise);
    }

    public void removeChestExercise(Exercise chestExercise) {
        chestExercises.remove(chestExercise);
    }

    public void addShoulderExercise(Exercise shoulderExercise) {
        shoulderExercises.add(shoulderExercise);
    }

    public void removeShoulderExercise(Exercise shoulderExercise) {
        shoulderExercises.remove(shoulderExercise);
    }

    public void addArmExercise(Exercise armExercise) {
        armExercises.add(armExercise);
    }

    public void removeArmExercise(Exercise armExercise) {
        armExercises.remove(armExercise);
    }

    public void addBackExercise(Exercise backExercise) {
        backExercises.add(backExercise);
    }

    public void removeBackExercise(Exercise backExercise) {
        backExercises.remove(backExercise);
    }

    public void addAbExercise(Exercise abExercise) {
        abdominalExercises.add(abExercise);
    }

    public void removeAbExercise(Exercise abExercise) {
        abdominalExercises.remove(abExercise);
    }

    public void addLegExercise(Exercise legExercise) {
        legExercises.add(legExercise);
    }

    public void removeLegExercise(Exercise legExercise) {
        legExercises.remove(legExercise);
    }

    public void addEnduranceExercise(Exercise enduranceExercise) {
        enduranceExercises.add(enduranceExercise);
    }

    public void removeEnduranceExercise(DurationExercise enduranceExercise) {
        enduranceExercises.remove(enduranceExercise);
    }


}
