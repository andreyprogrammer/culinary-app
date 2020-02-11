package androidportfolio.andreymerkurev.culinaryapp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recipe {
    @Expose
    @SerializedName("id")
    public int id;

    @Expose
    @SerializedName("name")
    public String name;

    @Expose
    @SerializedName("description")
    public String description;

    @Expose
    @SerializedName("level")
    public int level;

    @Expose
    @SerializedName("duration")
    public int duration;

    @Expose
    @SerializedName("image")
    public String image;

    @Expose
    @SerializedName("cuisine")
    public int cuisine;
}
