package model;

import model.nutrition.MacroNutrients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MacroNutrientsTest {
    private int testCaloricIntake;
    private int testProtein;
    private int testCarbohydrates;
    private int testFats;
    private MacroNutrients testMacroNutrient;

    @BeforeEach
    public void runBefore() {testMacroNutrient = new MacroNutrients(testProtein, testCarbohydrates, testFats); }

    @Test
    public void testGetCaloricIntakeEmpty() {
        assertEquals(0, testMacroNutrient.getCalories());
    }

    @Test
    public void testGetCaloricIntakeProtein() {
        testMacroNutrient.addProtein(10);

        assertEquals(40, testMacroNutrient.getCalories());
    }

    @Test
    public void testGetCaloricIntakeCarbs() {
        testMacroNutrient.addCarbs(10);

        assertEquals(40, testMacroNutrient.getCalories());
    }

    @Test
    public void testGetCaloricIntakeFats() {
        testMacroNutrient.addFats(10);

        assertEquals(90, testMacroNutrient.getCalories());
    }

    @Test
    public void testGetCaloricIntake() {
        testMacroNutrient.addProtein(10);
        testMacroNutrient.addCarbs(10);
        testMacroNutrient.addFats(10);

        assertEquals(170, testMacroNutrient.getCalories());
    }

}
