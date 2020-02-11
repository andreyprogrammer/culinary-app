package androidportfolio.andreymerkurev.culinaryapp.recyclerview;

public interface IViewHolder {
    int getPos();
    void setImage(String url);
    void setTitle(String title);
    void setDescription(String description);
    void setDuration(int duration);
    void setLevel(int level);
}
