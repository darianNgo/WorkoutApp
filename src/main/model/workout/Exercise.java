package model.workout;

import model.workout.Categories;

public class Exercise {
    private final String name;
    private final int sets;
    private final int reps;
    private final Categories muscleGroup;

    public Exercise(String name, int sets, int reps, Categories muscleGroup) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.muscleGroup = muscleGroup;
    }

    public String getName() {
        return this.name;
    }

    public int getSets() {
        return this.sets;
    }

    public int getReps() {
        return this.reps;
    }

    public Categories getMuscleGroup() {
        return this.muscleGroup;
    }


}