package androidlevel2.andreymerkurev.culinaryapp.app;

import android.app.Application;

import javax.inject.Singleton;

import androidlevel2.andreymerkurev.culinaryapp.model.retrofit.ApiHelper;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    ApiHelper provideApiHelper() {
        return new ApiHelper();
    }

//    @Singleton
//    @Provides
//    PicassoLoader providePicassoLoader() {
//        return new PicassoLoader();
//    }

//    @Singleton
//    @Provides
//    AppDatabase provideAppDatabase() {
//        return App.getAppDatabase();
//    }
}
