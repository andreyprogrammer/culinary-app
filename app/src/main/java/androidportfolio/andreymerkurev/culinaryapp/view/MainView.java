package androidportfolio.andreymerkurev.culinaryapp.view;

import moxy.MvpView;
import moxy.viewstate.strategy.SkipStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface MainView extends MvpView {
    @StateStrategyType(value = SkipStrategy.class)
    void updateRecyclerView();

//    @StateStrategyType(value = SkipStrategy.class)
//    void setImage(List<Recipe> recipeList);

}
