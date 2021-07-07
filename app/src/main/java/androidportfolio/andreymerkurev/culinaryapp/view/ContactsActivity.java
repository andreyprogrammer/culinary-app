package androidportfolio.andreymerkurev.culinaryapp.view;

import android.os.Bundle;

import androidportfolio.andreymerkurev.culinaryapp.R;
import moxy.MvpAppCompatActivity;

public class ContactsActivity extends MvpAppCompatActivity implements ContactsView{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
    }
}
