package x.chestnut.weather.v.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import x.chestnut.weather.R;
import x.chestnut.weather.v.fragment.FragAdapter;
import x.chestnut.weather.v.fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //构造适配器
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(WeatherFragment.get("深圳"));
        fragments.add(WeatherFragment.get("广州"));
        fragments.add(WeatherFragment.get("北京"));
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(), fragments);

        //设定适配器
        ViewPager vp = (ViewPager)findViewById(R.id.view_pager);
        vp.setAdapter(adapter);
    }
}
