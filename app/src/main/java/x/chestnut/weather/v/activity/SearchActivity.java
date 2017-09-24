package x.chestnut.weather.v.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import x.chestnut.weather.R;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
