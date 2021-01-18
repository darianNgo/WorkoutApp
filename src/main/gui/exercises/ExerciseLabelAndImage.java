package gui.exercises;

import org.json.JSONObject;
import persistence.Writable;

public class ExerciseLabelAndImage implements Writable {
    private final String name;
    private final String imageIcon;

    public ExerciseLabelAndImage(String name, String imageIcon) {
        this.name = name;
        this.imageIcon = imageIcon;
    }

    public String getName() {
        return this.name;
    }

    public String getImageIcon() {
        return this.imageIcon;
    }

    @Override
    public JSONObject toFav() {
        JSONObject fav = new JSONObject();
        fav.put("name", name);
        fav.put("Icon", imageIcon);
        return fav;
    }

}
