package x.chestnut.weather.v.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidadvance.topsnackbar.TSnackbar;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import x.chestnut.weather.R;
import x.chestnut.weather.m.web.Net;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TSnackbar.make(findViewById(android.R.id.content),"Hello from TSnackBar.",TSnackbar.LENGTH_LONG).show();
        Net.searchCity("广")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aBoolean -> {
                });
    }
}
