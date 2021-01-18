package model.profile;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String name;
    private int age;
    private double weight;
    private double goalWeight;
    private int difficulty;
    private List<Profile> myProfile;

    public Profile(String name, int age, double weight, double goalWeight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goalWeight = goalWeight;
        myProfile = new ArrayList<>();
        addMyProfile();
    }

    public void addMyProfile() {
        myProfile.add(this);
    }

    //getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

//    public int getDifficulty() {
//        return difficulty;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // MODIFIES: this
    // EFFECTS: changes weight on profile
    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }

    // MODIFIES: this
    // EFFECTS: changes goal weight
    public void setGoalWeight(int newGoalWeight) {
        this.weight = newGoalWeight;
    }

//    @Override
//    public JSONObject toFav() {
//        JSONObject fav = new JSONObject();
//        fav.put("name: ", name);
//        fav.put("My Info: ", profileToJsonArray());
//        return fav;
//    }
//
//    private JSONArray profileToJsonArray() {
//        JSONArray savedProfile = new JSONArray();
//        for (Profile p : myProfile) {
//            savedProfile.put(p.toFav());
//        }
//        return savedProfile;
//    }
}
