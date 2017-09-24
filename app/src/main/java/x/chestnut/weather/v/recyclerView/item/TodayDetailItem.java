package x.chestnut.weather.v.recyclerView.item;

import android.content.Context;
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
 *     time  : 2017/9/24 10:43
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class TodayDetailItem extends XItem<WBean>{

    public TodayDetailItem(WBean wBean) {
        super(wBean);
    }

    @Override
    public XHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new XHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_today_detail,null));
    }

    @Override
    public void onBindViewHolder(XHolder xHolder, int i) {
        Context context = xHolder.getItemHoldView().getContext();
        ((TextView)xHolder.getViewById(R.id.txt_temp))
                .setText(context.getString(R.string.item_today_detail_temp).replace("{x}",data.today.feltAirTemperature));
        ((TextView)xHolder.getViewById(R.id.txt_shidu))
                .setText(context.getString(R.string.item_today_detail_shidu).replace("{x}",data.today.relativeHumidity));
        ((TextView)xHolder.getViewById(R.id.txt_pressure))
                .setText(context.getString(R.string.item_today_detail_pre).replace("{x}",data.today.pressure));
        ((TextView)xHolder.getViewById(R.id.txt_precipitation))
                .setText(context.getString(R.string.item_today_detail_rain).replace("{x}",data.today.precipitation));
        ((TextView)xHolder.getViewById(R.id.txt_wind_speed))
                .setText(context.getString(R.string.item_today_detail_wind_speed).replace("{x}",data.today.windSpeed));
        ((TextView)xHolder.getViewById(R.id.txt_vis))
                .setText(context.getString(R.string.item_today_detail_vis).replace("{x}",data.today.visibilityKm));
    }

    @Override
    public int getItemType() {
        return SimpleAdapter.TYPE_ITEM_TODAY_DETAIL;
    }

    @Override
    public void releaseRes() {

    }
}
