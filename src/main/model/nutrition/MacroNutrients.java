package model.nutrition;

public class MacroNutrients {
    private int calories;
    private int protein;
    private int carbohydrates;
    private int fats;

    public MacroNutrients(int protein, int carbohydrates, int fats) {
        this.calories = calories;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
    }

    // EFFECTS: gets caloric intake, which is protein(in grams) x 4 + carbs(in grams) x 4 + fats(in grams) x 9
    public int getCalories() {
        return this.calories += ((this.protein * 4) + (this.carbohydrates * 4) + (this.fats * 9));
    }

    public int getProtein() {
        return  protein;
    }

    public int getCarbohydrates() {
        return  carbohydrates;
    }

    public int getFats() {
        return  fats;
    }

    // MODIFIES: This, caloricIntake
    // EFFECTS: adds protein in grams
    public int addProtein(double grams) {
        return this.protein += grams;
    }

    // MODIFIES: This, caloricIntake
    // EFFECTS: adds carbs in grams
    public int addCarbs(double grams) {
        return this.carbohydrates += grams;
    }

    // MODIFIES: This, caloricIntake
    // EFFECTS: adds fats in grams
    public int addFats(double grams) {
        return this.fats += grams;
    }

    // MODIFIES: This, caloricIntake
    // EFFECTS: adds protein in grams
    public int removeProtein(double grams) {
        return this.protein -= grams;
    }

    // MODIFIES: This, caloricIntake
    // EFFECTS: adds carbs in grams
    public int removeCarbs(double grams) {
        return this.carbohydrates -= grams;
    }

    // MODIFIES: This, caloricIntake
    // EFFECTS: adds fats in grams
    public int removeFats(double grams) {
        return this.fats -= grams;
    }

}
