package androidportfolio.andreymerkurev.culinaryapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidportfolio.andreymerkurev.culinaryapp.R;
import androidportfolio.andreymerkurev.culinaryapp.app.App;
import androidportfolio.andreymerkurev.culinaryapp.presenter.MainPresenter;
import androidportfolio.andreymerkurev.culinaryapp.recyclerview.RecyclerViewAdapter;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    private final int SPANCOUNT = 1;
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
        initRecyclerView();
        mainPresenter.getAllRecipesFromInternet();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, SPANCOUNT);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(mainPresenter.getRecyclerMainPresenter());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                aboutProject();
                return true;
            case R.id.menu_contacts:
                contacts();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void updateRecyclerView() {
        adapter.notifyDataSetChanged();
    }

    public void aboutProject() {
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }

    public void contacts() {
        Intent intent = new Intent(getApplicationContext(), ContactsActivity.class);
        startActivity(intent);
    }
}
