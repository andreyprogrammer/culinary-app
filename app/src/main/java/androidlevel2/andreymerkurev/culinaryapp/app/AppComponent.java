package androidlevel2.andreymerkurev.culinaryapp.app;

import javax.inject.Singleton;

import androidlevel2.andreymerkurev.culinaryapp.presenter.MainPresenter;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainPresenter mainPresenter);
}
