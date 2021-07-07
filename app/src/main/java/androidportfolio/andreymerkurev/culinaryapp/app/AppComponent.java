package androidportfolio.andreymerkurev.culinaryapp.app;

import javax.inject.Singleton;

import androidportfolio.andreymerkurev.culinaryapp.presenter.MainPresenter;
import androidportfolio.andreymerkurev.culinaryapp.recyclerview.RecyclerViewAdapter;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainPresenter mainPresenter);
    void inject(RecyclerViewAdapter recyclerViewAdapter);
}
