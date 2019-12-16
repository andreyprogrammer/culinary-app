package androidportfolio.andreymerkurev.culinaryapp.view;

import android.view.View;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.SkipStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface MainView extends MvpView {
    @StateStrategyType(value = SkipStrategy.class)
    void updateRecyclerView();

    @StateStrategyType(value = SkipStrategy.class)
    void setImage(List<Hit> hitList); //TODO

//    @StateStrategyType(value = SkipStrategy.class)
//    void onClick(View v, int position, List<Hit> hitList);
}
