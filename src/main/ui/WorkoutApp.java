package ui;

import model.Favourites;
import model.nutrition.MacroNutrients;
import model.profile.Profile;
import model.workout.Categories;
import model.workout.DurationExercise;
import model.workout.Exercise;
import model.workout.Workout;
import persistence.JsonRead;
import persistence.JsonWrite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// Citation: https://github.com/stleary/JSON-java.git

public class WorkoutApp {
    private static final int CHEST_COMMAND = 1;
    private static final int SHOULDERS_COMMAND = 2;
    private static final int ARMS_COMMAND = 3;
    private static final int BACK_COMMAND = 4;
    private static final int ABDOMINAL_COMMAND = 5;
    private static final int LEGS_COMMAND = 6;
    private static final int ENDURANCE_COMMAND = 7;
    private static final String JSON_STORE = "./data/favourites.json";
    private static final String JSON_STORE_PROFILE = "./data/myProfile.json";
    private final JsonWrite jsonWriter;
    private final JsonRead jsonReader;
    Favourites favourites = new Favourites("My Favourite Workouts");
    Workout chestWorkout = new Workout("Chest", Categories.CHEST);
    Workout shoulderWorkout = new Workout("Shoulders", Categories.SHOULDERS);
    Workout armWorkout = new Workout("Arms", Categories.ARMS);
    Workout backWorkout = new Workout("Back", Categories.BACK);
    Workout abWorkout = new Workout("Abs", Categories.ABDOMINAL);
    Workout legWorkout = new Workout("Legs", Categories.LEGS);
    Workout enduranceWorkout = new Workout("Endurance", Categories.ENDURANCE);
    MacroNutrients myNutrients = new MacroNutrients(0, 0, 0);

    public WorkoutApp() {
        jsonReader = new JsonRead(JSON_STORE);
        jsonWriter = new JsonWrite(JSON_STORE);
        runApp();
    }

    public void runApp() {
        System.out.println("Welcome to FitnessBuddy");
        makeProfile();
        System.out.println("Let's get started!");
        commandOption();


    }

    // EFFECTS: makes new profile with users information
    public Profile makeProfile() {
        Scanner nameInput = new Scanner(System.in);
        System.out.println("Please Enter your Name: ");
        String userName = nameInput.next();

        Scanner ageInput = new Scanner(System.in);
        System.out.println("Please Enter your age: ");
        int userAge = ageInput.nextInt();

        Scanner weightInput = new Scanner(System.in);
        System.out.println("Please Enter your current Weight: ");
        double userWeight = weightInput.nextDouble();

        Scanner goalWeightInput = new Scanner(System.in);
        System.out.println("Please Enter your goal weight: ");
        double userGoalWeight = goalWeightInput.nextDouble();

        Profile user = new Profile(userName, userAge, userWeight, userGoalWeight);
        return user;
    }

    // Effects: constructs the main page for user, according to input it will direct user to destination

    public void commandOption() {
        printMainMenu();
        Scanner keyInput = new Scanner(System.in);
        int command = keyInput.nextInt();
        if (command == 1) {
            selectWorkout();
        } else if (command == 2) {
            calorieCounter();
        } else if (command == 3) {
            viewFavouritesList();
            commandOption();
        } else if (command == 4) {
            saveFavourites();
            commandOption();
        } else if (command == 5) {
            loadFavourites();
            commandOption();
        } else {
            System.out.println("Sorry the input you have given is invalid");
        }
    }

    private void printMainMenu() {
        System.out.println("\nselect the following option: ");
        System.out.println("\t1: workout!");
        System.out.println("\t2: calorie counter");
        System.out.println("\t3: favourites");
        System.out.println("\t4: Save Favourites");
        System.out.println("\t5: load Favourites");
    }


    // Effects: Displays favourite workouts
    public void viewFavouritesList() {
        List<Workout> favourite = favourites.getFavourites();
        System.out.println("\nMy Favourite Workouts");
        for (Workout w : favourite) {
            System.out.println("\t" + w.getName());
        }
    }

    // Effects: displays main menu of calorie counter and directs user to destination
    public void calorieCounter() {
        System.out.println("Welcome to Calorie Counter!");
        System.out.println("\t1: add");
        System.out.println("\t2: view");
        System.out.println("\t3: back");
        Scanner keyInput = new Scanner(System.in);
        int command = keyInput.nextInt();
        if (command == 1) {
            addMacros();
        } else if (command == 2) {
            viewMacros();
        } else if (command == 3) {
            commandOption();
        } else {
            System.out.println("Sorry the input you have given is invalid");
        }
    }

