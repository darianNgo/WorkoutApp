// Citation: https://github.com/stleary/JSON-java.git

package persistenceTest;

import model.Favourites;
import model.workout.Categories;
import model.workout.Workout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonRead;
import persistence.JsonWrite;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends FavTest {
    private Favourites fav;

    @BeforeEach
    void runBefore() {
        fav = new Favourites("My Favourite Workouts");
    }

    @Test
    void testFavWriterInvalidFile() {
        try {
            JsonWrite writer = new JsonWrite("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // expected
        }
    }

    @Test
    void testWriterEmptyFavourites() {
        try {
            JsonWrite writer = new JsonWrite("./data/testWriterEmptyFavourites.json");
            writer.open();
            writer.write(fav);
            writer.close();

            JsonRead reader = new JsonRead("./data/testWriterEmptyFavourites.json");
            fav = reader.read();
            assertEquals("My  Workouts", fav.getName());
            assertEquals(0, fav.getNumOfWorkouts());
        } catch (IOException e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    void testWriterFavourites() {
        try {
            fav.addFavourites(new Workout("Chest", Categories.CHEST));
            fav.addFavourites(new Workout("Arms", Categories.ARMS));
            JsonWrite writer = new JsonWrite("./data/testWriterFavourites.json");
            writer.open();
            writer.write(fav);
            writer.close();

            JsonRead reader = new JsonRead("./data/testWriterFavourites.json");
            fav = reader.read();
            assertEquals("My Favourite Workouts", fav.getName());
            List<Workout> favourites = fav.getFavourites();
            assertEquals(2, favourites.size());
            checkWorkout("Chest", Categories.CHEST, favourites.get(0));
            checkWorkout("Arms", Categories.ARMS, favourites.get(1));

        } catch (IOException e) {
            fail("Exception should not be thrown");
        }
    }
}
