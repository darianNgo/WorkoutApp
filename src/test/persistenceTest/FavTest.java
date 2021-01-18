// Citation: https://github.com/stleary/JSON-java.git

package persistenceTest;

import model.workout.Categories;
import model.workout.Workout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FavTest {
    protected void checkWorkout(String name, Categories category, Workout workout) {
        assertEquals(name, workout.getName());
        assertEquals(category, workout.getCategory());
    }
}
