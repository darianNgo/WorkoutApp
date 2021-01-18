package persistenceTest;

import model.Favourites;
import model.workout.Categories;
import model.workout.Workout;
import org.junit.jupiter.api.Test;
import persistence.JsonRead;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Citation: https://github.com/stleary/JSON-java.git
public class JsonReaderTest extends FavTest {

    @Test
    void testReaderNonExistentFile() {
        JsonRead reader = new JsonRead("./data/noSuchFile.json");
        try {
            Favourites f = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // expected
        }
    }

    @Test
    void testReaderEmptyFavourites() {
        JsonRead reader = new JsonRead("./data/testReaderEmptyFavourites.json");
        try {
            Favourites f = reader.read();
            assertEquals("My favourite Workouts", f.getName());
            assertEquals(0, f.getNumOfWorkouts());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderFavourites() {
        JsonRead reader = new JsonRead("./data/testReaderGeneralFavourites.json");
        try {
            Favourites f = reader.read();
            assertEquals("My Favourite Workouts", f.getName());
            List<Workout> favourites = f.getFavourites();
            assertEquals(2, favourites.size());
            checkWorkout("Chest", Categories.CHEST, favourites.get(0));
            checkWorkout("Arms", Categories.ARMS, favourites.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file :(");
        }
    }
}


