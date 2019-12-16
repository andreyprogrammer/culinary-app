package androidportfolio.andreymerkurev.culinaryapp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import androidportfolio.andreymerkurev.culinaryapp.R;
import androidportfolio.andreymerkurev.culinaryapp.app.App;
import androidportfolio.andreymerkurev.culinaryapp.presenter.MainPresenter;
import androidportfolio.andreymerkurev.culinaryapp.recyclerview.RecyclerViewAdapter;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class MainActivity extends MvpAppCompatActivity implements View.OnClickListener, MainView {
    //    private TextView textView;
    private static final String TAG = "app_log - MainActivity";
    private final int SPANCOUNT = 2;
    private RecyclerViewAdapter adapter;

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
//        textView = findViewById(R.id.tv);

        mainPresenter.getAllRecipesFromInternet();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, SPANCOUNT);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(mainPresenter.getRecyclerMainPresenter(), this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        return;
    }

//    @Override
//    public void onClick(View v, int position, List<Hit> hitList) {
//        Intent intent = new Intent(v.getContext(), DetailActivity.class);
//        intent.putExtra("POSITION", hitList.get(position).webformatURL);
//        startActivity(intent);
//    }

    @Override
    public void updateRecyclerView() {
        Log.d(TAG, "updateRecyclerView: ");
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setImage(List<Hit> hitList) {
        Log.d(TAG, "setImage: " + hitList);
    } //TODO
}