package androidportfolio.andreymerkurev.culinaryapp.app;

import android.app.Application;

public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = generateAppComponent();
//        appDatabase = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class, "room_database").build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public AppComponent generateAppComponent() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
