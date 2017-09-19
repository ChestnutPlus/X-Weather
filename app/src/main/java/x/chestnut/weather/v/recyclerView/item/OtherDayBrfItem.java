package x.chestnut.weather.v.recyclerView.item;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chestnut.Common.ui.recyclerView.XHolder;
import com.chestnut.Common.ui.recyclerView.XItem;

import x.chestnut.weather.R;
import x.chestnut.weather.m.bean.WBean;
import x.chestnut.weather.v.recyclerView.adapter.SimpleAdapter;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/19 23:11
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class OtherDayBrfItem extends XItem<WBean.DailyForecastBean>{

    public OtherDayBrfItem(WBean.DailyForecastBean dailyForecastBean) {
        super(dailyForecastBean);
    }

    @Override
    public XHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new XHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_other_day_brf,null));
    }

    @Override
    public void onBindViewHolder(XHolder xHolder, int i) {
        //data
        ((TextView)xHolder.getViewById(R.id.txt_data)).setText(data.date);
        //brf
        ((TextView)xHolder.getViewById(R.id.txt_weather_brf)).setText(data.txt);
        //max min temp
        ((TextView)xHolder.getViewById(R.id.txt_max_min_temp)).setText(data.maxTemp+"° / "+data.minTemp+"°");
    }

    @Override
    public int getItemType() {
        return SimpleAdapter.TYPE_ITEM_OTHER_DAY_BRF;
    }

    @Override
    public void releaseRes() {

    }
}
