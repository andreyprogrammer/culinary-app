package androidportfolio.andreymerkurev.culinaryapp.presenter;

import android.util.Log;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import androidportfolio.andreymerkurev.culinaryapp.model.entity.Recipe;
import androidportfolio.andreymerkurev.culinaryapp.model.retrofit.ApiHelper;
import androidportfolio.andreymerkurev.culinaryapp.recyclerview.IRecyclerMainPresenter;
import androidportfolio.andreymerkurev.culinaryapp.recyclerview.IViewHolder;
import androidportfolio.andreymerkurev.culinaryapp.view.MainView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private String TAG = "app_log - MainPresenter ";
    private RecyclerMainPresenter recyclerMainPresenter;
    private List<Recipe> recipeList;

    @Inject
    ApiHelper apiHelper;

    public MainPresenter() {
        recyclerMainPresenter = new RecyclerMainPresenter();
    }

    public void getAllRecipesFromInternet() {
        Observable<List<Recipe>> single = apiHelper.requestServer();
        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(requestList -> {
            recipeList = requestList;
            for (Recipe recipe : requestList) {
                Log.d(TAG, "onNext: " + recipe.image);
            }
            getViewState().updateRecyclerView();
            //getViewState().setImage(recipeList);
        }, throwable -> {
            Log.e(TAG, "onError15: " + throwable);
        });
    }

    private class RecyclerMainPresenter implements IRecyclerMainPresenter {

        @Override
        public void bindView(IViewHolder holder) {
            holder.setImage(recipeList.get(holder.getPos()).image);
        }

        @Override
        public int getItemCount() {
            Log.d(TAG, "point getItemCount2");
            if (recipeList != null) {
                return recipeList.size();
            }
            return 0;
        }

//        @Override
//        public void onClick(View v, int position) {
//            getViewState().onClick(v, position, hitList);
//        }

    }

    public RecyclerMainPresenter getRecyclerMainPresenter() {
        return recyclerMainPresenter;
    }
}