    //Effects: asks user on what MacroNutrient the user wants to keep track of
    public void addMacros() {
        System.out.println("What would you like to add?");
        System.out.println("\t1: protein");
        System.out.println("\t2: carbs");
        System.out.println("\t3: fats");
        System.out.println("\t4: back");
        Scanner keyInput = new Scanner(System.in);
        int k = keyInput.nextInt();
        if (k == 1) {
            addProtein();
        } else if (k == 2) {
            addCarbs();
        } else if (k == 3) {
            addFats();
        } else {
            calorieCounter();
        }
    }

    // Modifies: this
    //Effects adds int to protein in grams
    public void addProtein() {
        System.out.println("please enter grams");
        Scanner gramInput = new Scanner(System.in);
        double grams = gramInput.nextDouble();
        myNutrients.addProtein(grams);
        System.out.println("Success!");
        addMacros();
    }

    // Modifies: this
    //Effects adds int to carbs in grams
    public void addCarbs() {
        System.out.println("please enter grams");
        Scanner gramInput = new Scanner(System.in);
        double grams = gramInput.nextDouble();
        myNutrients.addCarbs(grams);
        System.out.println("Success!");
        addMacros();
    }

    // Modifies: this
    //Effects adds int to fats in grams
    public void addFats() {
        System.out.println("please enter grams");
        Scanner gramInput = new Scanner(System.in);
        double grams = gramInput.nextDouble();
        myNutrients.addFats(grams);
        System.out.println("Success!");
        addMacros();
    }

    public void viewMacros() {
        System.out.println("\nNutritional Summary:");
        System.out.println("\tProtein: " + (myNutrients.getProtein()));
        System.out.println("\t  Carbs: " + (myNutrients.getCarbohydrates()));
        System.out.println("\t   Fats: " + (myNutrients.getFats()));
        System.out.println("\tTotal Caloric Intake");
        System.out.println("\t  " + (myNutrients.getCalories()));
        System.out.println("press 1 to go back to calorie counter");
        Scanner input = new Scanner(System.in);
        int back = input.nextInt();
        if (back == 1) {
            calorieCounter();
        }
    }

    public void selectWorkout() {
        System.out.println("\nSelect one of the following options: ");
        System.out.println("\t1: chest");
        System.out.println("\t2: shoulders");
        System.out.println("\t3: arms");
        System.out.println("\t4: back");
        System.out.println("\t5: abdominal");
        System.out.println("\t6: legs");
        System.out.println("\t7: endurance");
        System.out.println("\t8: menu");
        Scanner selectedWorkout = new Scanner(System.in);
        int selected = selectedWorkout.nextInt();
        selectWorkoutInput(selected);
    }

    public void selectWorkoutInput(int selected) {
        if (selected == CHEST_COMMAND) {
            loadChestWorkouts();
        } else if (selected == SHOULDERS_COMMAND) {
            loadShoulderWorkouts();
        } else if (selected == ARMS_COMMAND) {
            loadArmWorkouts();
        } else if (selected == BACK_COMMAND) {
            loadBackWorkouts();
        } else if (selected == ABDOMINAL_COMMAND) {
            loadAbWorkouts();
        } else if (selected == LEGS_COMMAND) {
            loadLegWorkouts();
        } else if (selected == ENDURANCE_COMMAND) {
            loadEnduranceWorkouts();
        } else if (selected == 8) {
            commandOption();
        } else {
            System.out.println("None of the options above were selected. Please try again.");
        }
    }

    public void loadChestWorkouts() {
        chestWorkout.addChestExercise(skipRope);
        chestWorkout.addChestExercise(pushUp);
        chestWorkout.addChestExercise(inclinePushUp);
        chestWorkout.addChestExercise(widePushUp);
        chestWorkout.addChestExercise(trianglePushUp);
        chestWorkout.addChestExercise(stretch);
        printChestWorkout();
    }

    public void loadShoulderWorkouts() {
        shoulderWorkout.addShoulderExercise(jogging);
        shoulderWorkout.addShoulderExercise(dumbbellLateralRaise);
        shoulderWorkout.addShoulderExercise(reverseFly);
        shoulderWorkout.addShoulderExercise(militaryPress);
        shoulderWorkout.addShoulderExercise(yoga);
        printShoulderWorkout();
    }

