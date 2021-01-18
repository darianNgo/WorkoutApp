// Citation: https://github.com/stleary/JSON-java.git

package persistence;

import model.Favourites;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// a writer that writes JSON representation of Favourites to files
public class JsonWrite {
    private PrintWriter marker;
    private String fileDestination;

    // Effects: makes a marker to write to destination
    public JsonWrite(String fileDestination) {
        this.fileDestination = fileDestination;
    }

    // Modifies: this
    // effects: opens marker and throws FileNotFoundException if fileDestination cannot
    // be opened to save favourite
    public void open() throws FileNotFoundException {
        marker = new PrintWriter(new File(fileDestination));
    }

    // Modifies: this
    // effects: writes JSON representation of favourites to file
    public void write(Favourites f) {
        JSONObject fav = f.toFav();
        saveToFile(fav.toString(2));
    }


    // Modifies: this
    // effects: writes JSON representation of favourites to file
    public void writeExercise(Favourites f) {
        JSONObject fav = f.toFavExercise();
        saveToFile(fav.toString(2));
    }

//    // Modifies: this
//    // effects: writes JSON representation of favourites to file
//    public void writeGui(SavedWorkoutsGui swg) {
//        JSONObject fav = swg.toFav();
//        saveToFile(fav.toString(2));
//    }

//    // Modifies: this !!!
//    // effects: writes JSON representation of favourites to file
//    public void save(Profile p) {
//        JSONObject fav = p.toFav();
//        saveToFile(fav.toString(2));
//    }

    // Modifies: this
    // effects: closes marker
    public void close() {
        marker.close();
    }

    // Modifies: this
    // effects: string to file
    private void saveToFile(String fav) {
        marker.print(fav);
    }
}
