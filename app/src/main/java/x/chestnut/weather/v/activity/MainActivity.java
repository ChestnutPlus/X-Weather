package x.chestnut.weather.v.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.chestnut.Common.utils.BarUtils;
import com.chestnut.Common.utils.ConvertUtils;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator;

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
        BarUtils.setTransparentStatusBar(this);
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

        //btn-search
        findViewById(R.id.txt_add).setOnClickListener(view -> {
            Intent intent = new Intent(this,SearchActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
            startActivity(intent);
        });

        //vp指示器
        MagicIndicator magicIndicator = (MagicIndicator) findViewById(R.id.magic_indicator);
        CircleNavigator circleNavigator = new CircleNavigator(this);
        circleNavigator.setCircleCount(fragments.size());
        circleNavigator.setCircleColor(Color.rgb(116,184,255));
        circleNavigator.setCircleClickListener(vp::setCurrentItem);
        circleNavigator.setRadius(ConvertUtils.dp2px(this,2));
        circleNavigator.setCircleSpacing(ConvertUtils.dp2px(this,7));
        magicIndicator.setNavigator(circleNavigator);
        ViewPagerHelper.bind(magicIndicator, vp);
    }
}
