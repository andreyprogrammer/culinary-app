package androidportfolio.andreymerkurev.culinaryapp.presenter;

import android.util.Log;

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
            getViewState().updateRecyclerView();
        }, throwable -> {
            Log.e(TAG, "onError15: " + throwable);
        });
    }

    private class RecyclerMainPresenter implements IRecyclerMainPresenter {

        @Override
        public void bindView(IViewHolder holder) {
            holder.setImage(recipeList.get(holder.getPos()).image);
            holder.setTitle(recipeList.get(holder.getPos()).name);
            holder.setDescription(recipeList.get(holder.getPos()).description);
            holder.setDuration(recipeList.get(holder.getPos()).duration);
            holder.setLevel(recipeList.get(holder.getPos()).level);
        }

        @Override
        public int getItemCount() {
            if (recipeList != null) {
                return recipeList.size();
            }
            return 0;
        }
    }

    public RecyclerMainPresenter getRecyclerMainPresenter() {
        return recyclerMainPresenter;
    }
}
