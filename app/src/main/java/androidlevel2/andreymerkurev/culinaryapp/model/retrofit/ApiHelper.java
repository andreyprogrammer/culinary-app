package androidlevel2.andreymerkurev.culinaryapp.model.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import androidlevel2.andreymerkurev.culinaryapp.model.entity.Recipes;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    public Observable<Recipes> requestServer() {
        final String FORMAT = "json";
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        IApiService api = new Retrofit.Builder()
                .baseUrl("https://185.189.13.46.xip.io")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(IApiService.class);
        return api.getRecipes(FORMAT).subscribeOn(Schedulers.io());
    }
}
