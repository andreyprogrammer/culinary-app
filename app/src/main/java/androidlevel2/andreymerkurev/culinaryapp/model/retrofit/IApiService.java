package androidlevel2.andreymerkurev.culinaryapp.model.retrofit;

import java.util.List;

import androidlevel2.andreymerkurev.culinaryapp.model.entity.Recipe;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiService {
    @GET("api/v1/recepies")
    Observable<List<Recipe>> getRecipes(@Query("format") String format);
}
