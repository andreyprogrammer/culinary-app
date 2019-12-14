package androidlevel2.andreymerkurev.culinaryapp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Recipes {
//    @Expose
//    @SerializedName("totalHits")
//    public int totalHits;

    @Expose
    @SerializedName("recipe")
    public List<Recipe> recipe;
}
