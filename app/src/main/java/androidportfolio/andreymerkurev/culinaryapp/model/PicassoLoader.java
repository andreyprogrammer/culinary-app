package androidportfolio.andreymerkurev.culinaryapp.model;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidportfolio.andreymerkurev.culinaryapp.R;

public class PicassoLoader {
    public void loadImage(String url, ImageView imageView) {
        Picasso
                .get()
                .load(url)
                .error(R.drawable.smile)
                .into(imageView);

    }
}
