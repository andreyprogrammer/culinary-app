package androidlevel2.andreymerkurev.culinaryapp.presenter;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import androidlevel2.andreymerkurev.culinaryapp.model.entity.Recipe;
import androidlevel2.andreymerkurev.culinaryapp.model.retrofit.ApiHelper;
import androidlevel2.andreymerkurev.culinaryapp.view.MainView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private String TAG = "MainActivity";

    @Inject
    ApiHelper apiHelper;

    public void getAllRecipesFromInternet() {
        Observable<List<Recipe>> single = apiHelper.requestServer();
        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(recipeList -> {

            for (Recipe recipe : recipeList) {
                Log.d(TAG, "onNext: " + recipe.image);
            }

        }, throwable -> {
            Log.e(TAG, "onError: " + throwable);
        });
    }
}