    public void loadArmWorkouts() {
        armWorkout.addArmExercise(stairClimber);
        armWorkout.addArmExercise(curls);
        armWorkout.addArmExercise(trianglePushUp);
        armWorkout.addArmExercise(overheadTricep);
        armWorkout.addArmExercise(standingKickback);
        armWorkout.addArmExercise(hammerHeadCurls);
        armWorkout.addArmExercise(walking);
        printArmWorkout();
    }

    public void loadBackWorkouts() {
        backWorkout.addBackExercise(skipRope);
        backWorkout.addBackExercise(pullUps);
        backWorkout.addBackExercise(chinUps);
        backWorkout.addBackExercise(bandRow);
        backWorkout.addBackExercise(dumbbellRows);
        backWorkout.addBackExercise(stretch);
        printBackWorkout();
    }

    public void loadLegWorkouts() {
        legWorkout.addLegExercise(jogging);
        legWorkout.addLegExercise(highKnees);
        legWorkout.addLegExercise(squats);
        legWorkout.addLegExercise(jumpSquats);
        legWorkout.addLegExercise(pistolSquats);
        legWorkout.addLegExercise(dumbbellDeadLift);
        legWorkout.addLegExercise(stretch);
        printLegWorkout();
    }

    public void loadAbWorkouts() {
        abWorkout.addAbExercise(jogging);
        abWorkout.addAbExercise(sitUps);
        abWorkout.addAbExercise(flutterKicks);
        abWorkout.addAbExercise(legRaise);
        abWorkout.addAbExercise(twist);
        abWorkout.addAbExercise(yoga);
        printAbWorkout();
    }

    public void loadEnduranceWorkouts() {
        enduranceWorkout.addEnduranceExercise(highKnees);
        enduranceWorkout.addEnduranceExercise(running);
        enduranceWorkout.addEnduranceExercise(sprints);
        enduranceWorkout.addEnduranceExercise(stretch);
        enduranceWorkout.addEnduranceExercise(iceBath);
        printEnduranceWorkout();

    }

    public void printChestWorkout() {
        for (Exercise e : chestWorkout.getChestExercises()) {
            if (e.getMuscleGroup() == Categories.WARMUP) {
                System.out.println("Warm up with: " + e.getName());
            }
            if (e.getMuscleGroup() == Categories.CHEST) {
                System.out.println("\n" + e.getName());
            }
            if (e.getMuscleGroup() == Categories.RECOVERY) {
                System.out.println("\nCool down with: " + e.getName());
            }
        }
        System.out.println("Would you like to add this to your Favourites?");
        System.out.println("y - yes");
        System.out.println("n - no");
        Scanner yesNo = new Scanner(System.in);
        String input = yesNo.next();
        if (input.equals("y")) {
            favourites.addFavourites(chestWorkout);
            commandOption();
        } else {
            commandOption();
        }
    }


    public void printArmWorkout() {
        for (Exercise a : armWorkout.getArmExercises()) {
            if (a.getMuscleGroup() == Categories.WARMUP) {
                System.out.println("Warm up with: " + a.getName());
            }
            if (a.getMuscleGroup() == Categories.ARMS) {
                System.out.println("\n" + a.getName());
            }
            if (a.getMuscleGroup() == Categories.RECOVERY) {
                System.out.println("\nCool down with" + a.getName());
            }
        }
        System.out.println("Would you like to add this to your Favourites?");
        System.out.println("y - yes");
        System.out.println("n - no");
        Scanner yesNo = new Scanner(System.in);
        String input = yesNo.next();
        if (input.equals("y")) {
            favourites.addFavourites(armWorkout);
            commandOption();
        } else {
            commandOption();
        }
    }

    public void addToFavourites() {
        Scanner yesNo = new Scanner(System.in);
        String input = yesNo.next();
        if (input.equals("y")) {
            favourites.addFavourites(armWorkout);
        }
    }

    public void printShoulderWorkout() {
        for (Exercise s : shoulderWorkout.getShoulderExercises()) {
            if (s.getMuscleGroup() == Categories.WARMUP) {
                System.out.println("Warm up with: " + s.getName());
            }
            if (s.getMuscleGroup() == Categories.SHOULDERS) {
                System.out.println("\n" + s.getName());
            }
            if (s.getMuscleGroup() == Categories.RECOVERY) {
                System.out.println("\nCool down with: " + s.getName());
            }
        }
        System.out.println("Would you like to add this to your Favourites?");
        System.out.println("y - yes");
        System.out.println("n - no");
        Scanner yesNo = new Scanner(System.in);
        String input = yesNo.next();
        if (input.equals("y")) {
            favourites.addFavourites(shoulderWorkout);
            commandOption();
        } else {
            commandOption();
        }
    }

