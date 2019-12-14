package androidlevel2.andreymerkurev.culinaryapp.model.retrofit;

import androidlevel2.andreymerkurev.culinaryapp.model.entity.Recipes;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiService {
//    @GET("api")
//    Observable<Photo> getRecipes(@Query("key") String key);
    //https://185.189.13.46.xip.io/api/v1/recepies/?format=json

    @GET("api/v1/recepies")
    Observable<Recipes> getRecipes(@Query("format") String format);
}
