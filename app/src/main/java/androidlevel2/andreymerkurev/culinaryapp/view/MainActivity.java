package androidlevel2.andreymerkurev.culinaryapp.view;

import android.os.Bundle;
import android.widget.TextView;

import androidlevel2.andreymerkurev.culinaryapp.R;
import androidlevel2.andreymerkurev.culinaryapp.app.App;
import androidlevel2.andreymerkurev.culinaryapp.model.retrofit.ApiHelper;
import androidlevel2.andreymerkurev.culinaryapp.presenter.MainPresenter;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    private TextView textView;

    @InjectPresenter
    MainPresenter mainPresenter;

    @ProvidePresenter
    public MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getAppComponent().inject(mainPresenter);
        textView = findViewById(R.id.tv);

        mainPresenter.getAllRecipesFromInternet();
    }


}