    public void printBackWorkout() {
        for (Exercise b : backWorkout.getBackExercises()) {
            if (b.getMuscleGroup() == Categories.WARMUP) {
                System.out.println("Warm up with: " + b.getName());
            }
            if (b.getMuscleGroup() == Categories.BACK) {
                System.out.println("\n" + b.getName());
            }
            if (b.getMuscleGroup() == Categories.RECOVERY) {
                System.out.println("\nCool down with: " + b.getName());
            }
        }
        System.out.println("Would you like to add this to your Favourites?");
        System.out.println("y - yes");
        System.out.println("n - no");
        Scanner yesNo = new Scanner(System.in);
        String input = yesNo.next();
        if (input.equals("y")) {
            favourites.addFavourites(backWorkout);
            commandOption();
        } else {
            commandOption();
        }
    }

    public void printAbWorkout() {
        for (Exercise ab : abWorkout.getAbdominalExercises()) {
            if (ab.getMuscleGroup() == Categories.WARMUP) {
                System.out.println("Warm up with: " + ab.getName());
            }
            if (ab.getMuscleGroup() == Categories.ABDOMINAL) {
                System.out.println("\n" + ab.getName());
            }
            if (ab.getMuscleGroup() == Categories.RECOVERY) {
                System.out.println("\nCool down with: " + ab.getName());
            }
        }
        System.out.println("Would you like to add this to your Favourites?");
        System.out.println("y - yes");
        System.out.println("n - no");
        Scanner yesNo = new Scanner(System.in);
        String input = yesNo.next();
        if (input.equals("y")) {
            favourites.addFavourites(abWorkout);
            commandOption();
        } else {
            commandOption();
        }
    }

    public void printLegWorkout() {
        for (Exercise l : legWorkout.getLegExercises()) {
            if (l.getMuscleGroup() == Categories.WARMUP) {
                System.out.println("Warm up with: " + l.getName());
            }
            if (l.getMuscleGroup() == Categories.LEGS) {
                System.out.println("\n" + l.getName());
            }
            if (l.getMuscleGroup() == Categories.RECOVERY) {
                System.out.println("\nCool down with: " + l.getName());
            }
        }
        System.out.println("Would you like to add this to your Favourites?");
        System.out.println("y - yes");
        System.out.println("n - no");
        Scanner yesNo = new Scanner(System.in);
        String input = yesNo.next();
        if (input.equals("y")) {
            favourites.addFavourites(legWorkout);
            commandOption();
        } else {
            commandOption();
        }
    }

    public void printEnduranceWorkout() {
        for (Exercise n : enduranceWorkout.getEnduranceExercises()) {
            if (n.getMuscleGroup() == Categories.WARMUP) {
                System.out.println("Warm up with: " + n.getName());
            }
            if (n.getMuscleGroup() == Categories.ENDURANCE) {
                System.out.println("\n" + n.getName());
            }
            if (n.getMuscleGroup() == Categories.RECOVERY) {
                System.out.println("\nCool down with: " + n.getName());
            }
        }
        System.out.println("Would you like to add this to your Favourites?");
        System.out.println("y - yes");
        System.out.println("n - no");
        Scanner yesNo = new Scanner(System.in);
        String input = yesNo.next();
        if (input.equals("y")) {
            favourites.addFavourites(enduranceWorkout);
            commandOption();
        } else {
            commandOption();
        }
    }

