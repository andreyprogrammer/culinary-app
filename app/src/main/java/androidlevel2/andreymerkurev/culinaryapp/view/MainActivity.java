package androidlevel2.andreymerkurev.culinaryapp.view;

import android.os.Bundle;

import androidlevel2.andreymerkurev.culinaryapp.R;
import moxy.MvpAppCompatActivity;

public class MainActivity extends MvpAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