    // Effects: saves favourites to file
    private void saveFavourites() {
        try {
            jsonWriter.open();
            jsonWriter.write(favourites);
            jsonWriter.close();
            System.out.println("Saved " + favourites.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads favourites from file
    private void loadFavourites() {
        try {
            favourites = jsonReader.read();
            System.out.println("Loaded " + favourites.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to get favourites from file: " + JSON_STORE);
        }
    }

//    // Effects: saves favourites to file
//    private void saveProfile() {
//        try {
//            jsonSaver.open();
//            jsonSaver.write(myProfile);
//            jsonSaver.close();
//            System.out.println("Saved " + favourites.getName() + " to " + JSON_STORE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to save to file: " + JSON_STORE);
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: loads favourites from file
//    private void loadProfile() {
//        try {
//            favourites = jsonReader.read();
//            System.out.println("Loaded " + favourites.getName() + " from " + JSON_STORE);
//        } catch (IOException e) {
//            System.out.println("Unable to get favourites from file: " + JSON_STORE);
//        }
//    }

    // Chest Exercises
    Exercise pushUp = new Exercise("Push Ups", 2, 10, Categories.CHEST);
    Exercise inclinePushUp = new Exercise("Incline Push Ups", 2, 10, Categories.CHEST);
    Exercise widePushUp = new Exercise("Wide Push Ups", 2, 10, Categories.CHEST);
    Exercise trianglePushUp = new Exercise("Triangle Push Ups", 2, 10, Categories.CHEST);
    Exercise spiderManPushUp = new Exercise("Spider-Man Push Ups", 2, 10, Categories.CHEST);

    // Shoulder Exercises
    Exercise dumbbellLateralRaise =
            new Exercise("Dumbbell Lateral Raise", 2, 5, Categories.SHOULDERS);
    Exercise reverseFly = new Exercise("Reverse Fly", 2, 5, Categories.SHOULDERS);
    Exercise militaryPress = new Exercise("Military Press", 2, 10, Categories.SHOULDERS);

    // Arm Exercises
    Exercise curls = new Exercise("Arm Curls", 2, 10, Categories.ARMS);
    Exercise overheadTricep = new Exercise("Overhead Tricep Extension", 2, 12, Categories.ARMS);
    Exercise standingKickback = new Exercise("Standing Tricep Kickback", 3, 10, Categories.ARMS);
    Exercise hammerHeadCurls = new Exercise("Hammer Head Bicep Curls", 3, 10, Categories.ARMS);

    //AB Exercise
    Exercise sitUps = new Exercise("Sit-Ups", 3, 15, Categories.ABDOMINAL);
    Exercise flutterKicks = new Exercise("Flutter Kicks", 3, 50, Categories.ABDOMINAL);
    Exercise legRaise = new Exercise("Leg Raises", 3, 25, Categories.ABDOMINAL);
    Exercise twist = new Exercise("Sitting Twists", 3, 50, Categories.ABDOMINAL);

    //Back Exercise
    Exercise pullUps = new Exercise("Pull Ups", 3, 6, Categories.BACK);
    Exercise chinUps = new Exercise("Chin Ups", 3, 6, Categories.BACK);
    Exercise dumbbellRows = new Exercise("Bent Over Dumbbell Rows", 3, 10, Categories.BACK);
    Exercise bandRow = new Exercise("Bent Over Band Rows", 2, 15, Categories.BACK);

    //Leg Exercise
    Exercise squats = new Exercise("Squats", 3, 8, Categories.LEGS);
    Exercise jumpSquats = new Exercise("Jump Squats", 3, 15, Categories.LEGS);
    Exercise pistolSquats = new Exercise("Pistol Squats", 4, 6, Categories.LEGS);
    Exercise dumbbellDeadLift = new Exercise("Dumbbell Deadlift", 3, 10, Categories.LEGS);

    // Endurance Exercise
    DurationExercise running = new DurationExercise("Running", 45, 1, Categories.ENDURANCE);
    DurationExercise sprints = new DurationExercise("Sprints", 3, 3, Categories.ENDURANCE);
    DurationExercise swimming = new DurationExercise("Swimming", 30, 2, Categories.ENDURANCE);
    DurationExercise biking = new DurationExercise("Biking", 50, 1, Categories.ENDURANCE);

    //Warmup Exercise
    DurationExercise skipRope = new DurationExercise("Skip Rope", 3, 3, Categories.WARMUP);
    DurationExercise jogging =
            new DurationExercise("Moderate Pace Jogging", 10, 1, Categories.WARMUP);
    DurationExercise highKnees = new DurationExercise("High Knees", 1, 2, Categories.WARMUP);
    DurationExercise stairClimber = new DurationExercise("Stair Climber", 20, 1, Categories.WARMUP);

    // Recovery Exercise
    DurationExercise stretch = new
            DurationExercise("Stretching Concentrated Area of Workout", 15, 1, Categories.RECOVERY);
    Exercise walking = new
            DurationExercise("Walking", 5, 1, Categories.RECOVERY);
    Exercise yoga = new
            DurationExercise("Yoga! Nameste...", 40, 1, Categories.RECOVERY);
    DurationExercise iceBath = new DurationExercise("Ice Bath", 20, 1, Categories.RECOVERY);


}

